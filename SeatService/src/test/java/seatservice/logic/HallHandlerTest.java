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
    private String filePath = "src/test/testFile.txt";

    public HallHandlerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

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

    /**
     * Checks that the file path is correct after creation
     */
    @Test
    public void filePathIsCorrectAtStart() {
        assertEquals(filePath, hallHandler.getFilePath());
        assertEquals(filePath, hallHandler.getHallAdder().getFilePath());
        assertEquals(filePath, hallHandler.getHallParser().getFilePath());
    }
    
    /**
     * Checks that changing the file path works correctly
     */
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
        assertTrue(hallHandler.getHalls().isEmpty());
    }

    private void resetFileContent() throws IOException {
        FileWriter writer = new FileWriter(new File(filePath));
        writer.close();
    }
}
