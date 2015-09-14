package seatservice.filehandling;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is responsible for adding new halls to the movie theater's
 * database (which is a text file)
 */
public class HallAdder {

    private String filePath;

    /**
     * Sets name of the text file containing the information on the halls
     */
    public HallAdder(String filePath) {
        this.filePath = filePath;
    }
      
    /**
     * Writes information about a new hall to the text file. In order for the
     * file writing to succeed, the parameters must be valid. The hall's name 
     * must not be null or empty and the rows and the amount of seats in a row 
     * must be more than zero.
     * @param hallName
     * @param rows
     * @param seatsInARow
     * @return whether or not the writing to the file succeeded
     * @throws IOException 
     */
    public boolean createNewHall(String hallName, int rows, int seatsInARow) throws IOException {
        if (!checkParameters(hallName, rows, seatsInARow)) {
            return false;
        }
        
        FileWriter writer = new FileWriter(filePath, true);
        
        writer.write("name: " + hallName + "\n");
        writer.write("rows: " + rows + "\n");
        writer.write("seats in a row: " + seatsInARow + "\n");
        writer.write(";\n");
        writer.close();
        
        return true;
    }
    
    private boolean checkParameters(String name, int rows, int seatsInARow) {
        return name != null && !name.isEmpty() && rows > 0 && seatsInARow > 0;
    }
    
    /**
     * Changes the current file path to a new one that is given as the parameter
     * @param newPath 
     */
    public void changeFilePath(String newPath) {
        filePath = newPath;
    }
    
    /**
     * Returns the current file path of the file
     * @return file
     */
    public String getFilePath() {
        return filePath;
    }

}
