package seatservice.domain;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Map;
import static org.hamcrest.CoreMatchers.instanceOf;

public class HallTest {

    private Hall hall;
    private int amountOfRows;
    private int amountOfSeatsWithinRow;
    private int totalAmountOfSeats;

    public HallTest() {
    }

    @Before
    public void setUp() {
        this.amountOfRows = 2;
        this.amountOfSeatsWithinRow = 3;
        this.totalAmountOfSeats = amountOfRows * amountOfSeatsWithinRow;
        hall = new Hall("name", amountOfRows, amountOfSeatsWithinRow);
    }


    @Test
    public void seatsAreActuallyInAMap() {
        assertThat(hall.getSeats(), instanceOf(Map.class));
    }
    

    @Test
    public void hasTheCorrectAmountOfSeats() {        
        assertEquals(totalAmountOfSeats, hall.getTheTotalAmountOfSeats());
    }

    @Test
    public void hasTheCorrectAmountOfAvailableSeatsAtStart() {
        assertEquals(totalAmountOfSeats, hall.getTheAmountOfAvailableSeats());
    }
    
    @Test
    public void hasTheCorrectAmountOfAvailableSeatsAfterSettingSomeUnAvailable() {
        Seat seat1 = hall.getSeatsWithinARow(1).get(1);
        Seat seat2 = hall.getSeatsWithinARow(2).get(1);
        
        seat1.setToUnavailable();
        seat2.setToUnavailable();
        
        assertEquals(totalAmountOfSeats - 2, hall.getTheAmountOfAvailableSeats());
        assertEquals(2, hall.getTheAmountOfUnavailableSeats());
    }
    
    @Test
    public void rowsHaveCorrectAmountOfSeats() {
        assertEquals(3, hall.getSeatsWithinARow(1).size());
        assertEquals(3, hall.getSeatsWithinARow(2).size());
    }
    
    @Test
    public void toStringWorksCorrectly() {
        String toStringShouldBe = "name: name\nrows: " + amountOfRows +
                "\nseats in a row: " + amountOfSeatsWithinRow + "\n";
        assertEquals(toStringShouldBe, hall.toString());
    }
    
    @Test
    public void resetingSeatsWorks() {
        assertEquals(totalAmountOfSeats, hall.getTheAmountOfAvailableSeats());
        
        hall.getSeatsWithinARow(1).get(1).setToUnavailable();
        hall.getSeatsWithinARow(1).get(2).setToUnavailable();
        assertEquals(totalAmountOfSeats - 2, hall.getTheAmountOfAvailableSeats());
        
        hall.resetSeatsToAvailable();
        assertEquals(totalAmountOfSeats, hall.getTheAmountOfAvailableSeats());
    }
}
