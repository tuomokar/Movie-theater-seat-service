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
import java.util.Random;
import seatservice.filehandling.HallAdder;
import seatservice.filehandling.HallParser;

/**
 * Tests the HallParser class
 */
public class HallParserTest {

    private HallParser hallParser;
    private HallAdder hallAdder;
    private String filePath = "src/test/testFile.txt";

    public HallParserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Before each test, initializes the hallParser and hallAdder instance
     * variables. The default filePath is the same for both.
     * The method also resets the text file's content in case aanother 
     * test method has written something in it.
     * @throws IOException
     */
    @Before
    public void setUp() throws IOException {
        this.hallParser = new HallParser(filePath);
        hallAdder = new HallAdder(filePath);
        resetFileContent();
    }

    /**
     * Resets the test file's content after each method
     */
    @After
    public void tearDown() throws IOException {
        resetFileContent();
    }

    /**
     * Checks that the readFile method returns false if file path is false,
     * meaning the file isn't found
     */
    @Test
    public void readFileReturnsFalseWithWrongFilePath() {
        hallParser.changeFilePath("false path");
        assertFalse(hallParser.readFile());
    }
    
    /**
     * Checks that the readFile method finds the file in the path that is given
     * to the class in its constructor. Meaning, the method returns true.
     */
    @Test
    public void fileIsFoundWithTheCorrectPath() {
        assertTrue(hallParser.readFile());
    }
    
    /**
     * Checks that the readFile method correctly creates a Hall object
     * from the info in the text file
     * @throws IOException 
     */
    @Test
    public void hallIsParsedAndCreatedCorrectly() throws IOException {
        hallAdder.createNewHall("name", 3, 3);
        assertTrue(hallParser.readFile());
        assertTrue(hallParser.getHalls().size() == 1);
    }
    
    /**
     * Checks that the readFile method correctly creates multiple Hall objects
     * from the info in the text file. For this to happen, it first uses the
     * hallAdder instance variable to create a random amount of halls into
     * the file, and then reads the file and checks that the amount of halls
     * matches the amount of halls written into the file.
     * 
     * @throws IOException 
     */
    @Test
    public void multipleHallsAreCreatedCorrectly() throws IOException {

        Random random = new Random();
        int manyHalls = random.nextInt(8) + 2;
        
        for (int i = 1; i <= manyHalls; i++) {
            int value = random.nextInt(4) + 1;
            hallAdder.createNewHall("name", value, i);
        }

        hallParser.readFile();
        
        assertTrue(hallParser.getHalls().size() == manyHalls);
    }
    
    /**
     * Checks that the file path change works properly
     */
    @Test
    public void changingOfFilePathWorks() {
        hallParser.changeFilePath("newPath");
        
        assertEquals("newPath", hallParser.getFilePath());
    }
    
    private void resetFileContent() throws IOException {
        FileWriter writer = new FileWriter(new File("src/test/testFile.txt"));
        writer.close();
    }
}