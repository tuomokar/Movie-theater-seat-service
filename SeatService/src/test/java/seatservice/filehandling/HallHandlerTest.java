package seatservice.filehandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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

    @Test
    public void noInformationOnHallsAtCreation() {
        assertTrue(hallHandler.getHalls().getHalls().isEmpty());
    }
    
    @Test
    public void addingHallWorks() {
        hallHandler.addNewHall("name", 2, 3);
        hallHandler.readFile();
        
        assertTrue(hallHandler.getHalls().getHalls().size() == 1);
    }
    
    @Test
    public void removingHallWorks() {
        hallHandler.addNewHall("name", 4, 3);
        
        hallHandler.removeHall("name");
        assertTrue(hallHandler.getHalls().getHalls().isEmpty());
    }
    
    @Test
    public void removingMultipleHallsWorks() {
        hallHandler.addNewHall("name", 3, 2);
        hallHandler.addNewHall("name2", 3, 4);
        hallHandler.addNewHall("name3", 5, 4);
        
        hallHandler.removeHall("name");
        hallHandler.removeHall("name2");
        
        assertTrue(hallHandler.getHalls().getHalls().size() == 1);
        assertTrue(hallHandler.findHallByName("name") == null);
        assertTrue(hallHandler.findHallByName("name2") == null);
        assertEquals("name3", hallHandler.findHallByName("name3").getName());     
    }
    
    private void resetFileContent() throws IOException {
        FileWriter writer = new FileWriter(new File(filePath));
        writer.close();
    }
}
