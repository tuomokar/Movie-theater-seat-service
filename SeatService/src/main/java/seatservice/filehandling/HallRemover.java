
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
 * text file database
 */
public class HallRemover {
    
    private HallParser hallParser;
    private String filePath;
    private HallAdder hallAdder;
    private Halls halls;

    /**
     * Creates a new instance of HallRemover. Takes an instance of HallParser
     * as a parameter.
     * @param hallParser
     * @param filePath 
     */
    public HallRemover(HallParser hallParser,
            String filePath, HallAdder hallAdder, Halls halls) {
        
        this.hallParser = hallParser;
        this.filePath = filePath;
        this.hallAdder = hallAdder;
        this.halls = halls;
    }

    /**
     * Removes a single hall from the database. In practice, the method
     * reads through the file to get all the current halls, then removes the
     * hall given as the parameter and writes the remaining halls to the 
     * database
     * @param hall
     * @throws IOException 
     */
    public void removeHall(Hall hall) throws IOException, JAXBException {
        halls.getHalls().clear();
        readCurrentHalls();
        removeHallFromList(hall);
        writeRemainingHalls();
    }
    
    private void writeRemainingHalls() throws IOException, JAXBException {
        hallAdder.writeMultipleHallsAtOnce(halls);
    }
    
    private void writeHall(Hall hall, FileWriter writer) throws IOException {
        writer.append(hall.toString());
        writer.append(";\n");
    }
    
    private void removeHallFromList(Hall hall) {
        hallParser.getHalls().getHalls().remove(hall);
    }
    
    private void readCurrentHalls() {
        hallParser.readFile();
    }
    
    /**
     * Changes the current file path to the new one given as the parameter
     * @param newPath 
     */
    public void changeFilePath(String newPath) {
        this.filePath = newPath;
    }

    /**
     * Returns the current file path
     * @return 
     */
    public String getFilePath() {
        return filePath;
    }
    
    /**
     * Returns the hallParser
     * @return hallParser
     */
    public HallParser getHallParser() {
        return hallParser;
    }
}
