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
 * This class is responsible for unmarshalling the xml file
 */
public class HallParser {

    private String filePath;
    private Halls halls;

    /**
     * The constructor sets the default filepath for the xml file and sets the
     * 'halls' instance variable.
     *
     * @param filePath
     * @param halls
     */
    public HallParser(String filePath, Halls halls) {
        this.filePath = filePath;
        this.halls = halls;
    }

    /**
     * This method unmarshals the xml file to halls and puts them all to the
     * 'halls' instance variable. First the method checks if the xml file
     * doesn't contain any halls (in practice meaning that the file is empty or
     * it has only the line specifying the xml version) and in such a case,
     * immediately returns false. If there are any halls in the file, the method
     * unmarshals them to objects. At the end when all the halls are created,
     * the method also creates the seats for them. If an error is encountered at
     * any point during the method, false is returned.
     *
     * @return true if the file unmarshalling succeeded
     */
    public boolean readFile() {     
        if (databaseHasHalls()) {
            return false;
        }

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Halls.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            jaxbUnmarshaller.unmarshal(new File(filePath));
            halls = (Halls) jaxbUnmarshaller.unmarshal(new File(filePath));

            createSeatsForUnmarshalledHalls();

        } catch (JAXBException exc) {
            return false;
        }
        return true;
    }
    
    private void createSeatsForUnmarshalledHalls() {
        halls.createSeatsForHalls();
    }

    private boolean databaseHasHalls() {
        Path path = FileSystems.getDefault().getPath(filePath);
        try {
            List<String> strings = Files.readAllLines(path);
            if (strings.isEmpty() || strings.size() == 1) {
                return false;
            }
        } catch (IOException exc) {
            return false;
        }
        return true;
    }

    public Halls getHalls() {
        return halls;
    }

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

    /**
     * Searches for a hall that would have the name that is the search parameter
     * In case a matching hall is found, that hall is returned. If no matching
     * hall is found, the method returns null.
     *
     * @param name
     * @return A hall that has a name that matches the name with which the hall
     * is searched by. If no hall is found, returns null.
     */
    public Hall getHall(String name) {
        return halls.findByName(name);
    }

}
