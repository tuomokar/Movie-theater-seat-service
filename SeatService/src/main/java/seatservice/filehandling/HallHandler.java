package seatservice.filehandling;

import java.io.IOException;
import seatservice.domain.Hall;
import seatservice.filehandling.HallAdder;
import seatservice.filehandling.HallParser;
import java.util.List;
import javax.xml.bind.JAXBException;
import seatservice.domain.Halls;
import seatservice.filehandling.HallRemover;

/**
 * This class abstracts the HallAdder, HallParser and HallRemover classes so
 * that they're all used through this single class
 */
public class HallHandler {

    private HallAdder hallAdder;
    private HallParser hallParser;
    private HallRemover hallRemover;
    private String filePath;
    private Halls halls;

    /**
     * Sets a default file path and initializes all the other instance
     * variables. Note that the 'halls' instance variable is not initialized
     * here, but the value for it is set only when the file is read elsewhere.
     */
    public HallHandler() {
        filePath = "Hall_Database.xml";
        this.halls = new Halls();

        this.hallParser = new HallParser(filePath, halls);
        this.hallAdder = new HallAdder(filePath, halls);     
        this.hallRemover = new HallRemover(hallAdder, halls);
    }

    /**
     * The method changes the current file path to the new one given as
     * the parameter. The file path is changed for both hallAdder and
     * hallParser.
     *
     * @param filePath
     */
    public void changeFilePath(String filePath) {
        this.filePath = filePath;

        this.hallAdder.changeFilePath(filePath);
        this.hallParser.changeFilePath(filePath);
    }

    /**
     * Adds a new hall's information to the text file database.
     *
     * @param name
     * @param rows
     * @param seatsOnARow
     */
    public void addNewHall(String name, int rows, int seatsOnARow) {
        hallAdder.createNewHall(name, rows, seatsOnARow);
    }

    /**
     * Unmarshals the xml file to <code>hall</code> objects and adds them all to the list
     * encapculated by the <code>halls</code> instance variable.
     */
    public void readFile() {
        hallParser.readFile();
    }

    /**
     * Returns the list of halls in the database;
     *
     * @return list of halls in the database
     */
    public List<Hall> getHallsAsList() {
        return halls.getHalls();
    }
    
    public Halls getHalls() {
        return halls;
    }

    public HallAdder getHallAdder() {
        return hallAdder;
    }

    public HallParser getHallParser() {
        return hallParser;
    }


    public String getFilePath() {
        return filePath;
    }

    /**
     * Removes a hall. The hall to be removed is decided by the name given as
     * the parameter. The method finds the matching hall, which is null in case
     * a matching hall isn't found. In that case, the method returns false and
     * doesn't do anything. If the hall is found, the hall is removed and if
     * the removing works, true is returned.
     *
     * @param name
     * @return true if the hall is found and removed successfully. If there
     * was found no hall matching the name searched by or if the removing isn't
     * successful other, false is returned
     */
    public boolean removeHall(String name) {
        Hall hall = halls.findByName(name);

        if (hall == null) {
            return false;
        }

        boolean success = hallRemover.removeHall(hall);
        return success;

    }
    
    /**
     * Checks that that there is no hall with the given name yet.
     * @param name
     * @return true if there exists a hall with the given name
     */
    public boolean hallExists(String name) {
        return halls.findByName(name) != null;
    }
    
    
    /**
     * Returns the hall that matches the name. Returns null if no hall is found
     * or if null value is given as the parameter
     * @param name the name of the hall that is searched for
     * @return the found hall object, or null if no hall is found
     */
    public Hall findHallByName(String name) {
        return halls.findByName(name);
    }
    
    public void updateHall(String name, int newRows, int newSeats) {
        Hall hall = findHallByName(name);
        if (hall == null) {
            return;
        }
        
        hall.setAmountOfRows(newRows);
        hall.setAmountOfSeatsWithinRow(newSeats);
    }

}
