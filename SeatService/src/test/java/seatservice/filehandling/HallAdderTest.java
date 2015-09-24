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
import seatservice.domain.Halls;

/**
 * Tests the HallAdder class
 */
public class HallAdderTest {

    private HallAdder hallAdder;
    private String filePath = "src/test/testFile.xml";

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
        hallAdder = new HallAdder(filePath, new Halls());

    }

    /**
     * Some of the methods use a test file. This test file's content is reseted
     * after each test method
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
        assertEquals(filePath, hallAdder.getFilePath());
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
    public void fileWritingIsSuccessful() throws IOException, Exception {
        assertTrue(hallAdder.createNewHall("testHall", 2, 3));
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
        return new Random().nextInt(10) + 1;
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
        FileWriter writer = new FileWriter(new File(filePath));
        writer.close();
    }

}
