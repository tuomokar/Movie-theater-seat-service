package seatservice.filehandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import seatservice.domain.Hall;
//import seatservice.domain.Halls;
import seatservice.domain.Halls;

/**
 * This class is responsible for adding new halls to the movie theater's
 * database (which is a text file)
 */
public class HallAdder {

    private String filePath;
    private Halls halls;

    /**
     * Sets name of the text file containing the information on the halls
     *
     * @param filePath
     * @param halls
     */
    public HallAdder(String filePath, Halls halls) {
        this.filePath = filePath;
        this.halls = halls;
    }

    /**
     * Writes information about a new hall to the text file. In order for the
     * file writing to succeed, the parameters must be valid. The hall's name
     * must not be null or empty and the rows and the amount of seats in a row
     * must be more than zero.
     *
     * @param hallName
     * @param rows
     * @param seatsInARow
     * @return whether or not the writing to the file succeeded
     */
    public boolean createNewHall(String hallName, int rows, int seatsInARow) throws JAXBException {
//        try {
            Hall hall = new Hall(hallName, rows, seatsInARow);
            halls.addHall(hall);

            JAXBContext jaxbContext = JAXBContext.newInstance(Halls.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(halls, new File(filePath));
//        } catch (JAXBException exc) {
//            throw new JAXBException("didn't succeed");
//            System.out.println("didn't succeed");
//            return false;
//        }
        return true;
    }

    private boolean checkParameters(String name, int rows, int seatsInARow) {
        return name != null && !name.isEmpty() && rows > 0 && seatsInARow > 0;
    }

    /**
     * Changes the current file path to a new one that is given as the parameter
     *
     * @param newPath
     */
    public void changeFilePath(String newPath) {
        filePath = newPath;
    }

    /**
     * Returns the current file path of the file
     *
     * @return file
     */
    public String getFilePath() {
        return filePath;
    }

}
