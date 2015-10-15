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
import javax.swing.JScrollPane;
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
        
        if (noHallsExist()) {
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
            System.out.println("Type /abort at any time to stop");
            
            printOutNamesOfAllHalls();
            String name = reader.nextLine();          
            
            if (name.equals("/abort")) {
                System.out.println();
                System.out.println("Aborting..");
                System.out.println();
                if (frame != null) {
                    stopShowingCurrentHall();
                }
                break;
            }
            
            if (hallIsAlreadyBeingShown(name)) {
                System.out.println();
                System.out.println("That hall is already being shown");
                System.out.println();
                continue;
            }
            
            hall = hallHandler.findHallByName(name);
            
            if (noHallWithGivenName()) {
                System.out.println();
                System.out.println("Hall with that name doesn't exist");
                System.out.println();
                continue;
            }
            
            if (anotherHallNameWasGiven()) {
                stopShowingCurrentHall();
            }
            
            
            run();
        }
    }
    
    private boolean anotherHallNameWasGiven() {
        return frame != null;
    }
    
    private void stopShowingCurrentHall() {
        frame.dispose();
    }
    
    private boolean hallIsAlreadyBeingShown(String name) {
        return hall != null && name.equals(hall.getName());
    }
    
    private boolean noHallsExist() {
        return hallHandler.getHallsAsList().isEmpty();
    }
    
    private boolean noHallWithGivenName() {
        return hall == null;
    }
    
    private void printOutNamesOfAllHalls() {
        System.out.println("The names are: ");
        for (Hall hall : hallHandler.getHallsAsList()) {
            System.out.println("  " + hall.getName());
        }
    }

    @Override
    public void run() {
        frame = new JFrame("Customer serving GUI");
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        Map<Integer, Map<Integer, Seat>> seats = hall.getSeats();

        GridLayout layout = new GridLayout(seats.size(), seats.get(1).size());

        JPanel buttons = new JPanel();
        buttons.setLayout(layout);
                                   
        JPanel screen = new JPanel();
        screen.add(new Label("The white screen"), BorderLayout.CENTER);
       
        JScrollPane scrollable = new JScrollPane(buttons);
        scrollable.setPreferredSize(new Dimension(1200, 900));
        
        container.add(scrollable, BorderLayout.NORTH);
        container.add(screen, BorderLayout.SOUTH);
             
        addActionListenersToSeats(buttons, seats);
    }
    
    private void addActionListenersToSeats(JPanel buttons, Map<Integer, Map<Integer, Seat>> seats) {
        for (int row = seats.size(); row >= 1; row--) {
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
}
