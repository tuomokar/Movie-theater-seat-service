package seatservice.userinterface.logic;

import seatservice.filehandling.HallHandler;
import seatservice.userinterface.listeners.HallNamesListener;
import seatservice.domain.Hall;
import seatservice.domain.Seat;
import seatservice.userinterface.command.Command;
import seatservice.userinterface.listeners.ClickListener;

import java.util.List;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;

/**
 * This class is responsible for handling the logic of the user interface. The
 * class handles any possible error messages by using an instance of the
 * <code>InputErrorHandler</code> class and makes other checks, such as has the
 * user selected any hall when trying to show the visual representation of the
 * halls in the customer serving tab in the UI.
 *
 * @author Tuomo Oila
 */
public class UILogicHandler {

    private HallHandler hallHandler;
    private InputErrorHandler inputErrorHandler;
    private HallNamesListener hallNamesListener;

    private JTable hallInfoTable;
    private JLabel hallNameErrorLabel;
    private JList hallNamesList1;
    private JList hallNamesList2;
    private JScrollPane hallSituationScrollPane;
    private JTextField hallsNameTextField;
    private JLabel rowsErrorLabel;
    private JTextField rowsTextField;
    private JLabel seatsErrorLabel;
    private JTextField seatsTextField;

    /**
     *
     * @param hallInfoTable
     * @param hallNameErrorLabel
     * @param hallNamesList1
     * @param hallNamesList2
     * @param hallSituationScrollPane
     * @param hallsNameTextField
     * @param rowsErrorLabel
     * @param rowsTextField
     * @param seatsErrorLabel
     * @param seatsTextField
     * @param hallNamesListener
     */
    public UILogicHandler(
            JTable hallInfoTable,
            JLabel hallNameErrorLabel,
            JList hallNamesList1,
            JList hallNamesList2,
            JScrollPane hallSituationScrollPane,
            JTextField hallsNameTextField,
            JLabel rowsErrorLabel,
            JTextField rowsTextField,
            JLabel seatsErrorLabel,
            JTextField seatsTextField,
            HallNamesListener hallNamesListener) {

        hallHandler = new HallHandler();
        hallHandler.readFile();

        this.hallInfoTable = hallInfoTable;
        this.hallNameErrorLabel = hallNameErrorLabel;
        this.hallNamesList1 = hallNamesList1;
        this.hallNamesList2 = hallNamesList2;
        this.hallSituationScrollPane = hallSituationScrollPane;
        this.hallsNameTextField = hallsNameTextField;
        this.rowsErrorLabel = rowsErrorLabel;
        this.rowsTextField = rowsTextField;
        this.seatsErrorLabel = seatsErrorLabel;
        this.seatsTextField = seatsTextField;
        this.hallNamesListener = hallNamesListener;
        addSelectionListenerToHallNames();

        createInputErrorHandler();

        fillHallNames();
        fillNamesTable();

    }

    /**
     * Adds a hall with the information the user gave. The method starts out by
     * emptying any former input error labels and then trims the hall-to-be's
     * name and takes into a variable. The method then checks that all the
     * values are valid, i.e. that any of the values given are not empty and
     * that the rows and seats are integers and above zero. If these checks are
     * passed, the method adds a new hall with the given values and finally
     * updates all the necessary fields to reflect the new situation of having
     * one more hall.
     */
    public void addHall() {
        emptyErrorLabels();
        String name = hallsNameTextField.getText().trim();

        if (!valuesAreValidWhenAddingOrUpdating(name, Command.ADD)) {
            return;
        }

        int rows = Integer.parseInt(rowsTextField.getText());
        int seats = Integer.parseInt(seatsTextField.getText());

        hallHandler.addNewHall(name, rows, seats);

        updateFieldsListAndTables();
    }

    private boolean valuesAreValidWhenAddingOrUpdating(String name, Command command) {
        if (inputErrorHandler.anyNewHallValueIsEmpty(name)) {
            return false;
        }

        boolean invalidValueFound = true;

        boolean hallExistsAlready = inputErrorHandler.hallExistsAlready(name, command);
        if (hallExistsAlready && command == Command.ADD) {
            invalidValueFound = false;
        } else if (!hallExistsAlready && command == Command.UPDATE) {
            invalidValueFound = false;
        }

        if (!inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero()) {
            invalidValueFound = false;
        }

        return invalidValueFound;
    }

