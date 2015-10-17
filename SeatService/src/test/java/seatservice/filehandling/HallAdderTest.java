package seatservice.filehandling;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import seatservice.domain.Hall;
import seatservice.domain.Halls;
import java.util.UUID;


public class HallAdderTest {

    private HallAdder hallAdder;
    private String filePath = "src/test/testFile.xml";

    @Before
    public void setUp() {
        hallAdder = new HallAdder(filePath, new Halls());
    }

    @After
    public void tearDown() throws IOException {
        resetFileContent();
    }

    @Test
    public void filePathIsCorrectAtTheStart() {
        assertEquals(filePath, hallAdder.getFilePath());
    }

    @Test
    public void filePathChangeWorks() {
        hallAdder.changeFilePath("test");
        assertEquals("test", hallAdder.getFilePath());
    }

    @Test
    public void fileWritingIsSuccessful() {
        assertTrue(hallAdder.createNewHall("testHall", 2, 3));
        assertTrue(hallAdder.getHalls().getHalls().size() == 1);
        assertTrue(hallAdder.getHalls().contains(new Hall("testHall", 2, 3)));
    }
    
    @Test
    public void writingMultipleHallsIsSuccessful() {
        Object[][] info = infoOnMultipleTestHalls();
        
        for (int i = 0; i < info.length; i++) {
            String name = (String) info[i][0];
            Integer rows = (Integer) info[i][1];
            Integer seats = (Integer) info[i][2];
            assertTrue(hallAdder.createNewHall(name, rows, seats));
            assertTrue(hallAdder.getHalls().getHalls().size() == (i + 1));
            assertTrue(hallAdder.getHalls().contains(new Hall(name, rows, seats)));
        }
    }

    private Object[][] infoOnMultipleTestHalls() {
        Object[][] info = new Object[5][3];
        info[0][0] = getRandomName();
        info[1][0] = getRandomName();
        info[2][0] = getRandomName();
        info[3][0] = getRandomName();
        info[4][0] = getRandomName();

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
    
    private String getRandomName() {
        return UUID.randomUUID().toString().substring(1, 10);
    }

    private Integer getRandomNumber() {
        return new Random().nextInt(10) + 1;
    }

    private void resetFileContent() throws IOException {
        FileWriter writer = new FileWriter(new File(filePath));
        writer.close();
    }

}
