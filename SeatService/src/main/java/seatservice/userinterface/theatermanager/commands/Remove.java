
package seatservice.userinterface.theatermanager.commands;

import java.util.Scanner;
import seatservice.logic.HallHandler;

/**
 * This class is responsible for removing a hall or halls
 * @author tuomo_000
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
