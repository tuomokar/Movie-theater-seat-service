package seatservice.userinterface.theatermanager.commands;

import java.util.Scanner;
import seatservice.logic.HallHandler;

/**
 * This class is responsible for adding a hall or halls
 *
 * @author tuomo_000
 */
public class Add extends Command {

    private String hallsName;
    private int rows;
    private int seats;
    private boolean abort;

    public Add(Scanner reader, HallHandler hallHandler, String name) {
        super(reader, hallHandler, name);
    }

    /**
     * Reads input from the user three times and creates a new hall from those
     * inputs. With each input it's checked that it's not the command to abort.
     * If it is, then the method returns true (i.e. the thread goes out from the
     * class). If it's not the abort command, in the case of the hall's name
     * it's checked that the name isn't empty
     *
     * @return
     */
    @Override
    public boolean run() {
        abort = false;
        printOutBeginning();

        System.out.println();
        System.out.println("New hall's name: ");
        readName();
        if (abort) {
            return abort();
        }

        System.out.println();
        System.out.println("Amount of rows: ");
        readRows();
        if (abort) {
            return abort();
        }

        System.out.println();
        System.out.println("Amount of seats on a row: ");
        readSeats();
        if (abort) {
            return abort();
        }

        hallHandler.addNewHall(hallsName, rows, seats);

        System.out.println("hall was created successfully");
        System.out.println();

        return true;
    }

    private boolean wantsToAbort(int number) {
        return number == 666;
    }

    private int parseToInt(String input) {
        int value = 0;
        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException exc) {
            return -100000;
        }

        return value;
    }

    private boolean abort() {
        System.out.println();
        System.out.println("Aborting..");
        System.out.println();
        return true;
    }

    private void readName() {
        while (true) {
            System.out.print("? ");
            String name = reader.nextLine();

            if (wantsToAbort(name)) {
                this.abort = true;
                return;
            } else if (name.isEmpty()) {
                System.out.println("Input was empty");
                continue;
            } else if (hallHandler.hallExists(name)) {
                System.out.println("Hall with that name already exists");
                continue;
            }
            hallsName = name;
            break;
        }
    }

    private void readRows() {
        while (true) {
            System.out.print("? ");
            String rows = reader.nextLine();
            int rowsAsInt = parseToInt(rows);
            if (wantsToAbort(rows)) {
                this.abort = true;
                return;
            } else if (rowsAsInt <= 0) {
                System.out.println("Halls must have at least 1 row");
                continue;
            } else if (rowsAsInt == -100000) {
                System.out.println("Please give a number");
                continue;
            } else if (this.wantsToAbort(rows)) {

            }
            this.rows = rowsAsInt;
            break;

        }
    }

    private void readSeats() {
        while (true) {
            System.out.print("? ");
            String seats = reader.nextLine();
            int seatsAsInt = parseToInt(seats);
            if (wantsToAbort(seats)) {
                this.abort = true;
                return;
            } else if (seatsAsInt <= 0) {
                System.out.println("Rows must have at least 1 seat");
                continue;
            } else if (seatsAsInt == -100000) {
                System.out.println("Please give a number");
                continue;
            }
            this.seats = seatsAsInt;
            break;
        }
    }

    private void printOutBeginning() {
        System.out.println();
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println();

        System.out.println("You're adding a new hall");
        System.out.println();

        System.out.println("Abort any time by typing /abort");
    }

}
