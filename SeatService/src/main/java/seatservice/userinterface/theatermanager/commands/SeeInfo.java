
package seatservice.userinterface.theatermanager.commands;

import java.util.Scanner;
import seatservice.logic.HallHandler;

/**
 * This command is responsible for showing any info on the halls
 */
public class SeeInfo extends Command {

    public SeeInfo(Scanner reader, HallHandler hallHandler, String name) {
        super(reader, hallHandler, name);
    }

    /**
     * shows any info the employee wants and then returns true
     * @return true
     */
    @Override
    public boolean run() {
        return true;
    }
    
}
