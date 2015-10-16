package seatservice.userinterface;

import seatservice.domain.Hall;
import seatservice.filehandling.HallHandler;

import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import seatservice.userinterface.HallNamesListener;

public class UserInterface extends javax.swing.JFrame implements Runnable {

    private HallHandler hallHandler;
    private HallNamesListener listener;

    private javax.swing.JButton addHallButton;
    private javax.swing.JTextField amountOfRows;
    private javax.swing.JTextField amountOfSeatsOnARow;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel hallNameErrorText;
    private javax.swing.JList hallNames;
    private javax.swing.JTable hallNamesTestTable;
    private javax.swing.JTextField hallsName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton removeHallButton;
    private javax.swing.JLabel rowErrorText;
    private javax.swing.JLabel seatsErrorText;

    /**
     * Creates new form TotalGUITest
     */
    public UserInterface() {
        hallHandler = new HallHandler();
        hallHandler.readFile();
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        exitButton = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        hallsName = new javax.swing.JTextField();
        amountOfRows = new javax.swing.JTextField();
        amountOfSeatsOnARow = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addHallButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        hallNames = new javax.swing.JList();
        removeHallButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        hallNamesTestTable = new javax.swing.JTable();
        hallNameErrorText = new javax.swing.JLabel();
        rowErrorText = new javax.swing.JLabel();
        seatsErrorText = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Halls name");

        hallsName.setToolTipText("Give a new hall's name here. \nThe name must have at least one character.");

        amountOfRows.setToolTipText("Give the amount of rows in the new hall here. \nThe value given must be an integer.");

        amountOfSeatsOnARow.setToolTipText("Give the amount of seats on a row in the new hall here.\nThe value must be an integer.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Amount of rows:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Amount of seats on a row");

        addHallButton.setText("Add hall!");
        addHallButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHallButtonActionPerformed(evt);
            }
        });

        hallNames.setBorder(javax.swing.BorderFactory.createTitledBorder("Hall names"));
        hallNames.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        hallNames.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};

            public int getSize() {
                return strings.length;
            }

            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        hallNames.setToolTipText("All the existing halls' names are here");
        jScrollPane2.setViewportView(hallNames);

        removeHallButton.setText("Remove hall");
        removeHallButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeHallButtonActionPerformed(evt);
            }
        });

        hallNamesTestTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Name", "Rows", "Seats on a row", "Seats in total"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        hallNamesTestTable.setColumnSelectionAllowed(true);
        hallNamesTestTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(hallNamesTestTable);
        hallNamesTestTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (hallNamesTestTable.getColumnModel().getColumnCount() > 0) {
            hallNamesTestTable.getColumnModel().getColumn(0).setResizable(false);
            hallNamesTestTable.getColumnModel().getColumn(1).setResizable(false);
            hallNamesTestTable.getColumnModel().getColumn(2).setResizable(false);
            hallNamesTestTable.getColumnModel().getColumn(3).setResizable(false);
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
                                                                .addComponent(jLabel2)
                                                                .addComponent(jLabel3)
                                                                .addComponent(jLabel1))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(amountOfSeatsOnARow, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(amountOfRows, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(hallsName, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(hallNameErrorText)
                                                .addComponent(seatsErrorText)
                                                .addComponent(rowErrorText)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(296, 296, 296)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(removeHallButton)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeHallButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(hallsName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hallNameErrorText, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(amountOfRows, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rowErrorText, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(amountOfSeatsOnARow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(seatsErrorText, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(addHallButton)
                        .addGap(79, 79, 79)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))
        );

        jTabbedPane2.addTab("tab1", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 930, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 579, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab2", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitButton)
                        .addGap(30, 30, 30))
                .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton)
                        .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void addHallButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int i = 0;
        String name = hallsName.getText().trim();
        if (name.isEmpty()) {
            hallNameErrorText.setText("name must not be empty!");
            i++;
        }
        if (amountOfRows.getText().isEmpty()) {
            rowErrorText.setText("rows must have a value!");
            i++;
        }
        if (amountOfSeatsOnARow.getText().isEmpty()) {
            seatsErrorText.setText("seats must have a value!");
            i++;
        }
        if (i > 0) {
            return;
        }

        int rows = 0;
        int seats = 0;

        try {
            rows = Integer.parseInt(amountOfRows.getText());
        } catch (NumberFormatException e) {
            rowErrorText.setText("integer value should be given");
            i++;
        }

        try {
            seats = Integer.parseInt(amountOfSeatsOnARow.getText());
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
    }

    private void removeHallButtonActionPerformed(java.awt.event.ActionEvent evt) {
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
        hallNames.setModel(hallNamesModel);
    }

    private void fillTable() {

        List<Hall> halls = hallHandler.getHallsAsList();
        int size = hallHandler.getHallsAsList().size();
        int columns = 4;

        DefaultTableModel dtm = new DefaultTableModel(1, size);

        String header[] = new String[]{"Name", "Rows", "Seats on a row",
            "Seats in total"};

        dtm.setColumnIdentifiers(header);

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
            dtm.addRow(row);
            
        }
        hallNamesTestTable.setModel(dtm);
    }

    private void addSelectionListenerToHallNames() {
        hallNames.addListSelectionListener(listener);
    }

    private void emptyFields() {
        hallsName.setText("");
        amountOfRows.setText("");
        amountOfSeatsOnARow.setText("");

        hallNameErrorText.setText("");
        rowErrorText.setText("");
        seatsErrorText.setText("");
    }

    private void removeSelectedHall() {
        String selectedHall = listener.getSelectedName();
        hallHandler.removeHall(selectedHall);
        listener.resetSelection();
    }

    @Override
    public void run() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