    /**
     * Removes the hall that was chosen by the user. The method firsts checks if
     * there are any halls to begin with and if not, returns. Then the method
     * checks if the user has selected any hall and again, returns if not. Then
     * the method confirms that the user really wants to remove the hall and if
     * the user either closes the window or presses no, the method returns. If
     * the method gets through all these checks, then the selected hall is
     * removed and the appropriate fields are updated to reflect the new
     * situation having one less hall to be shown.
     */
    public void removeHall() {
        if (hallHandler.getHallsAsList().isEmpty()) {
            return;
        }

        if (hallNamesListener.getSelectedName() == null) {
            return;
        }

        if (!confirmUsersAction(Command.REMOVE)) {
            return;
        }

        removeSelectedHall();
        updateFieldsListAndTables();
    }

    /**
     * This method is responsible for showing the chosen hall's seats as a
     * visual representation. The method start by reseting the viewport view to
     * null. Then checks are made for halls not existing and user not having
     * chosen any hall to be shown. If either of these terms are true, the
     * method returns. If not, the method checks if the method caller wants to
     * reset the seats of the hall to available state and if so, does it. The
     * method then continues by finding the hall that matches the name that the
     * user chose and removes any possible action listeners that it might have
     * to make sure there are no duplicate listeners. The method then creates a
     * grid layout with the necessary size to show every seat of the hall and
     * sets this layout for the <code>buttons</code> <code>JPanel</code>. Then
     * the method adds an action listener for each seat and puts the seats into
     * the <code>buttons</code> <code>JPanel</code>. Finally, the
     * <code>JPanel</code> is set as the viewport view of the appropriate
     * <code>JScrollPane</code>
     *
     * @param command enum that defines the use purpose of this method, i.e. is
     * the method called to simply show the chosen hall's seats or is it meant
     * to reset the hall's seats to available
     */
    public void showOrResetView(Command command) {
        hallSituationScrollPane.setViewportView(null);
        if (noHallsExist()) {
            return;
        }
        if (selectedNameIsNull()) {
            return;
        }

        String selectedHall = hallNamesListener.getSelectedName();
        Hall hall = hallHandler.findHallByName(selectedHall);

        if (command == Command.RESET) {
            hall.resetSeatsToAvailable();
        }
        setViewportView(hall);
    }

    /**
     * This method is responsible for updating a hall's information. The method
     * starts out by trimming the given hall's name and taking it to variable.
     * Then checks are made that the all the given input is valid (values not
     * empty and rows and seats must be integers and above zero) and that the
     * user really wants to update the hall's information. If both of these are
     * passed, the hall in question is updated and all the appropriate fields
     * are updated to reflect the new situation of having the hall updated.
     */
    public void updateHallsInformation() {
        emptyErrorLabels();
        String name = hallsNameTextField.getText().trim();

        if (!valuesAreValidWhenAddingOrUpdating(name, Command.UPDATE)) {
            return;
        }

        if (!confirmUsersAction(Command.UPDATE)) {
            return;
        }

        int newRows = Integer.parseInt(rowsTextField.getText());
        int newSeats = Integer.parseInt(seatsTextField.getText());

        hallHandler.updateHall(name, newRows, newSeats);
        updateFieldsListAndTables();
    }

    private void setViewportView(Hall hall) {
        Map<Integer, Map<Integer, Seat>> seats = hall.getSeats();

        removeListeners(seats, hall);
        GridLayout layout = new GridLayout(seats.size(), seats.get(1).size());

        JPanel buttons = new JPanel();
        buttons.setLayout(layout);
        addListenersToSeatsAndSeatsToPanel(buttons, seats, hall);

        hallSituationScrollPane.setViewportView(buttons);
    }

