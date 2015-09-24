package seatservice.logic;

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
     * Sets the default file path and creates the hallAdder and hallParser
     * instance variables with that file path
     */
    public HallHandler() {
        filePath = "Hall_Database.xml";

        this.halls = new Halls();
        this.hallAdder = new HallAdder(filePath, halls);
        this.hallParser = new HallParser(filePath, halls);
        this.hallRemover = new HallRemover(hallParser, filePath);
    }

    /**
     * The method changes the current file path to a new one that is given as
     * the parameter. The file path is changed for both hallAdder and
     * hallParser.
     *
     * @param filePath
     */
    public void changeFilePath(String filePath) {
        this.filePath = filePath;

        this.hallAdder.changeFilePath(filePath);
        this.hallParser.changeFilePath(filePath);
        this.hallRemover.changeFilePath(filePath);
    }

    /**
     * Adds a new hall's information to the text file database.
     *
     * @param name
     * @param rows
     * @param seatsOnARow
     */
    public void addNewHall(String name, int rows, int seatsOnARow) throws JAXBException {
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
     *
     * @return list of halls in the database
     */
    public List<Hall> getHallsAsList() {
        return hallParser.getHalls().getHalls();
    }
    
    public Halls getHalls() {
        return halls;
    }

    /**
     * Returns the hallAdder
     *
     * @return hallAdder
     */
    public HallAdder getHallAdder() {
        return hallAdder;
    }

    /**
     * Returns the hallParser
     *
     * @return hallParser
     */
    public HallParser getHallParser() {
        return hallParser;
    }

    /**
     * Returns the current file path
     *
     * @return file path
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Removes a hall. The hall to be removed is decided by the name given as
     * the parameter. The method finds the matching hall, which is null in case
     * a matching hall isn't found. In that case, the method returns false and
     * doesn't do anything. If the hall is found, the hall is removed and the
     * method returns true.
     *
     * @param name
     * @return true if the hall is found and removed successfully
     * @throws IOException
     */
    public boolean removeHall(String name) throws IOException {
        Hall hall = hallParser.getHall(name);

        if (hall == null) {
            return false;
        }

        hallRemover.removeHall(hall);
        return true;

    }
    
    /**
     * Checks that that there is no hall with the given name yet
     * @param name
     * @return 
     */
    public boolean hallExists(String name) {
        List<Hall> halls = getHalls().getHalls();
        for (Hall hall : halls) {
            if (hall.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
