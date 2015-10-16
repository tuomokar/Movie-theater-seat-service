/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatservice.userinterface;

import java.awt.GridLayout;
import seatservice.domain.Hall;
import seatservice.filehandling.HallHandler;

import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import seatservice.domain.Seat;
import seatservice.userinterface.customerserving.ClickListener;

public class UserInterface extends javax.swing.JFrame implements Runnable {

    private HallHandler hallHandler;
    private HallNamesListener listener;

    /**
     * Creates new form TotalGUITest
     */
    public UserInterface() {
        hallHandler = new HallHandler();
        initComponents();
        fillHallNames();
        listener = new HallNamesListener();
        addSelectionListenerToHallNames();
        fillTable();

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
        hallNamesList = new javax.swing.JList();
        removeHallButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        hallInfoTable = new javax.swing.JTable();
        hallNameErrorText = new javax.swing.JLabel();
        rowErrorText = new javax.swing.JLabel();
        seatsErrorText = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        hallSituationScollPane = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        hallNamesList2 = new javax.swing.JList();
        showButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));
        setName("frame"); // NOI18N

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
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
        addHallButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHallButtonActionPerformed(evt);
            }
        });

        hallNamesList.setBorder(javax.swing.BorderFactory.createTitledBorder("Hall names"));
        hallNamesList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        hallNamesList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        hallNamesList.setToolTipText("All the existing halls' names are here");
        jScrollPane2.setViewportView(hallNamesList);

        removeHallButton.setText("Remove hall");
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

        hallNameErrorText.setForeground(new java.awt.Color(255, 0, 0));
        hallNameErrorText.setText(" ");
        hallNameErrorText.setFocusable(false);

        rowErrorText.setForeground(new java.awt.Color(255, 0, 0));
        rowErrorText.setText(" ");
        rowErrorText.setFocusable(false);

        seatsErrorText.setForeground(new java.awt.Color(255, 0, 0));
        seatsErrorText.setText(" ");
        seatsErrorText.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addHallButton)
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hallNameErrorText)
                            .addComponent(seatsErrorText)
                            .addComponent(rowErrorText)))
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
                    .addComponent(hallNameErrorText, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rowsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rowsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rowErrorText, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seatsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seatsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seatsErrorText, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addHallButton)
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeHallButton)))
                .addGap(113, 113, 113))
        );

        customerServingTab.addTab("Hall informaton, adding and removing", jPanel1);

        hallNamesList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(hallNamesList2);

        showButton.setText("Show");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hallSituationScollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showButton))
                    .addComponent(hallSituationScollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
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
        int i = 0;
        String name = hallsNameTextField.getText().trim();
        if (name.isEmpty()) {
            hallNameErrorText.setText("name must not be empty!");
            i++;
        }
        if (rowsTextField.getText().isEmpty()) {
            rowErrorText.setText("rows must have a value!");
            i++;
        }
        if (seatsTextField.getText().isEmpty()) {
            seatsErrorText.setText("seats must have a value!");
            i++;
        }
        if (i > 0) {
            return;
        }

        int rows = 0;
        int seats = 0;

        try {
            rows = Integer.parseInt(rowsTextField.getText());
        } catch (NumberFormatException e) {
            rowErrorText.setText("integer value should be given");
            i++;
        }

        try {
            seats = Integer.parseInt(seatsTextField.getText());
        } catch (NumberFormatException e) {
            seatsErrorText.setText("integer value should be given");
            i++;
        }

        if (i > 0) {
            return;
        }

        hallHandler.addNewHall(name, rows, seats);

        fillHallNames();
        emptyFields();
        fillTable();
    }//GEN-LAST:event_addHallButtonActionPerformed

    private void removeHallButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeHallButtonActionPerformed
        if (hallHandler.getHallsAsList().isEmpty()) {
            return;
        }

        if (listener.getSelectedName() == null) {
            return;
        }

        if (!confirmUserWantsToRemoveHall()) {
            return;
        }

        removeSelectedHall();
        fillHallNames();
        fillTable();
    }//GEN-LAST:event_removeHallButtonActionPerformed

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        if (hallHandler.getHallsAsList().isEmpty()) {
            return;
        }

        String selectedHall = listener.getSelectedName();
        if (selectedHall == null) {
            return;
        }
        
        Hall hall = hallHandler.findHallByName(selectedHall);
        
        Map<Integer, Map<Integer, Seat>> seats = hall.getSeats();
        GridLayout layout = new GridLayout(seats.size(), seats.get(1).size());
        
        JPanel buttons = new JPanel();
        buttons.setLayout(layout);
        addSeatsToPanelAndActionListeners(buttons, seats, hall);
        
//        hallSituationScollPane.add(buttons);
        hallSituationScollPane.setViewportView(buttons);
        listener.resetSelection();
    }//GEN-LAST:event_showButtonActionPerformed

    private void addSeatsToPanelAndActionListeners(JPanel buttons, 
            Map<Integer, Map<Integer, Seat>> seats,
            Hall hall) {
    
        for (int row = seats.size(); row >= 1; row--) {
            for (int seatsPlace = 1; seatsPlace <= seats.get(1).size(); seatsPlace++) {
                Seat seat = hall.getSeat(row, seatsPlace);
                seat.addActionListener(new ClickListener());
                seat.setText("" + seatsPlace);
                buttons.add(seat);
            }
        }
    }
    
    private boolean confirmUserWantsToRemoveHall() {
        JDialog.setDefaultLookAndFeelDecorated(true);
        int response = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to remove this hall?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        return response == JOptionPane.YES_OPTION;

    }

    private void fillHallNames() {
        DefaultListModel hallNamesModel = new DefaultListModel();
        for (int i = 0; i < hallHandler.getHallsAsList().size(); i++) {
            hallNamesModel.addElement(hallHandler.getHallsAsList().get(i).getName());
        }
        hallNamesList.setModel(hallNamesModel);
        hallNamesList2.setModel(hallNamesModel);
    }

    private void fillTable() {

        List<Hall> halls = hallHandler.getHallsAsList();
        int size = hallHandler.getHallsAsList().size();
        int columns = 4;

        DefaultTableModel tableModel = new DefaultTableModel(1, size);

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
        hallNamesList.addListSelectionListener(listener);
        hallNamesList2.addListSelectionListener(listener);
    }

    private void emptyFields() {
        hallsNameTextField.setText("");
        rowsTextField.setText("");
        seatsTextField.setText("");

        hallNameErrorText.setText("");
        rowErrorText.setText("");
        seatsErrorText.setText("");
    }

    private void removeSelectedHall() {
        String selectedHall = this.listener.getSelectedName();
        hallHandler.removeHall(selectedHall);
        listener.resetSelection();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addHallButton;
    private javax.swing.JTabbedPane customerServingTab;
    private javax.swing.JButton exitButton;
    private javax.swing.JTable hallInfoTable;
    private javax.swing.JLabel hallNameErrorText;
    private javax.swing.JLabel hallNameLabel;
    private javax.swing.JList hallNamesList;
    private javax.swing.JList hallNamesList2;
    private javax.swing.JScrollPane hallSituationScollPane;
    private javax.swing.JTextField hallsNameTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton removeHallButton;
    private javax.swing.JLabel rowErrorText;
    private javax.swing.JLabel rowsLabel;
    private javax.swing.JTextField rowsTextField;
    private javax.swing.JLabel seatsErrorText;
    private javax.swing.JLabel seatsLabel;
    private javax.swing.JTextField seatsTextField;
    private javax.swing.JButton showButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
}
