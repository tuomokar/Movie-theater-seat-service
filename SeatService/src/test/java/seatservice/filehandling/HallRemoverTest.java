package seatservice.filehandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import seatservice.domain.Hall;

/**
 * Tests the HallRemover class
 *
 * @author tuomo_000
 */
public class HallRemoverTest {

    private HallRemover hallRemover;
    private HallAdder hallAdder;
    private String filePath = "src/test/testFile.txt";
    
    public HallRemoverTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        hallRemover = new HallRemover(new HallParser(filePath), filePath);
        hallAdder = new HallAdder(filePath);
        resetFileContent();
    }

    @After
    public void tearDown() {
    }

    /**
     * Checks that the file path is set correctly at creation
     */
    @Test
    public void filePathIsCorrectAtTheStart() {
        assertEquals(filePath, hallRemover.getFilePath());
    }

    /**
     * Checks that the file path can be changed
     */
    @Test
    public void filePathChangeWorks() {
        hallRemover.changeFilePath("test");
        assertEquals("test", hallRemover.getFilePath());
    }
    
    @Test
    public void removingHallWorks() throws IOException {
        hallAdder.createNewHall("name", 2, 3);
        hallAdder.createNewHall("name2", 3, 4);
        hallRemover.getHallParser().readFile();
        assertEquals(2, hallRemover.getHallParser().getHalls().size());
        
        hallRemover.removeHall(new Hall("name", 2, 3));
        
        assertEquals(1, hallRemover.getHallParser().getHalls().size());    
    }
    
    private void resetFileContent() throws IOException {
        FileWriter writer = new FileWriter(new File(filePath));
        writer.close();
    }
    
}
