package seatservice.filehandling;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import java.lang.StringBuilder;
import java.util.Random;

/**
 * Tests the HallAdder class
 */
public class HallAdderTest {

    private HallAdder hallAdder;
    private String filePath = "src/test/testFile.txt";

    // doesn't work for some reason
//    @Rule
//    public TemporaryFolder tempFolder = new TemporaryFolder();
    public HallAdderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        hallAdder = new HallAdder();

    }

    /**
     * Some of the methods use a test file. This test file's content is
     * reseted after each test method
     * 
     * @throws IOException 
     */
    @After
    public void tearDown() throws IOException {
        resetFileContent();
    }

    /**
     * Checks that the file path is set correctly at the class's creation
     */
    @Test
    public void filePathIsCorrectAtTheStart() {
        assertEquals("Hall_Database.txt", hallAdder.getFilePath());
    }

    /**
     * Checks that the file path can be changed
     */
    @Test
    public void filePathChangeWorks() {
        hallAdder.changeFilePath("test");
        assertEquals("test", hallAdder.getFilePath());
    }

    /**
     * Checks that the file writing works.
     *
     * @throws java.io.IOException
     */
    @Test
    public void fileWritingIsSuccessful() throws IOException {
        hallAdder.changeFilePath(filePath);

        // doesn't work for some reason (i.e. the createNewHall method of the Hall
        // either doesn't use this existing temporary file or uses it
        // but for some reason the test doesn't discard the file after this method
//        File temp = tempFolder.newFile("src/test/testFile.txt");
                   
        assertTrue(hallAdder.createNewHall("testHall", 2, 3));       
    } 

    /**
     * Writes once to the text file and sees that the information is written
     * successfully and correctly. After writing the information the method
     * reads through the file and appends all the content to a stringbuilder, 
     * which is then checked that it contains all the information of the hall.
     * 
     * @throws IOException 
     */
    @Test
    public void correctTextIsWritten() throws IOException {
        hallAdder.changeFilePath(filePath);
        String name = "testHall";
        int rows = 4;
        int seatsAtARow = 5;

        assertTrue(hallAdder.createNewHall(name, rows, seatsAtARow));

        StringBuilder sb = parseFile();
        assertTrue(hasTheRightInfo(sb, name, rows, seatsAtARow));
    }

    /**
     * Writes information of multiple halls to the text file and checks
     * that each hall's information is written successfully and correctly
     * After writing the information, the method reads through the file
     * and appends all the content to a stringbuilder. The stringbuilder is
     * then used to check that it contains the information of each given hall.
     * The information of the halls is taken from a 2D array which the method
     * creates
     * 
     * @throws IOException 
     */
    @Test
    public void multipleHallsAreWrittenCorrectly() throws IOException {
        hallAdder.changeFilePath(filePath);
        Object[][] hallInfo = infoOnMultipleTestHalls();
        
        assertTrue(hallAdder.createNewHall((String) hallInfo[0][0],
                (int) hallInfo[0][1], (int) hallInfo[0][2]));
        assertTrue(hallAdder.createNewHall((String) hallInfo[1][0],
                (int) hallInfo[1][1], (int) hallInfo[1][2]));
        assertTrue(hallAdder.createNewHall((String) hallInfo[2][0],
                (int) hallInfo[2][1], (int) hallInfo[2][2]));
        assertTrue(hallAdder.createNewHall((String) hallInfo[3][0],
                (int) hallInfo[3][1], (int) hallInfo[3][2]));
        assertTrue(hallAdder.createNewHall((String) hallInfo[4][0],
                (int) hallInfo[4][1], (int) hallInfo[4][2]));

        StringBuilder sb = parseFile();
        
        assertTrue(hasTheRightInfo(sb, (String) hallInfo[0][0],
                (int) hallInfo[0][1], (int) hallInfo[0][2]));
        assertTrue(hasTheRightInfo(sb, (String) hallInfo[1][0],
                (int) hallInfo[1][1], (int) hallInfo[1][2]));       
        assertTrue(hasTheRightInfo(sb, (String) hallInfo[2][0],
                (int) hallInfo[2][1], (int) hallInfo[2][2]));
        assertTrue(hasTheRightInfo(sb, (String) hallInfo[3][0],
                (int) hallInfo[3][1], (int) hallInfo[3][2]));      
        assertTrue(hasTheRightInfo(sb, (String) hallInfo[4][0],
                (int) hallInfo[4][1], (int) hallInfo[4][2]));
    }

    private Object[][] infoOnMultipleTestHalls() {
        Object[][] info = new Object[5][3];
        info[0][0] = "testHall1";
        info[1][0] = "testHall2";
        info[2][0] = "testHall3";
        info[3][0] = "testHall4";
        info[4][0] = "testHall5";

        info[0][1] = getRandomNumber();
        info[1][1] = getRandomNumber();
        info[2][1] = getRandomNumber();
        info[3][1] = getRandomNumber();
        info[4][1] = getRandomNumber();

        info[0][2] = getRandomNumber();
        info[1][2] = getRandomNumber();
        info[2][2] = getRandomNumber();
        info[3][2] = getRandomNumber();
        info[4][2] = getRandomNumber();

        return info;
    }

    private int getRandomNumber() {
        return new Random().nextInt(100000);
    }

    private StringBuilder parseFile() throws FileNotFoundException {
        Scanner reader = new Scanner(new File(filePath));

        StringBuilder sb = new StringBuilder();

        while (reader.hasNext()) {
            sb.append(reader.nextLine());
            sb.append("\n");
        }
        return sb;
    }

    private boolean hasTheRightInfo(StringBuilder sb,
            String name, int rows, int seatsAtARow) {

        return sb.toString().contains("name: " + name + "\n"
                + "rows: " + rows + "\nseats in a row: " + seatsAtARow + "\n;");

    }
    
    private void resetFileContent() throws IOException {
        hallAdder.changeFilePath(filePath);
        FileWriter writer = new FileWriter(new File(filePath));
        writer.close();
    }

}
