/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatservice.userinterface.theatermanager.commands;

import java.util.Scanner;
import seatservice.logic.HallHandler;


public class End extends Command {

    public End(Scanner reader, HallHandler hallHandler, String name) {
        super(reader, hallHandler, name);
    }

    /**
     * Runs this command and returns false at the end
     * @return 
     */
    @Override
    public boolean run() {
        System.out.println("just testing");
        return false;
    }
    
}
