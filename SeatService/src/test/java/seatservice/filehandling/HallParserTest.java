package seatservice.filehandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;
import seatservice.domain.Hall;
import java.util.List;
import seatservice.domain.Halls;


public class HallParserTest {

    private HallParser hallParser;
    private HallAdder hallAdder;
    private String filePath = "src/test/testFile.xml";
    private Halls halls;

    @Before
    public void setUp() throws IOException {
        this.halls = new Halls();
        this.hallParser = new HallParser(filePath, halls);
        hallAdder = new HallAdder(filePath, halls);
        resetFileContent();
    }


    @After
    public void tearDown() throws IOException {
        resetFileContent();
    }


    @Test
    public void readFileReturnsFalseWithWrongFilePath() {
        hallParser.changeFilePath("false path");
        assertFalse(hallParser.readFile());
    }

    @Test
    public void fileIsFoundWithTheCorrectPath() {
        hallAdder.createNewHall("name", 2, 2);
        assertTrue(hallParser.readFile());
    }

    @Test
    public void hallIsParsedAndCreatedCorrectly() throws IOException, Exception {
        hallAdder.createNewHall("name", 3, 3);
        assertTrue(hallParser.readFile());

        assertTrue(hallParser.getHalls().getHalls().size() == 1);

        String toStringShouldBe = "name: name\nrows: " + 3
                + "\nseats in a row: " + 3 + "\n";

        assertEquals(toStringShouldBe, hallParser.getHalls().getHalls().get(0).toString());
    }

    @Test
    public void multipleHallsAreCreatedCorrectly() throws IOException {

        Random random = new Random();
        int manyHalls = random.nextInt(8) + 2;

        for (int i = 1; i <= manyHalls; i++) {
            int value = random.nextInt(4) + 1;
            hallAdder.createNewHall("name", value, i);
            hallParser.readFile();
            List<Hall> halls = this.halls.getHalls();
         
            String info = "name: name\nrows: " + value + "\nseats in a row: "
                    + i + "\n";
            assertEquals(info, halls.get(i - 1).toString());
        }

        assertTrue(hallParser.getHalls().getHalls().size() == manyHalls);
    }

    @Test
    public void changingOfFilePathWorks() {
        hallParser.changeFilePath("newPath");
        
        assertEquals("newPath", hallParser.getFilePath());
    }
    
    private void resetFileContent() throws IOException {
        FileWriter writer = new FileWriter(new File(filePath));
        writer.close();
    }
}
