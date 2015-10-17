
package seatservice.filehandling;

import seatservice.domain.Hall;
import seatservice.domain.Halls;

/**
 * This class is responsible for removing any wanted halls from the
 * xml database file
 * 
 * @author Tuomo Oila
 */
public class HallRemover {
    
    private HallAdder hallAdder;
    private Halls halls;

    public HallRemover(HallAdder hallAdder, Halls halls) {  
        this.hallAdder = hallAdder;
        this.halls = halls;
    }

    /**
     * Removes a single hall from the database. In practice, the method
     * simply removes the wanted hall from the list of the halls and rewrites
     * all the remaining halls to the file. The method returns true if
     * the writing of the remaining halls was successful
     * 
     * @param hall the hall that is to be removed
     * @return true if the removal action was successful, otherwise false
     */
    public boolean removeHall(Hall hall) {
        removeHallFromList(hall);
        boolean success = writeRemainingHalls();
        return success;
    }
    
    private boolean writeRemainingHalls() {
        boolean success = hallAdder.writeAllTheHallsToTheFile();
        return success;
    }
    
    private void removeHallFromList(Hall hall) {
        halls.getHalls().remove(hall);
    }
    
}
