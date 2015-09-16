
package seatservice.userinterface.theatermanager.commands;

import java.util.Scanner;
import seatservice.logic.HallHandler;

/**
 * This class is responsible for adding a hall or halls
 * @author tuomo_000
 */
public class Add extends Command {

    public Add(Scanner reader, HallHandler hallHandler, String name) {
        super(reader, hallHandler, name);
    }

    @Override
    public boolean run() {
        return true;
    }
    
}
