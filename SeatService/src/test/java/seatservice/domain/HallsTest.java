
package seatservice.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.UUID;
import static org.hamcrest.CoreMatchers.instanceOf;

public class HallsTest {
    
    private Halls halls;   
    
    @Before
    public void setUp() {
        this.halls = new Halls();
    }
    

    @Test
    public void hallIsEmptyAtStart() {
        assertTrue(halls.getHalls().isEmpty());
    }
    
    @Test
    public void addingAHallWorks() {
        halls.addHall(new Hall());
        assertTrue(halls.getHalls().size() == 1);
    }
    
    @Test
    public void methodContainsWorksWithHallsBeingEmpty() {
        assertFalse(halls.contains(new Hall()));
    }
    
    @Test
    public void containsWorksWithSomeHallsExisting() {
        halls.addHall(new Hall("name1", 1, 2));
        halls.addHall(new Hall("name2", 1, 2));
        
        assertTrue(halls.contains(new Hall("name1", 1, 2)));
        assertTrue(halls.contains(new Hall("name2", 1, 2)));
    }
    
    @Test
    public void containsReturnsFalseIfNoHallIsFound() {
        assertFalse((halls.contains(null)));
        assertFalse(halls.contains(new Hall(getRandomName(), 1, 3)));
    }
    
    @Test
    public void findingByNameWorks() {
        String name = getRandomName();
        Hall hall = new Hall(name, 1, 2);
        halls.addHall(hall);
        assertEquals(hall, halls.findByName(name));
    }
    
    @Test
    public void findingByNameWorksWithMultipleHallsInMemory() {
        Hall hall1 = new Hall("name1", 1, 2);
        Hall hall2 = new Hall("name2", 3, 2);
        Hall hall3 = new Hall("name3", 4, 6);
        halls.addHall(hall1);
        halls.addHall(hall2);
        halls.addHall(hall3);
        
        assertEquals(hall1, halls.findByName("name1"));
        assertEquals(hall2, halls.findByName("name2"));
        assertEquals(hall3, halls.findByName("name3"));
    }
    
    @Test
    public void findingByNameDoesntReturnAnyRandomHall() {
        Hall hall1 = new Hall("name1", 1, 2);
        Hall hall2 = new Hall("name2", 3, 2);
        Hall hall3 = new Hall("name3", 4, 3);
        halls.addHall(hall1);
        halls.addHall(hall2);
        halls.addHall(hall3);
        
        assertNotEquals(hall1, halls.findByName("name3"));
        assertNotEquals(hall2, halls.findByName("name1"));
        assertNotEquals(hall2, halls.findByName(getRandomName()));
    }
    
    @Test
    public void findingByNameReturnsNullIfNoHallsExist() {
        assertEquals(null, halls.findByName(getRandomName()));
    }
    
    @Test
    public void findingByNameReturnsNullIfHallDoesntExistEvenIfThereAreOtherHalls() {
        Hall hall1 = new Hall("name1", 1, 2);
        Hall hall2 = new Hall("name2", 3, 2);
        Hall hall3 = new Hall("name3", 4, 3);
        halls.addHall(hall1);
        halls.addHall(hall2);
        halls.addHall(hall3);
        
        assertEquals(null, halls.findByName(getRandomName()));
        assertEquals(null, halls.findByName(getRandomName()));
        assertEquals(null, halls.findByName(getRandomName()));
    }
    
    @Test
    public void tryingToFindWithNullValueReturnsNull() {
        assertNull(halls.findByName(null));
    }
    
    @Test
    public void creatingSeatsWorks() {
        Hall hall1 = new Hall();
        
        hall1.setAmountOfRows(3);
        hall1.setAmountOfSeatsWithinRow(2);
        
        Hall hall2 = new Hall();
        hall2.setAmountOfRows(4);
        hall2.setAmountOfSeatsWithinRow(3);
        halls.addHall(hall1);
        halls.addHall(hall2);
        
        halls.createSeatsForHalls();
        
        assertTrue(hall1.getSeats() != null);
        assertTrue(hall1.getSeats().size() == 3);
        assertTrue(hall1.getSeatsWithinARow(1) != null);
        assertTrue(hall1.getSeatsWithinARow(1).size() == 2);
        assertThat(hall1.getSeatsWithinARow(1).get(1), instanceOf(Seat.class));
        
        assertTrue(hall2.getSeats() != null);
        assertTrue(hall2.getSeats().size() == 4);
        assertTrue(hall2.getSeatsWithinARow(1) != null);
        assertTrue(hall2.getSeatsWithinARow(1).size() == 3);
        assertThat(hall2.getSeatsWithinARow(1).get(1), instanceOf(Seat.class));
    }   
    
    private String getRandomName() {
        return "-- " + UUID.randomUUID().toString().substring(1, 10);
    }
}