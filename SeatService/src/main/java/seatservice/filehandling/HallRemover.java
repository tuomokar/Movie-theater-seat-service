
package seatservice.filehandling;

import seatservice.domain.Hall;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import seatservice.domain.Halls;

/**
 * This class is responsible for removing any wanted halls from the
 * xml file database
 */
public class HallRemover {
    
    private HallAdder hallAdder;
    private Halls halls;

    public HallRemover(HallAdder hallAdder, Halls halls) {  
        this.hallAdder = hallAdder;
        this.halls = halls;
    }

    /**
     * Removes a single hall from the database. In practice, the method
     * simply removes the wanted hall from the list of the halls and rewrites
     * all the remaining halls to the file.
     * 
     * @param hall
     */
    public void removeHall(Hall hall) {
        removeHallFromList(hall);
        writeRemainingHalls();
    }
    
    private void writeRemainingHalls() {
        hallAdder.writeAllTheHallsToTheFile();
    }
    
    private void removeHallFromList(Hall hall) {
        halls.getHalls().remove(hall);
    }
    
}
