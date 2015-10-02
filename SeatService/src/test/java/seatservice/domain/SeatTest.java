package seatservice.domain;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.Color;


public class SeatTest {

    private Seat seat;

    @Before
    public void setUp() {
        seat = new Seat();
    }

    @Test
    public void checkTheButtonIsGreenColorAfterBeingCreated() {
        assertEquals(Color.green, seat.getBackground());
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
