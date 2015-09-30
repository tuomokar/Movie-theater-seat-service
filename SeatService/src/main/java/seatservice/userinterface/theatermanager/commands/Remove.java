
package seatservice.userinterface.theatermanager.commands;

import java.util.Scanner;
import seatservice.filehandling.HallHandler;

/**
 * This class is responsible for removing a hall or halls
 */
public class Remove extends Command {

    /**
     * 
     * @param reader
     * @param hallHandler
     * @param name 
     */
    public Remove(Scanner reader, HallHandler hallHandler, String name) {
        super(reader, hallHandler, name);
    }

    /**
     * Runs this command and returns true at the end
     * @return 
     */
    @Override
    public boolean run() {
        return true;
    }
    
}
