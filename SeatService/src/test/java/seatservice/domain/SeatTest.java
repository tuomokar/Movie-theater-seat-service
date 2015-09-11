package seatservice.domain;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
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

    /**
     * Checks that the button's color is green after being created
     */
    @Test
    public void checkTheButtonIsGreenColorAfterBeingCreated() {
        assertEquals(Color.green, seat.getButton().getBackground());
    }
    
    /**
     * Checks that the seat's state of availability is set to available at
     * creation
     */
    @Test
    public void checkTheSeatIsAvailableAfterBeingCreated() {
        assertEquals(true, seat.isAvailable());
    }
    
    /**
     * Checks that setting the seat unavailable and then back to available
     * works
     */
    @Test
    public void settingToUnavailableAndBackToAvailableWorks() {
        seat.setToUnavailable();
        assertEquals(false, seat.isAvailable());
        
        seat.setToAvailable();
        assertEquals(true, seat.isAvailable());
        
        
    }
}
