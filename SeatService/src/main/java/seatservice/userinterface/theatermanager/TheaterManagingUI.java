
package seatservice.userinterface.theatermanager;

import java.util.Map;
import java.util.HashMap;
import seatservice.logic.HallHandler;
import java.util.Scanner;
import seatservice.userinterface.theatermanager.commands.Add;
import seatservice.userinterface.theatermanager.commands.Change;
import seatservice.userinterface.theatermanager.commands.Command;
import seatservice.userinterface.theatermanager.commands.End;
import seatservice.userinterface.theatermanager.commands.Remove;
import seatservice.userinterface.theatermanager.commands.SeeInfo;

/**
 * This class is responsible for managing the theater's information
 */
public class TheaterManagingUI {

    private HallHandler hallHandler;
    private Scanner reader;
    private Map<String, Command> commands;

    /**
     * Creates an instance of this class. The class has a hallHandler and
     * scanner that it gets from elsewhere and a map containing instances of
     * Command class (with their option number as key). At the end of the 
     * constructor the commands are created and each command is put into the 
     * map.
     * @param hallHandler
     * @param reader 
     */
    public TheaterManagingUI(HallHandler hallHandler, Scanner reader) {
        this.hallHandler = hallHandler;
        this.reader = reader;
        this.commands = new HashMap<>();
        createCommands();
    }
    
    /**
     * Goes into a loop in which it handles the management of the information
     * on the theater. The available options are printed out to the user
     * and then the user can pick from those. The input is read and it's
     * checked which command the input matches. If the input doesn't match
     * any known command, then the user is told that the input was incorrect.
     * At the end of the loop the information on the halls is always read in
     * case there have been any changes.
     */
    public void start() {
        System.out.println();
        System.out.println();
        
        System.out.println("--------------------------------------------");
        System.out.println("--You started the theater managing service--");
        System.out.println("--------------------------------------------");


        boolean continuing = true;
        while (continuing) {

            
            System.out.println();
            System.out.println();
            
            System.out.println("[1] Add a hall");
            System.out.println("[2] Change information");
            System.out.println("[3] Remove a hall");
            System.out.println("[4] See info on halls");
            System.out.println("[5] Go back");
            
            System.out.println();

            System.out.print("? ");
            String choice = reader.nextLine();

            if (commands.containsKey(choice)) {
                Command command = commands.get(choice);
                continuing = command.run();
            } else {
                System.out.println("Incorrect input, please give a number"
                        + "corresponding to the thing you wish to do");
            }
            
            readHalls();
        }
    }
    
    private void createCommands() {
        createCommand(new Add(reader, hallHandler, "1"));
        createCommand(new Change(reader, hallHandler, "2"));
        createCommand(new Remove(reader, hallHandler, "3"));
        createCommand(new SeeInfo(reader, hallHandler, "4"));
        createCommand(new End(reader, hallHandler, "5"));
    }
    
    private void createCommand(Command command) {
        commands.put(command.getName(), command);
    }
    
    private void readHalls() {
        hallHandler.readFile();
    }
    
    
}
