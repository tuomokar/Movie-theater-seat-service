package seatservice.userinterface.inputerrorhandler;

import seatservice.filehandling.HallHandler;

import javax.swing.JLabel;
import javax.swing.JTextField;
import seatservice.userinterface.command.Command;

/**
 * This class checks if the user input is faulty and if it is, lets the user
 * know of it
 */
public class InputErrorHandler {

    private JLabel hallNameErrorLabel;
    private JLabel rowsErrorLabel;
    private JLabel seatsErrorLabel;
    private JTextField hallNameTextField;
    private JTextField rowsTextField;
    private JTextField seatsTextField;
    private HallHandler hallHandler;

    public InputErrorHandler(JLabel hallNameErrorErrorLabel,
            JLabel rowErrorErrorLabel,
            JLabel seatsErrorLabel,
            JTextField hallNameTextField,
            JTextField rowsTextField,
            JTextField seatsTextField,
            HallHandler hallHandler) {

        this.hallNameErrorLabel = hallNameErrorErrorLabel;
        this.rowsErrorLabel = rowErrorErrorLabel;
        this.seatsErrorLabel = seatsErrorLabel;
        this.hallNameTextField = hallNameTextField;
        this.rowsTextField = rowsTextField;
        this.seatsTextField = seatsTextField;
        this.hallHandler = hallHandler;
    }

    /**
     * Checks if any of the values in the text fields are empty. If any empty
     * values are found, the method sets the corresponding error message to the
     * error label and once all the error messages are set, the method returns
     * false. If no empty values are found, then the method returns true. The
     * name is the only parameter that the method gets as the other values are
     * needed to be parsed to integers elsewhere, whereas the name is not needed
     * to be parsed, and thus it's simpler to give the name as the parameter to
     * avoid having to get it from the text field and trim it at every point
     *
     * @param name the name of the hall to be added or updated
     * @return true if no empty values in the text fields are found
     */
    public boolean anyNewHallValueIsEmpty(String name) {
        int i = 0;

        if (name.isEmpty()) {
            hallNameErrorLabel.setText("Name must not be empty!");
            i++;
        }

        if (rowsTextField.getText().isEmpty()) {
            rowsErrorLabel.setText("Rows must have a value!");
            i++;
        }
        if (seatsTextField.getText().isEmpty()) {
            seatsErrorLabel.setText("Seats must have a value!");
            i++;
        }

        return i > 0;
    }

    /**
     * The method checks that the values of the rows and seats text fields are
     * fine - that is, the values must be integers and they must be above zero.
     * If these terms don't match for either of the values of the text fields,
     * the corresponding error messages are set for each false value and the
     * method returns false. If no false value is found, then the method returns
     * true.
     *
     * @return true if both the rows and seats text fields have values that are
     * integer and above zero
     */
    public boolean rowsAndSeatsAreIntegersAndAboveZero() {
        int i = 0;
        
        if (!rowsValueIsInteger()) {
            i++;
        } else if (!rowsValueIsAboveZero()) {
            i++;
        }

        if (!seatsValueIsInteger()) {
            i++;
        } else if (!seatsValueIsAboveZero()) {
            i++;
        }

        return i == 0;
    }

    /**
     * This method checks if there already exists a hall with the given name.
     * The method is intended for use when either adding a new hall or trying to
     * update an already existing hall. The <code>Command</code> parameter 
     * defines this
     * 
     * The method is intended for use when adding a new hall. If a hall with the
     * given name already exists, corresponding error message is set and true is
     * returned. If not, then false is returned
     *
     * @param name the name of the hall to be searched for
     * @param command enum that defines whether the method is called when adding
     * or updating a hall
     * @return true if hall is found with the given name, and false if no hall
     * is found
     */
    public boolean hallExistsAlready(String name, Command command) {
        if (hallHandler.hallExists(name)) {
            if (command == Command.ADD) {
                hallNameErrorLabel.setText("Hall with that name already exists!");
            }
            return true;
        }
        
        if (command == Command.UPDATE) {
            hallNameErrorLabel.setText("No hall exists with that name!");
        }
        return false;
    }

    private boolean rowsValueIsInteger() {
        try {
            Integer.parseInt(rowsTextField.getText());
        } catch (NumberFormatException e) {
            rowsErrorLabel.setText("Integer value should be given!");
            return false;
        }

        return true;
    }

    private boolean rowsValueIsAboveZero() {
        int rows = Integer.parseInt(rowsTextField.getText());
        if (rows <= 0) {
            rowsErrorLabel.setText("The hall must have at least one row!");
            return false;
        }
        return true;
    }

    private boolean seatsValueIsInteger() {
        try {
            Integer.parseInt(seatsTextField.getText());
        } catch (NumberFormatException e) {
            seatsErrorLabel.setText("Integer value should be given!");
            return false;
        }
        return true;
    }

    private boolean seatsValueIsAboveZero() {
        int seats = Integer.parseInt(seatsTextField.getText());
        if (seats <= 0) {
            seatsErrorLabel.setText("The hall must have at least one seat!");
            return false;
        }
        return true;
    }

}
