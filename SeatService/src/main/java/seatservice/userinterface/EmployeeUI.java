package seatservice.userinterface;

import seatservice.logic.HallHandler;
import seatservice.userinterface.customerServing.CustomerServingUI;
import seatservice.userinterface.theatermanager.TheaterManagingUI;

import java.util.Scanner;

public class EmployeeUI {

    private HallHandler hallHandler;
    private TheaterManagingUI theaterManagingUI;
    private CustomerServingUI customerServingUI;
    private Scanner reader;

    public EmployeeUI() {
        this.hallHandler = new HallHandler();
        this.reader = new Scanner(System.in);
        this.theaterManagingUI = new TheaterManagingUI(hallHandler, reader);
        this.customerServingUI = new CustomerServingUI(hallHandler);       
    }

    public void start() {
        System.out.println("-------------------------------------------");
        System.out.println("------------------WELCOME------------------");
        System.out.println("-------------------------------------------");

        System.out.println();
        System.out.println();

        while (true) {
            System.out.println("Do you wish to manage the theater or serve "
                    + "customers?");
            System.out.println("[1] Manage theater");
            System.out.println("[2] Serve customers");
            System.out.println("[3] End program");

            String choice = reader.nextLine();

            if (choice.equals("1")) {
                manageTheater();
            } else if (choice.equals("2")) {
                serveCustomers();
            } else if (choice.equals("3")) {
                break;
            } else {
                System.out.println("Wrong input");
            }

        }
        
        System.out.println("-------------------------------------------");
        System.out.println("-----------------THANK YOU-----------------");
        System.out.println("-------------------------------------------");
    }

    public void manageTheater() {
        theaterManagingUI.start();
    }

    public void serveCustomers() {
        customerServingUI.start();
    }

}
