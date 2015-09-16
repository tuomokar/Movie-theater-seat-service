package seatservice.filehandling;

import seatservice.domain.Hall;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class is responsible for reading and parsing through the database file
 * containing the information on the halls of the movie theater and creates hall
 * objects out of the information
 */
public class HallParser {

    private String filePath;
    private List<Hall> halls;

    /**
     * The constructor sets the default filepath for the text file functioning
     * as the database for the halls and initializes the halls instance variable
     * that will contain any halls parsed while reading through the file.
     *
     * @param filePath
     */
    public HallParser(String filePath) {
        this.filePath = filePath;
        this.halls = new ArrayList<>();      
    }

    /**
     * This method reads the file in the given path and parses it in order
     * to create hall objects from the information within the file.
     * The method goes through each line and at each line, it first checks
     * if the line is one that is between the informations of each hall. If it
     * is, then the reader moves on the next line, but if it is not, the line
     * is split, with the second index (index 1) being the one with the raw
     * info on the hall (name, amount of rows or amount of seats in a row).
     * Then this info is put on the "hallInformation" array, which has room
     * for three elements (name, rows and amount of seats within a row).
     * If the line is the last of the information required to create a hall,
     * a new hall is created and the "hallInformation" array is reseted for use
     * in another one.
     * 
     * @return true if the file reading and parsing succeeded
     */
    public boolean readFile() {
        String[] hallInformation = new String[3];
        int i = 0;
        try {
            Scanner reader = new Scanner(new File(filePath));

            while (reader.hasNext()) {
                String line = reader.nextLine();
                if (lineMarksSpaceBetweenHalls(line)) {
                    continue;
                }

                String[] lineSplit = line.split(": ");
                hallInformation[i] = separateTheRawInfo(lineSplit);
                i++;

                if (lineIsTheLastNeededForAHall(line)) {
                    i = 0;
                    
                    Hall hall = createNewHall(hallInformation);
                    if (hallIsNotYetOnTheList(hall)) {
                        halls.add(hall);
                    }
                    hallInformation = resetHallInformation();
                }

            }
        } catch (FileNotFoundException ex) {
            return false;
        }
        
        return true;
    }
 

    /**
     * Returns the halls that were parsed when the file was read.
     * 
     * @return the halls as a list
     */
    public List<Hall> getHalls() {
        return halls;
    }
    
    /**
     * Returns the file path
     * 
     * @return the file path
     */
    public String getFilePath() {
        return filePath;
    }
    
    /**
     * Changes the current file path to the new path given as the parameter
     * 
     * @param newPath 
     */
    public void changeFilePath(String newPath) {
        filePath = newPath;
    }
    
    public Hall getHall(String name) {
        for (Hall hall : halls) {
            if (hall.getName().equals(name)) {
                return hall;
            }
        }
        return null;
    }

    private boolean lineIsTheLastNeededForAHall(String line) {
        return line.contains("seats in a row");
    }

    private boolean lineMarksSpaceBetweenHalls(String line) {
        return line.contains(";");
    }

    private Hall createNewHall(String[] hallInformation) {
        String hallName = hallInformation[0];
        int rows = Integer.parseInt(hallInformation[1]);
        int seatsInARow = Integer.parseInt(hallInformation[2]);

        Hall hall = new Hall(hallName, rows, seatsInARow);
        return hall;
    }
    
    private String[] resetHallInformation() {
        return new String[3];
    }
    
    private boolean hallIsNotYetOnTheList(Hall hall) {
        return !halls.contains(hall);
    }
    
    private String separateTheRawInfo(String[] lineSplit) {
        return lineSplit[1];
    }
     
}
