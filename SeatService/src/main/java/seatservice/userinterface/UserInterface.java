/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatservice.userinterface;

import seatservice.userinterface.command.Command;
import seatservice.userinterface.inputerrorhandler.InputErrorHandler;
import seatservice.userinterface.listeners.HallNamesListener;
import seatservice.domain.Hall;
import seatservice.filehandling.HallHandler;
import seatservice.domain.Seat;
import seatservice.userinterface.listeners.ClickListener;

import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

/**
 * This class is responsible for handling the GUI
 *
 * @author Tuomo Oila
 */
public class UserInterface extends javax.swing.JFrame implements Runnable {

    private HallHandler hallHandler;
    private HallNamesListener listener;
    private InputErrorHandler inputErrorHandler;

    public UserInterface() {
        hallHandler = new HallHandler();
        hallHandler.readFile();
        initComponents();
        fillHallNames();
        listener = new HallNamesListener();
        addSelectionListenerToHallNames();
        fillNamesTable();
        createInputErrorHandler();
    }

    private void createInputErrorHandler() {
        this.inputErrorHandler = new InputErrorHandler(
                hallNameErrorLabel,
                rowsErrorLabel,
                seatsErrorLabel,
                hallsNameTextField,
                rowsTextField,
                seatsTextField,
                hallHandler);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exitButton = new javax.swing.JButton();
        customerServingTab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        hallNameLabel = new javax.swing.JLabel();
        hallsNameTextField = new javax.swing.JTextField();
        rowsTextField = new javax.swing.JTextField();
        seatsTextField = new javax.swing.JTextField();
        rowsLabel = new javax.swing.JLabel();
        seatsLabel = new javax.swing.JLabel();
        addHallButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        hallNamesList1 = new javax.swing.JList();
        removeHallButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        hallInfoTable = new javax.swing.JTable();
        hallNameErrorLabel = new javax.swing.JLabel();
        rowsErrorLabel = new javax.swing.JLabel();
        seatsErrorLabel = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        hallSituationScrollPane = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        hallNamesList2 = new javax.swing.JList();
        showButton = new javax.swing.JButton();
        resetSeatsButton = new javax.swing.JButton();
        emptyFieldButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));
        setName("frame"); // NOI18N

        exitButton.setText("Exit");
        exitButton.setFocusable(false);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        customerServingTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerServingTabMouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 204))); // NOI18N

        hallNameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        hallNameLabel.setText("Halls name");

        hallsNameTextField.setToolTipText("Give a new hall's name here. \nThe name must have at least one character.");

        rowsTextField.setToolTipText("Give the amount of rows in the new hall here. \nThe value given must be an integer.");

        seatsTextField.setToolTipText("Give the amount of seats on a row in the new hall here.\nThe value must be an integer.");

        rowsLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rowsLabel.setText("Amount of rows:");

        seatsLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        seatsLabel.setText("Amount of seats on a row");

        addHallButton.setText("Add hall!");
        addHallButton.setToolTipText("Give a new hall's name, amount of rows and seats on a row");
        addHallButton.setFocusable(false);
        addHallButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHallButtonActionPerformed(evt);
            }
        });

        hallNamesList1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hall names"));
        hallNamesList1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        hallNamesList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        hallNamesList1.setToolTipText("All the existing halls' names are here");
        jScrollPane2.setViewportView(hallNamesList1);

        removeHallButton.setText("Remove hall");
        removeHallButton.setToolTipText("Choose a hall to be removed");
        removeHallButton.setFocusable(false);
        removeHallButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeHallButtonActionPerformed(evt);
            }
        });

        hallInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Rows", "Seats on a row", "Seats in total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hallInfoTable.setColumnSelectionAllowed(true);
        hallInfoTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(hallInfoTable);
        hallInfoTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (hallInfoTable.getColumnModel().getColumnCount() > 0) {
            hallInfoTable.getColumnModel().getColumn(0).setResizable(false);
            hallInfoTable.getColumnModel().getColumn(1).setResizable(false);
            hallInfoTable.getColumnModel().getColumn(2).setResizable(false);
            hallInfoTable.getColumnModel().getColumn(3).setResizable(false);
        }

        hallNameErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        hallNameErrorLabel.setFocusable(false);

        rowsErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        rowsErrorLabel.setFocusable(false);

        seatsErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        seatsErrorLabel.setFocusable(false);

        updateButton.setText("Update!");
        updateButton.setToolTipText("Give an existing hall's name and new rows and seats");
        updateButton.setFocusable(false);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(updateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addHallButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rowsLabel)
                                    .addComponent(seatsLabel)
                                    .addComponent(hallNameLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(seatsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rowsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hallsNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hallNameErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(rowsErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(seatsErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeHallButton))))
                .addContainerGap(288, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hallsNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hallNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hallNameErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rowsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rowsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rowsErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seatsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seatsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seatsErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addHallButton)
                    .addComponent(updateButton))
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeHallButton)))
                .addGap(113, 113, 113))
        );

        customerServingTab.addTab("Administration", jPanel1);

        hallNamesList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(hallNamesList2);

        showButton.setText("Show");
        showButton.setToolTipText("Choose a hall from the above list to show its seats");
        showButton.setFocusable(false);
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        resetSeatsButton.setText("Reset all seats to available");
        resetSeatsButton.setToolTipText("Reset all seats in the shown hall to available");
        resetSeatsButton.setFocusable(false);
        resetSeatsButton.setNextFocusableComponent(resetSeatsButton);
        resetSeatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetSeatsButtonActionPerformed(evt);
            }
        });

        emptyFieldButton.setText("Empty field");
        emptyFieldButton.setToolTipText("Empty the hall view");
        emptyFieldButton.setFocusable(false);
        emptyFieldButton.setNextFocusableComponent(showButton);
        emptyFieldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emptyFieldButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("The White Screen");
        jLabel1.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(emptyFieldButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetSeatsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hallSituationScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(334, 334, 334))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(resetSeatsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emptyFieldButton))
                    .addComponent(hallSituationScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        customerServingTab.addTab("Customer serving", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitButton)
                .addGap(30, 30, 30))
            .addComponent(customerServingTab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(customerServingTab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void addHallButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHallButtonActionPerformed

        emptyErrorLabels();
        int i = 0;
        String name = hallsNameTextField.getText().trim();

        if (!valuesAreValidWhenAddingOrUpdating(name, Command.ADD)) {
            return;
        }

        int rows = Integer.parseInt(rowsTextField.getText());
        int seats = Integer.parseInt(seatsTextField.getText());

        hallHandler.addNewHall(name, rows, seats);

        updateFieldsListAndTables();
    }//GEN-LAST:event_addHallButtonActionPerformed

    private void updateFieldsListAndTables() {
        emptyAllFieldsAndLabels();
        fillHallNames();
        fillNamesTable();
    }

    private void removeHallButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeHallButtonActionPerformed
        if (hallHandler.getHallsAsList().isEmpty()) {
            return;
        }

        if (listener.getSelectedName() == null) {
            return;
        }

        if (!confirmUserWantsToRemoveHall(Command.REMOVE)) {
            return;
        }

        removeSelectedHall();
        updateFieldsListAndTables();
    }//GEN-LAST:event_removeHallButtonActionPerformed

    private boolean noHallsExist() {
        return hallHandler.getHallsAsList().isEmpty();
    }

    private boolean selectedNameIsNull() {
        return listener.getSelectedName() == null;
    }


    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed

        hallSituationScrollPane.setViewportView(null);
        if (noHallsExist()) {
            return;
        }
        if (selectedNameIsNull()) {
            return;
        }

        hallSituationScrollPane.getViewport().revalidate();
        hallSituationScrollPane.getViewport().repaint();

        String selectedHall = listener.getSelectedName();
        Hall hall = hallHandler.findHallByName(selectedHall);

        Map<Integer, Map<Integer, Seat>> seats = hall.getSeats();

        removeListeners(seats, hall);

        GridLayout layout = new GridLayout(seats.size(), seats.get(1).size());

        JPanel buttons = new JPanel();
        buttons.setLayout(layout);
        addListenersToSeatsAndSeatsToPanel(buttons, seats, hall);

        hallSituationScrollPane.setViewportView(buttons);
    }//GEN-LAST:event_showButtonActionPerformed

    private void resetSeatsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetSeatsButtonActionPerformed
        hallSituationScrollPane.setViewportView(null);
        if (noHallsExist()) {
            return;
        }
        if (selectedNameIsNull()) {
            return;
        }

        String selectedHall = listener.getSelectedName();

        Hall hall = hallHandler.findHallByName(selectedHall);
        hall.resetSeatsToAvailable();
        Map<Integer, Map<Integer, Seat>> seats = hall.getSeats();

        removeListeners(seats, hall);
        GridLayout layout = new GridLayout(seats.size(), seats.get(1).size());

        JPanel buttons = new JPanel();
        buttons.setLayout(layout);
        addListenersToSeatsAndSeatsToPanel(buttons, seats, hall);

        hallSituationScrollPane.setViewportView(buttons);
    }//GEN-LAST:event_resetSeatsButtonActionPerformed

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

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        emptyErrorLabels();
        String name = hallsNameTextField.getText().trim();

        if (!valuesAreValidWhenAddingOrUpdating(name, Command.UPDATE)) {
            return;
        }

        if (!confirmUserWantsToRemoveHall(Command.UPDATE)) {
            return;
        }

        int newRows = Integer.parseInt(rowsTextField.getText());
        int newSeats = Integer.parseInt(seatsTextField.getText());

        hallHandler.updateHall(name, newRows, newSeats);
        fillHallNames();
        fillNamesTable();
        emptyAllFieldsAndLabels();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void emptyFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emptyFieldButtonActionPerformed
        hallSituationScrollPane.setViewportView(null);
    }//GEN-LAST:event_emptyFieldButtonActionPerformed

    private void customerServingTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerServingTabMouseClicked
        listener.resetSelection();
        hallNamesList1.clearSelection();
        hallNamesList2.clearSelection();
    }//GEN-LAST:event_customerServingTabMouseClicked

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

    private boolean confirmUserWantsToRemoveHall(Command command) {
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

    private void fillHallNames() {
        DefaultListModel hallNamesModel = new DefaultListModel();
        for (int i = 0; i < hallHandler.getHallsAsList().size(); i++) {
            hallNamesModel.addElement(hallHandler.getHallsAsList().get(i).getName());
        }
        hallNamesList1.setModel(hallNamesModel);
        hallNamesList2.setModel(hallNamesModel);
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

    private void addSelectionListenerToHallNames() {
        hallNamesList1.addListSelectionListener(listener);
        hallNamesList2.addListSelectionListener(listener);
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

    private void emptyAllFieldsAndLabels() {
        emptyTextFields();
        emptyErrorLabels();

    }

    private void removeSelectedHall() {
        String selectedHall = this.listener.getSelectedName();
        hallHandler.removeHall(selectedHall);
        listener.resetSelection();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addHallButton;
    private javax.swing.JTabbedPane customerServingTab;
    private javax.swing.JButton emptyFieldButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JTable hallInfoTable;
    private javax.swing.JLabel hallNameErrorLabel;
    private javax.swing.JLabel hallNameLabel;
    private javax.swing.JList hallNamesList1;
    private javax.swing.JList hallNamesList2;
    private javax.swing.JScrollPane hallSituationScrollPane;
    private javax.swing.JTextField hallsNameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton removeHallButton;
    private javax.swing.JButton resetSeatsButton;
    private javax.swing.JLabel rowsErrorLabel;
    private javax.swing.JLabel rowsLabel;
    private javax.swing.JTextField rowsTextField;
    private javax.swing.JLabel seatsErrorLabel;
    private javax.swing.JLabel seatsLabel;
    private javax.swing.JTextField seatsTextField;
    private javax.swing.JButton showButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
