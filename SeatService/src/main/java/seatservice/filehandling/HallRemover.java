
package seatservice.filehandling;

import seatservice.domain.Hall;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is responsible for removing any wanted halls from the
 * text file database
 */
public class HallRemover {
    
    private HallParser hallParser;
    private HallAdder hallAdder;
    private String filePath;

    /**
     * Creates a new instance of HallRemover. Takes an instance of HallParser
     * as a parameter.
     * @param hallParser
     * @param filePath 
     */
    public HallRemover(HallParser hallParser,
            String filePath) {
        this.hallParser = hallParser;
        this.filePath = filePath;
    }

    /**
     * Removes a single hall from the database. In practice, the method
     * reads through the file to get all the current halls, then removes the
     * hall given as the parameter and writes the remaining halls to the 
     * database
     * @param hall
     * @throws IOException 
     */
    public void removeHall(Hall hall) throws IOException {
        readFile();
        removeHallFromList(hall);
        writeHalls();
    }
    
    private void writeHalls() throws IOException {
        FileWriter writer = new FileWriter(filePath);
        
        List<Hall> halls = hallParser.getHalls();
        
        for (Hall hall : halls) {
            writeHall(hall, writer);
        }
    }
    
    private void writeHall(Hall hall, FileWriter writer) throws IOException {
        writer.append(hall.toString());
        writer.append(";\n");
    }
    
    private void removeHallFromList(Hall hall) {
        hallParser.getHalls().remove(hall);
    }
    
    private void readFile() {
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
     */
    public HallParser getHallParser() {
        return hallParser;
    }
}
