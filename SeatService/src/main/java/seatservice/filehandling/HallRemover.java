
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
    
    private HallParser hallParser;
    private String filePath;
    private HallAdder hallAdder;
    private Halls halls;

    public HallRemover(HallParser hallParser,
            String filePath, HallAdder hallAdder, Halls halls) {
        
        this.hallParser = hallParser;
        this.filePath = filePath;
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
        hallParser.getHalls().getHalls().remove(hall);
    }
    
    
    /**
     * Changes the current file path to the new one given as the parameter
     * @param newPath 
     */
    public void changeFilePath(String newPath) {
        this.filePath = newPath;
    }

    public String getFilePath() {
        return filePath;
    }
    
    public HallParser getHallParser() {
        return hallParser;
    }
}
