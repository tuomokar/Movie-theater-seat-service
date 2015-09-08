package seatservice.filehandling;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is responsible for adding new halls to the movie theater's
 * database (which is a text file)
 */
public class HallAdder {

    private String fileName;

    /**
     * Sets name of the text file containing the information on the halls
     */
    public HallAdder() {
        fileName = "Hall_Database.txt";
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
        
        FileWriter writer = new FileWriter(fileName, true);
        
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

}
