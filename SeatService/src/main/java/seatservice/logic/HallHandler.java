
package seatservice.logic;

import java.io.IOException;
import seatservice.domain.Hall;
import seatservice.filehandling.HallAdder;
import seatservice.filehandling.HallParser;
import java.util.List;

/**
 * This class abstracts the HallAdder and HallParser classes so that they're
 * used through this class
 * @author tuomo_000
 */
public class HallHandler {
    
    private HallAdder hallAdder;
    private HallParser hallParser;
    private String filePath;
    
    /**
     * Sets the default file path and creates the hallAdder and hallParser
     * instance variables with that file path
     */
    public HallHandler() {
        filePath = "Hall_Database.txt";
        
        this.hallAdder = new HallAdder(filePath);
        this.hallParser = new HallParser(filePath);
    }
    
    /**
     * The method changes the current file path to a new one that is given
     * as the parameter. The file path is changed for both hallAdder and 
     * hallParser.
     * @param filePath 
     */
    public void changeFilePath(String filePath) {
        this.filePath = filePath;
        
        this.hallAdder.changeFilePath(filePath);
        this.hallParser.changeFilePath(filePath);
    }
    
    /**
     * Adds a new hall's information to the text file database.
     * @param name
     * @param rows
     * @param seatsOnARow
     * @throws java.io.IOException
     */
    public void addNewHall(String name, int rows, int seatsOnARow) throws IOException {
        hallAdder.createNewHall(name, rows, seatsOnARow);
    }
    
    /**
     * Reads the file containing the information the information on the halls
     * and adds each parsed hall to the list encapsuulated in the hallParser
     * class
     */
    public void readFile() {
        hallParser.readFile();
    }
    
    /**
     * Returns the list of halls in thd database;
     * @return list of halls in the database
     */
    public List<Hall> getHalls() {
        return hallParser.getHalls();
    }
    
    /**
     * Returns the hallAdder
     * @return hallAdder
     */
    public HallAdder getHallAdder() {
        return hallAdder;
    }
    
    /**
     * Returns the hallParser
     * @return hallParser
     */
    public HallParser getHallParser() {
        return hallParser;
    }
    
    /**
     * Returns the current file path
     * @return file path
     */
    public String getFilePath() {
        return filePath;
    }
    
}
