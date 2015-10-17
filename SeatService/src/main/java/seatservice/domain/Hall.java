package seatservice.domain;

import java.util.Map;
import java.util.HashMap;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * This class presents a single hall in the movie theater. Each hall has a name
 * and a certain amount of seats, which is known through the amount of rows
 * and amount of seats on the rows. 
 * 
 * @author Tuomo Oila
 */
@XmlRootElement(name = "hall")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hall {

    private String name;

    private int amountOfRows;
    private int amountOfSeatsWithinRow;
    @XmlTransient
    private Map<Integer, Map<Integer, Seat>> seats;

    /**
     * This constructor is used only when the xml file functioning as the
     * database for halls is unmarshalled into objects of this class. The
     * constructor initializes the <code>seats</code> hashmap.
     */
    public Hall() {
        this.seats = new HashMap<>();
    }

    /**
     * Creates a hashmap that represents the seats within the hall. The key of
     * the hashmap is the number of the row the seats are on. The value is
     * another map, the key of which is the number of seats on the row, with the
     * value being the seat. As such, the seats are identified through their row
     * and seat number at the row.
     *
     * @param name The name of the hall
     * @param amountOfRows, the amount of rows in the theater
     * @param amountOfSeatsWithinRow the amount of seats within a given row
     */
    public Hall(String name, int amountOfRows, int amountOfSeatsWithinRow) {
        this();
        this.name = name;   
        this.amountOfRows = amountOfRows;
        this.amountOfSeatsWithinRow = amountOfSeatsWithinRow;
        createSeats();

    }

    public int getAmountOfRows() {
        return amountOfRows;
    }
    
    /**
     * Updates the information on the rows and the seats by resetting the
     * current ones to the new ones that the method gets as parameters.
     * Then the method clears the current <code>seats</code> and recreates
     * them.
     * @param amountOfRows the new amount of rows
     * @param amountOfSeatsOnRow the new amount of seats on a row
     */
    public void updateRowsAndSeats(int amountOfRows, int amountOfSeatsOnRow) {
        this.amountOfRows = amountOfRows;
        amountOfSeatsWithinRow = amountOfSeatsOnRow;
        this.seats.clear();
        createSeats();
    }

    public int getAmountOfSeatsWithinRow() {
        return amountOfSeatsWithinRow;
    }

    public void setAmountOfRows(int amountOfRows) {
        this.amountOfRows = amountOfRows;
    }

    public void setAmountOfSeatsWithinRow(int amountOfSeatsWithinRow) {
        this.amountOfSeatsWithinRow = amountOfSeatsWithinRow;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Creates seats for this hall. Meaning, the method uses the information
     * on the amount of rows and the amount of seats on each row to put
     * in the <code>seats</code> hashmap the rows as keys and another hashmap 
     * inside of it as the value, with the amount of seats as the key and an 
     * instance of the <code>Seat</code> class as the value.
     */
    public void createSeats() {
        for (int row = 1; row <= amountOfRows; row++) {
            createASingleRow(row, amountOfSeatsWithinRow);
        }
    }

    private void createASingleRow(int row, int amountOfSeatsWithinRow) {
        seats.put(row, new HashMap<Integer, Seat>());
        for (int seatsPlace = 1; seatsPlace <= amountOfSeatsWithinRow; seatsPlace++) {
            seats.get(row).put(seatsPlace, new Seat());
        }
    }

    /**
     * Returns the total amount of seats in the hall. The method counts the
     * amount of the seats by multiplying the amount of rows by the amount of
     * seats within a row (each row has the same amount of seats)
     *
     * @return the total amount of seats in the hall
     */
    public int getTheTotalAmountOfSeats() {
        return seats.size() * seats.get(1).size();
    }

    /**
     * Returns the total amount of available seats within the hall. Counts it by
     * going through each row and seeing if each seat is available or not. If
     * the seat is available, the counter's value is incremented
     *
     * @return the amount of available seats within the hall
     */
    public int getTheAmountOfAvailableSeats() {
        int availableSeats = 0;
        int totalAmountOfSeatsWithinRow = seats.get(1).size();

        for (int row = 1; row <= seats.size(); row++) {
            for (int seatsPlace = 1; seatsPlace <= totalAmountOfSeatsWithinRow; seatsPlace++) {

                Seat seat = getSeat(row, seatsPlace);
                if (seat.isAvailable()) {
                    availableSeats++;
                }
            }
        }

        return availableSeats;
    }

    /**
     * Returns the total amount of unavailable seats within the hall. Counts it
     * by subtracting the amount of available seats from the total amount of
     * seats within the hall
     *
     * @return the amount of unavailable seats within the hall
     */
    public int getTheAmountOfUnavailableSeats() {
        return getTheTotalAmountOfSeats() - getTheAmountOfAvailableSeats();
    }

    /**
     * Returns all the seats of the hall
     *
     * @return the map containing all the seats in the hall
     */
    public Map<Integer, Map<Integer, Seat>> getSeats() {
        return seats;
    }

    /**
     * Returns all the seats within a given row
     *
     * @param row the row from which the method caller wants to get the seats
     * from
     * @return seats on a row
     */
    public Map<Integer, Seat> getSeatsOnRow(int row) {
        return seats.get(row);
    }

    /**
     * Returns the hall's basic info, i.e. name, amount of rows and the amount
     * of seats in a row
     *
     * @return a string containing the hall's name, amount of rows and the
     * amount of seats in a row
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name: ").append(name).append("\n");
        sb.append("rows: ").append(seats.size()).append("\n");
        sb.append("seats in a row: ").append(seats.get(1).size()).append("\n");
        return sb.toString();
    }

    /**
     * Returns the seat at the given coordinates
     * @param row the row the seat searched for is
     * @param seatsPlaceOnArow the place of the seat on the given row
     * @return the seat at the given row and place on the row
     */
    public Seat getSeat(int row, int seatsPlaceOnArow) {
        return seats.get(row).get(seatsPlaceOnArow);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.name.hashCode();
        hash = 37 * hash + this.seats.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hall other = (Hall) obj;
        if (this.name == null || other.getName() == null) {
            return false;
        }
        if (!this.name.equals(other.getName())) {
            return false;
        }

        return true;
    }
    
    /**
     * Makes all the seats in this hall available, i.e. goes through every
     * row and seat's place and sets each seat to available
     */
    public void resetSeatsToAvailable() {
        int totalAmountOfSeatsWithinRow = seats.get(1).size();
        
        for (int row = 1; row <= seats.size(); row++) {
            for (int seatsPlace = 1; seatsPlace <= totalAmountOfSeatsWithinRow; seatsPlace++) {

                Seat seat = getSeat(row, seatsPlace);
                seat.setToAvailable();
            }
        }
    }
}
