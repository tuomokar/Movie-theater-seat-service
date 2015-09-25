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
import seatservice.domain.Halls;

/**
 * Tests the HallRemover class
 *
 * @author tuomo_000
 */
public class HallRemoverTest {

    private HallRemover hallRemover;
    private HallAdder hallAdder;
    private HallParser hallParser;
    private Halls halls;
    private String filePath = "src/test/testFile.xml";
    
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
        this.halls = new Halls();
        this.hallParser = new HallParser(filePath, halls);
        hallAdder = new HallAdder(filePath, halls);
        hallRemover = new HallRemover(hallAdder, halls);
        resetFileContent();
    }

    @After
    public void tearDown() throws IOException {
        resetFileContent();
    }
    
    @Test
    public void removingHallWorks() throws IOException, Exception {
        hallAdder.createNewHall("name", 2, 3);
        hallAdder.createNewHall("name2", 3, 4);
        hallParser.readFile();
        assertEquals(2, hallParser.getHalls().getHalls().size());
        
        hallRemover.removeHall(new Hall("name", 2, 3));
        
        assertTrue(halls.getHalls().size() == 1);
    }
    
    private void resetFileContent() throws IOException {
        FileWriter writer = new FileWriter(new File(filePath));
        writer.close();
    }
    
}
