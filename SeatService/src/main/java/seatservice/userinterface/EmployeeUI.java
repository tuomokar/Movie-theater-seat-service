package seatservice.userinterface;

import seatservice.filehandling.HallHandler;
import seatservice.userinterface.customerserving.CustomerServingUI;
import seatservice.userinterface.theatermanager.TheaterManagingUI;

import java.util.Scanner;

/**
 * This class is responsible for handling the user interface and all of its
 * aspects
 */
public class EmployeeUI {

    private HallHandler hallHandler;
    private TheaterManagingUI theaterManagingUI;
    private CustomerServingUI customerServingUI;
    private Scanner reader;

    /**
     * The constructor creates the hallHandler and reader along with the
     * UI classes for managing the theater and serving customers.
     * At the end of the constructor it parses any possibly existing halls
     * in the database so that the software will know them all from now on.
     */
    public EmployeeUI() {
        this.hallHandler = new HallHandler();
        this.reader = new Scanner(System.in);
        this.theaterManagingUI = new TheaterManagingUI(hallHandler, reader);
        this.customerServingUI = new CustomerServingUI(hallHandler, reader);
        readHalls();
    }

    /**
     * Starts the general UI. The user has options to manage theater and 
     * serve customers and can choose to quit the program.
     */
    public void start() {
        System.out.println("-------------------------------------------");
        System.out.println("------------------WELCOME------------------");
        System.out.println("-------------------------------------------");

        System.out.println();
        System.out.println();

        while (true) {
            System.out.println("Do you wish to manage the theater or serve "
                    + "customers?");
            System.out.println("Please give a number corresponding to the "
                    + "thing you wish do to");
            
            System.out.println();
            System.out.println();
            
            System.out.println("[1] Manage theater");
            System.out.println("[2] Serve customers");
            System.out.println("[3] End program");

            System.out.println();
            
            System.out.print("? ");
            String choice = reader.nextLine();

            if (choice.equals("1")) {
                manageTheater();
            } else if (choice.equals("2")) {
                serveCustomers();
            } else if (choice.equals("3")) {
                break;
            } else {
                System.out.println("Incorrect input, please give a number"
                        + "corresponding to the thing you wish to do");
            }
            
            System.out.println();
            System.out.println();

        }
        
        System.out.println("-------------------------------------------");
        System.out.println("-----------------THANK YOU-----------------");
        System.out.println("-------------------------------------------");
    }

    private void manageTheater()  {
        theaterManagingUI.start();
    }

    private void serveCustomers() {
        customerServingUI.start();
    }
    
    private void readHalls() {
        hallHandler.readFile();
    }

}
