
package seatservice;

import java.io.IOException;
import seatservice.filehandling.HallParser;
import seatservice.userinterface.EmployeeUI;

/**
 * This class functions as the main class.
 */
public class Main {
    
    /**
     * Creates the user interface and starts it.
     * @param args
     */
    public static void main(String[] args) {
        EmployeeUI userInterface = new EmployeeUI();
        userInterface.start();
                            
    }
}
