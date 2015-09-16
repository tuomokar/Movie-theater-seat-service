
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

public class TheaterManagingUI {

    private HallHandler hallHandler;
    private Scanner reader;
    private Map<String, Command> commands;

    public TheaterManagingUI(HallHandler hallHandler, Scanner reader) {
        this.hallHandler = hallHandler;
        this.reader = reader;
        this.commands = new HashMap<>();
        createCommands();
    }
    
    public void start() {
        System.out.println();
        System.out.println();
        
        System.out.println("--------------------------------------------");
        System.out.println("--You started the theater managing service--");
        System.out.println("--------------------------------------------");

        System.out.println();

        boolean continuing = true;
        while (continuing) {

            System.out.println();
            
            System.out.println("[1] Add a hall");
            System.out.println("[2] Change information");
            System.out.println("[3] Remove a hall");
            System.out.println("[4] See info on halls");
            System.out.println("[5] Go back");
            
            System.out.println();

            String choice = reader.nextLine();

            if (commands.containsKey(choice)) {
                Command command = commands.get(choice);
                continuing = command.run();
            } else {
                System.out.println("Incorrect input");
            }
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
    
    
}
