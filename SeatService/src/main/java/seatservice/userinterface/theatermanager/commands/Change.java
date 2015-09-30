
package seatservice.userinterface.theatermanager.commands;

import java.util.Scanner;
import seatservice.filehandling.HallHandler;

/**
 * This command is responsible for changing information on a hall or halls
 */
public class Change extends Command {

    public Change(Scanner reader, HallHandler hallHandler, String name) {
        super(reader, hallHandler, name);
    }

    @Override
    public boolean run() {
        return true;
    }
    
}
