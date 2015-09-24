
package seatservice;

import java.io.IOException;
import seatservice.filehandling.HallParser;
import seatservice.userinterface.EmployeeUI;

public class Main {
    
    public static void main(String[] args) throws IOException, Exception {
        EmployeeUI userInterface = new EmployeeUI();
        userInterface.start();
                            
    }
}
