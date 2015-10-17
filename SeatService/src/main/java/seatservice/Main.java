package seatservice;

import javax.swing.SwingUtilities;
import seatservice.userinterface.UserInterface;

/**
 * This class functions as the main class.
 * 
 * @author Tuomo Oila
 */
public class Main {

    /**
     * Creates the user interface and starts it.
     *
     * @param args
     */
    public static void main(String[] args) {

        UserInterface userInterface = new UserInterface();
        SwingUtilities.invokeLater(userInterface);

    }
}