    private void removeListeners(
            Map<Integer, Map<Integer, Seat>> seats,
            Hall hall) {

        for (int row = seats.size(); row >= 1; row--) {
            for (int seatsPlace = 1; seatsPlace <= seats.get(1).size(); seatsPlace++) {
                Seat seat = hall.getSeat(row, seatsPlace);
                if (seat.getActionListeners().length == 0) {
                    break;
                }

                ActionListener listener = seat.getActionListeners()[0];
                seat.removeActionListener(listener);
            }
        }
    }

    private void addListenersToSeatsAndSeatsToPanel(JPanel buttons,
            Map<Integer, Map<Integer, Seat>> seats,
            Hall hall) {

        for (int row = seats.size(); row >= 1; row--) {
            for (int seatsPlace = 1; seatsPlace <= seats.get(1).size(); seatsPlace++) {
                Seat seat = hall.getSeat(row, seatsPlace);
                seat.addActionListener(new ClickListener());
                seat.setText("<html>r" + row + "<br>" + seatsPlace + "</html");
                buttons.add(seat);
            }
        }
    }

    private boolean noHallsExist() {
        return hallHandler.getHallsAsList().isEmpty();
    }

    private boolean selectedNameIsNull() {
        return hallNamesListener.getSelectedName() == null;
    }

    private boolean confirmUsersAction(Command command) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        int response = 9999991;

        if (command == Command.UPDATE) {
            response = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to update this hall?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        } else if (command == Command.REMOVE) {

            response = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to remove this hall?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
        return response == JOptionPane.YES_OPTION;
    }

    private void updateFieldsListAndTables() {
        emptyAllFieldsAndLabels();
        fillHallNames();
        fillNamesTable();
    }

    private void fillHallNames() {
        DefaultListModel hallNamesModel = new DefaultListModel();
        for (int i = 0; i < hallHandler.getHallsAsList().size(); i++) {
            hallNamesModel.addElement(hallHandler.getHallsAsList().get(i).getName());
        }
        hallNamesList1.setModel(hallNamesModel);
        hallNamesList2.setModel(hallNamesModel);
    }

    private void emptyAllFieldsAndLabels() {
        emptyTextFields();
        emptyErrorLabels();
    }

    private void fillNamesTable() {

        List<Hall> halls = hallHandler.getHallsAsList();
        int size = hallHandler.getHallsAsList().size();

        DefaultTableModel tableModel = new DefaultTableModel(0, size);

        String header[] = new String[]{"Name", "Rows", "Seats on a row",
            "Seats in total"};

        tableModel.setColumnIdentifiers(header);

        for (int i = 0; i < size; i++) {

            String[] row = new String[4];
            Hall hall = halls.get(i);

            String name = hall.getName();
            Integer rows = hall.getAmountOfRows();
            Integer seats = hall.getAmountOfRows();
            Integer totalSeats = hall.getTheTotalAmountOfSeats();

            row[0] = name;
            row[1] = rows.toString();
            row[2] = seats.toString();
            row[3] = totalSeats.toString();
            tableModel.addRow(row);

        }
        hallInfoTable.getColumnModel().getColumn(0).setResizable(true);
        hallInfoTable.setModel(tableModel);
    }

    private void removeSelectedHall() {
        String selectedHall = this.hallNamesListener.getSelectedName();
        hallHandler.removeHall(selectedHall);
        hallNamesListener.resetSelection();
    }

    private void emptyTextFields() {
        hallsNameTextField.setText("");
        rowsTextField.setText("");
        seatsTextField.setText("");
    }

    private void emptyErrorLabels() {
        hallNameErrorLabel.setText("");
        rowsErrorLabel.setText("");
        seatsErrorLabel.setText("");
    }

    private void createInputErrorHandler() {
        inputErrorHandler = new InputErrorHandler(
                hallNameErrorLabel,
                rowsErrorLabel,
                seatsErrorLabel,
                hallsNameTextField,
                rowsTextField,
                seatsTextField,
                hallHandler);
    }

    private void addSelectionListenerToHallNames() {
        hallNamesList1.addListSelectionListener(hallNamesListener);
        hallNamesList2.addListSelectionListener(hallNamesListener);
    }

}
