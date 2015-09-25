package seatservice.domain;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import seatservice.domain.Hall;
import seatservice.domain.Seat;
import java.util.Map;
import java.util.HashMap;
import static org.hamcrest.CoreMatchers.instanceOf;

/*
 Tests the Hall class
 */
public class HallTest {

    private Hall hall;
    private int amountOfRows;
    private int amountOfSeatsWithinRow;
    private int totalAmountOfSeats;

    public HallTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.amountOfRows = 2;
        this.amountOfSeatsWithinRow = 3;
        this.totalAmountOfSeats = amountOfRows * amountOfSeatsWithinRow;
        hall = new Hall("name", amountOfRows, amountOfSeatsWithinRow);
    }

    @After
    public void tearDown() {
    }



    @Test
    public void seatsAreActuallyInAMap() {
        assertThat(hall.getSeats(), instanceOf(Map.class));
    }
    

    @Test
    public void hasTheCorrectAmountOfSeats() {        
        assertEquals(totalAmountOfSeats, hall.getTheTotalAmountOfSeats());
    }
    
    /**
     * The method checks that each seat is set to available after the hall is 
     * created
     */
    @Test
    public void hasTheCorrectAmountOfAvailableSeatsAtStart() {
        assertEquals(totalAmountOfSeats, hall.getTheAmountOfAvailableSeats());
    }
    
    /**
     * The method sets two seats to unavailable state and sees if the amount of
     * available seats and unavailable seats is still correct.
     */
    @Test
    public void hasTheCorrectAmountOfAvailableSeatsAfterSettingSomeUnAvailable() {
        Seat seat1 = hall.getSeatsWithinARow(1).get(1);
        Seat seat2 = hall.getSeatsWithinARow(2).get(1);
        
        seat1.setToUnavailable();
        seat2.setToUnavailable();
        
        assertEquals(totalAmountOfSeats - 2, hall.getTheAmountOfAvailableSeats());
        assertEquals(2, hall.getTheAmountOfUnavailableSeats());
    }
    
    /**
     * The method checks that each row has the correct amount of seats
     */
    @Test
    public void rowsHaveCorrectAmountOfSeats() {
        assertEquals(3, hall.getSeatsWithinARow(1).size());
        assertEquals(3, hall.getSeatsWithinARow(2).size());
    }
    
    /**
     * Checks that the toString method works correctly
     */
    @Test
    public void toStringWorksCorrectly() {
        String toStringShouldBe = "name: name\nrows: " + amountOfRows +
                "\nseats in a row: " + amountOfSeatsWithinRow + "\n";
        assertEquals(toStringShouldBe, hall.toString());
    }
}
