package seatservice.userinterface.theatermanager.commands;

import java.util.Scanner;
import seatservice.domain.Hall;
import seatservice.filehandling.HallHandler;

/**
 * This command is responsible for showing any info on the halls
 */
public class SeeInfo extends Command {

    public SeeInfo(Scanner reader, HallHandler hallHandler, String name) {
        super(reader, hallHandler, name);
    }

    /**
     * Shows any info the employee wants and then returns true
     *
     * @return true
     */
    @Override
    public boolean run() {      
        System.out.println("");
        printOutBeginning();

        System.out.println("The halls currently in the database are:");

        printOutNamesOfAllHalls();
        System.out.println();

        while (true) {
            System.out.println();
            
            System.out.println("What do you wish to do?");
            System.out.println("Please pick the number corresponding to the "
                    + " thing you want to do");
            System.out.println("[1] see info on a single hall");
            System.out.println("[2] see full info on all the halls");
            System.out.println("[3] see names of all the halls");
            System.out.println("[4] finish");

            System.out.print("? ");
            String choice = reader.nextLine();

            if (choice.equals("4")) {
                break;
            } else if (choice.equals("1")) {
                System.out.println();
                System.out.println("Which hall do you want to see information on?");
                System.out.print("? ");

                String hallsName = reader.nextLine();

                System.out.println();
                Hall hall = hallHandler.findHallByName(hallsName);

                if (hall == null) {
                    System.out.println("Hall with that name wasn't found");
                    continue;
                }

                System.out.println(hall);
                System.out.println();

            } else if (choice.equals("2")) {
                System.out.println();
                printOutFullInfoOnHalls();
                
                System.out.println();
                

            } else if (choice.equals("3")) {
                System.out.println();
                
                printOutNamesOfAllHalls();
                System.out.println();
            } else {
                System.out.println("incorrect input, please give a number "
                        + "corresponding to the thing you want to do");
            }
        }
        return true;
    }

    private void printOutBeginning() {
        System.out.println();
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println();

        System.out.println("You're in the see info module");
        System.out.println();

        System.out.println("Abort any time by typing /abort");
        System.out.println();
        System.out.println();
    }

    private void printOutNamesOfAllHalls() {
        System.out.println("The names are: ");
        for (Hall hall : hallHandler.getHallsAsList()) {
            System.out.println("  " + hall.getName());
        }
    }
    
    private void printOutFullInfoOnHalls() {
        System.out.println("The halls are: ");
        System.out.println();
        for (Hall hall : hallHandler.getHallsAsList()) {
            System.out.println(hall.toString());
        }
    }
}
