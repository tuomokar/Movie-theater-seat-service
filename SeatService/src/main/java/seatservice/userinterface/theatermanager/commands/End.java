
package seatservice.userinterface.theatermanager.commands;

import java.util.Scanner;
import seatservice.filehandling.HallHandler;

/**
 * This class is responsible for ending the loop in the TheaterManagingUI
 */
public class End extends Command {

    public End(Scanner reader, HallHandler hallHandler, String name) {
        super(reader, hallHandler, name);
    }

    /**
     * Runs this command and returns false at the end
     * @return 
     */
    @Override
    public boolean run() {
        System.out.println();
        System.out.println("Ending..");
        System.out.println();
        return false;
    }
    
}
