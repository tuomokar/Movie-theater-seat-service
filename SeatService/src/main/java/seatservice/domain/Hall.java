package seatservice.domain;

import java.util.Map;
import java.util.HashMap;

/**
 * This class presents a single hall in the movie theater. Each hall has a name
 * and a certain amount of seats. The hall gets this information from another
 * class that reads a text file for the information.
 */
public class Hall {

    private String name;
    private Map<Integer, Map<Integer, Seat>> seats;

    /**
     * Creates a hashmap that represents the seats within the hall. The key of
     * the hashmap is the number of the row the seats are on. The value is
     * another map, the key of which is the number of seats at the row, with the
     * value being the seat. As such, the seats are identified through their row
     * and seat number at the row. The hall must be given at least one row and
     * each row must have at least one seat.
     * Otherwise the constructor will throw an illegalArgumentException.
     *
     * @param name The name of the hall
     * @param amountOfRows, the amount of rows in the theater
     * @param amountOfSeatsWithinRow the amount of seats within a given row
     */
    public Hall(String name, int amountOfRows, int amountOfSeatsWithinRow) {
        checkThatParametersAreCorrect(amountOfRows, amountOfSeatsWithinRow);
        this.name = name;
        this.seats = new HashMap<>();
        createSeats(amountOfRows, amountOfSeatsWithinRow);
    }
    
    private void checkThatParametersAreCorrect(int amountOfRows, int amountOfSeatsWithinRow) {
        if (amountOfRows < 1 || amountOfSeatsWithinRow < 1) {
            throw new IllegalArgumentException("a hall can't have zero or a negative amount of rows"
                    + " and rows can't have zero or a negative amount of seats ");
        }
    }

    private void createSeats(int amountOfRows, int amountOfSeatsWithinRow) {
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

    /**
     * Returns some of the hall's basic info as a string, containing the name 
     * and the amount of seats still available.
     * @return the hall's name and the amount of seats available
     */
    @Override
    public String toString() {
        return name + ", seats available: " + getTheAmountOfAvailableSeats();
    }
}
