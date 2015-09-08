package seatservice.domain;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import seatservice.domain.Seat;
import javax.swing.JButton;
import java.awt.Color;

/**
 * Tests the Seat class
 */
public class SeatTest {

    private Seat seat;

    public SeatTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        seat = new Seat();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void checkTheButtonIsGreenColorAfterBeingCreated() {
        assertEquals(Color.green, seat.getButton().getBackground());
    }
    
    @Test
    public void checkTheSeatIsAvailableAfterBeingCreated() {
        assertEquals(true, seat.isAvailable());
    }
    
    @Test
    public void settingToUnavailableAndBackToAvailableWorks() {
        seat.setToUnavailable();
        assertEquals(false, seat.isAvailable());
        
        seat.setToAvailable();
        assertEquals(true, seat.isAvailable());
        
        
    }
}
