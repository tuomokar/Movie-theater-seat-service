package seatservice.filehandling;


import seatservice.domain.Hall;
import seatservice.domain.Halls;

import java.util.List;

/**
 * This class abstracts the HallAdder, HallParser and HallRemover classes so
 * that they're all used through this single class
 * 
 * @author Tuomo Oila
 */
public class HallHandler {

    private HallAdder hallAdder;
    private HallParser hallParser;
    private HallRemover hallRemover;
    private String filePath;
    private Halls halls;

    /**
     * Sets a default file path and initializes all the other instance
     * variables.
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
     * the parameter. The file path is changed for both <code>hallAdder</code> and
     * <code>hallParser</code>.
     *
     * @param filePath the new filepath to be used
     */
    public void changeFilePath(String filePath) {
        this.filePath = filePath;

        this.hallAdder.changeFilePath(filePath);
        this.hallParser.changeFilePath(filePath);
    }

    /**
     * Adds a new hall's information to the text file database.
     *
     * @param name the name of the new hall-to-be
     * @param rows the amount of rows of the new hall-to-be
     * @param seatsOnARow the amount of seats on a row of the new hall-to-be
     */
    public void addNewHall(String name, int rows, int seatsOnARow) {
        hallAdder.createNewHall(name, rows, seatsOnARow);
    }

    /**
     * Unmarshals the xml file to <code>Hall</code> objects and adds them all to 
     * the list encapculated by the <code>halls</code> instance variable.
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
     * the parameter. The method finds the matching hall and tries to remove it.
     * If the removal action is successful, the method returns true.
     * If no matching hall is found, i.e. <code>hall</code> is set to null,
     * the method returns false without trying to remove it.
     *
     * @param name the name of the hall to be removed
     * @return true if the hall is found and removed successfully. If there
     * was found no hall matching the name searched by or if the removing isn't
     * successful other, false is returned
     */
    public boolean removeHall(String name) {
        Hall hall = findHallByName(name);

        if (hall == null) {
            return false;
        }

        boolean success = hallRemover.removeHall(hall);
        return success;

    }
    
    /**
     * Checks that that there is no hall with the given name yet
     * @param name the name of the hall to be searched for
     * @return true if there exists a hall with the given name
     */
    public boolean hallExists(String name) {
        return halls.findByName(name) != null;
    }
    
    
    /**
     * Returns the hall that matches the name given as the parameter. Returns 
     * null if no hall is found or if null value is given as the parameter
     * @param name the name of the hall that is searched for
     * @return the found hall object, or null if no hall is found
     */
    public Hall findHallByName(String name) {
        return halls.findByName(name);
    }
    
    /**
     * Updates a single hall in the database file. The method receives
     * the name of the hall to be updated and searches for the hall with that
     * name. If a matching hall is found, the amount of rows and amount of seats
     * on a row is updated for that hall and the database file is updated
     * by rewriting the current halls to it.
     * @param name the name of the hall to be searched for
     * @param newRows the new amount of rows
     * @param newSeats the new amount of seats
     */
    public void updateHall(String name, int newRows, int newSeats) {
        Hall hall = findHallByName(name);
        if (hall == null) {
            return;
        }
        
        hall.updateRowsAndSeats(newRows, newSeats);
        hallAdder.writeAllTheHallsToTheFile();
    }

}
