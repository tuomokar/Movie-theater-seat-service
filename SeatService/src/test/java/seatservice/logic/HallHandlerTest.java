package seatservice.logic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the HallHandler class
 */
public class HallHandlerTest {

    private HallHandler hallHandler;
    private String filePath = "src/test/testFile.xml";

    @Before
    public void setUp() throws IOException {
        this.hallHandler = new HallHandler();
        hallHandler.changeFilePath(filePath);
        resetFileContent();
    }

    @After
    public void tearDown() throws IOException {
        resetFileContent();
    }

    @Test
    public void filePathIsCorrectAtStart() {
        assertEquals(filePath, hallHandler.getFilePath());
        assertEquals(filePath, hallHandler.getHallAdder().getFilePath());
        assertEquals(filePath, hallHandler.getHallParser().getFilePath());
    }
    

    @Test
    public void filePathIsChangedCorrectly() {
        String newPath = "newPath";
        hallHandler.changeFilePath(newPath);
        
        assertEquals(newPath, hallHandler.getFilePath());
        assertEquals(newPath, hallHandler.getHallAdder().getFilePath());
        assertEquals(newPath, hallHandler.getHallParser().getFilePath());
    }

    /**
     * Checks that there are no halls at creation
     */
    @Test
    public void noInformationOnHallsAtCreation() {
        assertTrue(hallHandler.getHalls().getHalls().isEmpty());
    }
    
    /**
     * Checks that adding a hall works
     * @throws IOException 
     */
    @Test
    public void addingHallWorks() throws IOException, Exception {
        hallHandler.addNewHall("name", 2, 3);
        hallHandler.readFile();
        
        assertTrue(hallHandler.getHalls().getHalls().size() == 1);
    }
    
    /**
     * Checks that removing a hall works
     * @throws IOException 
     */
    @Test
    public void removingHallWorks() throws IOException, Exception {
        hallHandler.addNewHall("name", 4, 3);
        hallHandler.readFile();
        assertTrue(hallHandler.getHalls().getHalls().size() == 1);
        
        hallHandler.removeHall("name");
        assertTrue(hallHandler.getHalls().getHalls().isEmpty());
    }

    private void resetFileContent() throws IOException {
        FileWriter writer = new FileWriter(new File(filePath));
        writer.close();
    }
}
