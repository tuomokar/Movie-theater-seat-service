package seatservice.filehandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import seatservice.domain.Hall;
//import seatservice.domain.Halls;
import seatservice.domain.Halls;

/**
 * This class is responsible for adding new halls to the movie theater's
 * database (which is an xml file)
 */
public class HallAdder {

    private String filePath;
    private Halls halls;

    /**
     * Sets name of the xml file containing the information on the halls and
     * also sets the 'halls' instance variable to the one given as the parameter
     *
     * @param filePath
     * @param halls
     */
    public HallAdder(String filePath, Halls halls) {
        this.filePath = filePath;
        this.halls = halls;
    }

    /**
     * Writes information about a new hall to the xml file by using JAXB. First
     * a new hall is created from the parameters given and it's added to the
     * list of current halls. Then all the halls are written into the xml file.
     * In case there's an error, the method returns false, but otherwise the
     * method returns true.
     *
     * @param hallName
     * @param rows
     * @param seatsInARow
     * @return whether or not the writing to the file succeeded
     */
    public boolean createNewHall(String hallName, int rows, int seatsInARow) {
        Hall hall = new Hall(hallName, rows, seatsInARow);
        halls.addHall(hall);
        boolean success = writeAllTheHallsToTheFile();
        return success;
        
    }

    /**
     * Writes all the halls currently in the list of the halls into the
     * xml file by using JAXB. Returns false if an error is encountered during
     * the marshalling and otherwise returns true.
     *
     * @param halls
     * @return
     * @throws JAXBException
     */
    public boolean writeAllTheHallsToTheFile() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Halls.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(halls, new File(filePath));
        } catch (JAXBException exc) {
            return false;
        }
        return true;
    }

    /**
     * Changes the current file path to a new one that is given as the parameter
     *
     * @param newPath
     */
    public void changeFilePath(String newPath) {
        filePath = newPath;
    }

    public String getFilePath() {
        return filePath;
    }

}
