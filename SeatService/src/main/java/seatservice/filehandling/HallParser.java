package seatservice.filehandling;

import seatservice.domain.Hall;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import seatservice.domain.Halls;

/**
 * This class is responsible for unmarshalling the xml file functioning as the
 * database
 * 
 * @author Tuomo Oila
 */
public class HallParser {

    private String filePath;
    private Halls halls;
    private Halls tempHalls;

    /**
     * The constructor sets the default filepath for the xml file and sets the
     * <code>halls</code> instance variable.
     *
     * @param filePath the filepath to be used
     * @param halls instance of the <code>Halls</code> class
     */
    public HallParser(String filePath, Halls halls) {
        this.filePath = filePath;
        this.halls = halls;
    }

    /**
     * Using JAXB this method unmarshals the xml file to <code>Hall</code> and 
     * puts them all to the <code>halls</code> instance variable. Once all the
     * halls are unmarshalled, the seats are created for each unmarshalled
     * hall.
     * To prevent any possible overwriting bug, the halls are unmarshalled
     * into a different instance variable and then added from that to the actual
     * instance variable that the program uses. After doing this, <code>tempHalls</code>
     * is set to null.
     * If an error is encountered at any point during the method, false is 
     * returned. Otherwise the method returns true.
     * @return true if the file unmarshalling succeeded
     */
    public boolean readFile() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Halls.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            tempHalls = (Halls) jaxbUnmarshaller.unmarshal(new File(filePath));
            
            clearCurrentHalls();
            setTempHallsToActualHalls();

            createSeatsForUnmarshalledHalls();

        } catch (JAXBException exc) {
            return false;
        }

        return true;
    }
    
    private void clearCurrentHalls() {
        halls.getHalls().clear();
    }

    private void setTempHallsToActualHalls() {
        for (Hall hall : tempHalls.getHalls()) {
            halls.addHall(hall);
        }
    }

    private void createSeatsForUnmarshalledHalls() {
        halls.createSeatsForHalls();
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
     * @param newPath the new file path to be used
     */
    public void changeFilePath(String newPath) {
        filePath = newPath;
    }

}
