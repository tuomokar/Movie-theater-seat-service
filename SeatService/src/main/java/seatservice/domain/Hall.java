package seatservice.domain;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * This class presents a single hall in the movie theater. Each hall has a name
 * and a certain amount of seats. The hall gets this information from another
 * class that reads a text file for the information.
 */
@XmlRootElement(name = "hall")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hall {

    private String name;

    private int amountOfRows;
    private int amountOfSeatsWithinRow;
    @XmlTransient
    private Map<Integer, Map<Integer, Seat>> seats;

    public Hall() {
        this.seats = new HashMap<>();
    }

    /**
     * Creates a hashmap that represents the seats within the hall. The key of
     * the hashmap is the number of the row the seats are on. The value is
     * another map, the key of which is the number of seats at the row, with the
     * value being the seat. As such, the seats are identified through their row
     * and seat number at the row. The hall must be given at least one row and
     * each row must have at least one seat. Otherwise the constructor will
     * throw an illegalArgumentException.
     *
     * @param name The name of the hall
     * @param amountOfRows, the amount of rows in the theater
     * @param amountOfSeatsWithinRow the amount of seats within a given row
     */
    public Hall(String name, int amountOfRows, int amountOfSeatsWithinRow) {
        this();
        checkThatParametersAreCorrect(amountOfRows, amountOfSeatsWithinRow);
        this.name = name;   
        this.amountOfRows = amountOfRows;
        this.amountOfSeatsWithinRow = amountOfSeatsWithinRow;
        createSeats();

    }

    public int getAmountOfRows() {
        return amountOfRows;
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
    
    

    private void checkThatParametersAreCorrect(int amountOfRows, int amountOfSeatsWithinRow) {
        if (amountOfRows < 1 || amountOfSeatsWithinRow < 1) {
            throw new IllegalArgumentException("a hall can't have zero or a negative amount of rows"
                    + " and rows can't have zero or a negative amount of seats ");
        }
    }

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

                Seat seat = seats.get(row).get(seatsPlace);
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
     * @return seats
     */
    public Map<Integer, Map<Integer, Seat>> getSeats() {
        return seats;
    }

    /**
     * Returns all the seats within a given row
     *
     * @param row
     * @return seats within a row
     */
    public Map<Integer, Seat> getSeatsWithinARow(int row) {
        return seats.get(row);
    }

    public String getName() {
        return name;
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
     * Returns the hashcode for the object
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.seats);
        return hash;
    }

    /**
     * Compares this hall to another hall to see if they're the same The primary
     * check for it is to see if the string returned by their toString() methods
     * are the same.
     *
     * @param obj
     * @return true if this object is the same as the one as the one given as
     * the parameter
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hall other = (Hall) obj;
        if (!this.toString().equals(other.toString())) {
            return false;
        }

        return true;
    }
}
