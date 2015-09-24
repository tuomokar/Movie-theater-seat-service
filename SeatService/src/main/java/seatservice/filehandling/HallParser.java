package seatservice.filehandling;

import seatservice.domain.Hall;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import seatservice.domain.Halls;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.io.IOException;

/**
 * This class is responsible for reading and parsing through the database file
 * containing the information on the halls of the movie theater and creates hall
 * objects out of the information
 */
public class HallParser {

    private String filePath;
    private Halls halls;

    /**
     * The constructor sets the default filepath for the text file functioning
     * as the database for the halls and initializes the halls instance variable
     * that will contain any halls parsed while reading through the file.
     *
     * @param filePath
     */
    public HallParser(String filePath, Halls halls) {
        this.filePath = filePath;
        this.halls = halls;
    }

    /**
     * This method reads the file in the given path and parses it in order to
     * create hall objects from the information within the file. The method goes
     * through each line and at each line, it first checks if the line is one
     * that is between the informations of each hall. If it is, then the reader
     * moves on the next line, but if it is not, the line is split, with the
     * second index (index 1) being the one with the raw info on the hall (name,
     * amount of rows or amount of seats in a row). Then this info is put on the
     * "hallInformation" array, which has room for three elements (name, rows
     * and amount of seats within a row). If the line is the last of the
     * information required to create a hall, a new hall is created and the
     * "hallInformation" array is reseted for use in another one.
     *
     * @return true if the file reading and parsing succeeded
     */
    public boolean readFile() {

        try {
            Path path = FileSystems.getDefault().getPath(filePath);
            List<String> strings = Files.readAllLines(path);
            if (strings.isEmpty()) {
                return true;
            }

            System.out.println(strings);
            JAXBContext jaxbContext = JAXBContext.newInstance(Halls.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            jaxbUnmarshaller.unmarshal(new File(filePath));
            halls = (Halls) jaxbUnmarshaller.unmarshal(new File(filePath));

            halls.createSeatsForHalls();

        } catch (JAXBException exc) {
            return false;
        } catch (IOException exc) {
            return false;
        }

        return true;
    }

    /**
     * Returns the halls that were parsed when the file was read.
     *
     * @return the halls as a list
     */
    public Halls getHalls() {
        return halls;
    }

    /**
     * Returns the file path
     *
     * @return the file path
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Changes the current file path to the new path given as the parameter
     *
     * @param newPath
     */
    public void changeFilePath(String newPath) {
        filePath = newPath;
    }

    public Hall getHall(String name) {
        for (Hall hall : halls.getHalls()) {
            if (hall.getName().equals(name)) {
                return hall;
            }
        }
        return null;
    }

    private boolean lineIsTheLastNeededForAHall(String line) {
        return line.contains("seats in a row");
    }

    private boolean lineMarksSpaceBetweenHalls(String line) {
        return line.contains(";");
    }

    private Hall createNewHall(String[] hallInformation) {
        String hallName = hallInformation[0];
        int rows = Integer.parseInt(hallInformation[1]);
        int seatsInARow = Integer.parseInt(hallInformation[2]);

        Hall hall = new Hall(hallName, rows, seatsInARow);
        return hall;
    }

    private String[] resetHallInformation() {
        return new String[3];
    }

    private boolean hallIsNotYetOnTheList(Hall hall) {
        return !halls.contains(hall);
    }

    private String separateTheRawInfo(String[] lineSplit) {
        return lineSplit[1];
    }

}
