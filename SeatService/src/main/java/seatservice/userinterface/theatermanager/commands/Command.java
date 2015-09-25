
package seatservice.userinterface.theatermanager.commands;


import java.util.Scanner;
import seatservice.logic.HallHandler;

/**
 * This abstract class works as a parent class for all the commands for 
 * managing any info the software has on the theater
 */
public abstract class Command {
    
    protected Scanner reader;
    protected HallHandler hallHandler;
    protected String name;

    public Command(Scanner reader, HallHandler hallHandler, String name) {
        this.reader = reader;
        this.hallHandler = hallHandler;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    protected boolean wantsToAbort(String name) {
        return name.equals("/abort");
    }
    
    /**
     * Runs this command
     * @return true if the program is supposed to continue after the command
     * is run
     */
    public abstract boolean run();
}
