package seatservice.userinterface.customerserving;

import java.awt.BorderLayout;
import seatservice.domain.Seat;
import seatservice.domain.Hall;
import seatservice.filehandling.HallHandler;

import java.util.Scanner;
import java.util.Map;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 * This class is responsible for handling the UI for customer
 */
public class CustomerServingUI implements Runnable {

    private HallHandler hallHandler;
    private JFrame frame;
    private Hall hall;
    private Scanner reader;

    public CustomerServingUI(HallHandler hallHandler, Scanner reader) {
        this.hallHandler = hallHandler;
        this.reader = reader;
    }

    /**
     * Handles the text UI and begins the GUI
     */
    public void start() {
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println("-----You started the customer serving UI-----");
        System.out.println("---------------------------------------------");
        
        if (hallHandler.getHallsAsList().isEmpty()) {
            System.out.println();
            System.out.println("No halls added yet, please add some halls first");
            System.out.println();
            return;
        }
        
        System.out.println();
        
        while (true) {
            System.out.println();
            System.out.println("Which hall is the hall that shows "
                    + "the movie the customer wants to see?");
            
            printOutNamesOfAllHalls();
            String name = reader.nextLine();
            hall = hallHandler.findHallByName(name);
            
            if (hallDoesntExist()) {
                System.out.println("Hall with that name doesn't exist");
                continue;
            }
            
            if (name.equals("/abort")) {
                break;
            }
            run();                            
        }
    }
    
    private boolean hallDoesntExist() {
        return hall == null;
    }

    @Override
    public void run() {
        frame = new JFrame("Customer serving GUI");
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        Map<Integer, Map<Integer, Seat>> seats = hall.getSeats();

        GridLayout layout = new GridLayout(seats.size(), seats.get(1).size());

        JPanel buttons = new JPanel();
        buttons.setLayout(layout);       
        setPreferredSizeForButtons(buttons);
        container.add(buttons, BorderLayout.NORTH);
                                     
        JPanel screen = new JPanel();
        screen.add(new Label("Screen here"));
        screen.setLayout(new GridLayout(2,15));
        container.add(screen, BorderLayout.SOUTH);
        
        
        addActionListenersToSeats(buttons, seats);
    }
    
    private void setPreferredSizeForButtons(JPanel buttons) {
        JButton b = new JButton("Just fake button");
        Dimension buttonSize = b.getPreferredSize();
        buttons.setPreferredSize(new Dimension((int) (buttonSize.getWidth() * 8) - 20,
                (int) (buttonSize.getHeight() * 3.5) + 20 * 2));
    }
    
    private void addActionListenersToSeats(JPanel buttons, Map<Integer, Map<Integer, Seat>> seats) {
        for (int row = 1; row <= seats.size(); row++) {
            for (int seatsPlace = 1; seatsPlace <= seats.get(1).size(); seatsPlace++) {
                Seat seat = hall.getSeat(row, seatsPlace);
                seat.addActionListener(new ClickListener());
                seat.setText("" + seatsPlace);
                buttons.add(seat);
            }
        }
    }

    public JFrame getFrame() {
        return frame;
    }
    
    private void printOutNamesOfAllHalls() {
        System.out.println("The names are: ");
        for (Hall hall : hallHandler.getHallsAsList()) {
            System.out.println("  " + hall.getName());
        }
    }
}
