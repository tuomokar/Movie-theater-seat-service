
package seatservice.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class encapsulates the halls as a list.
 */

@XmlRootElement(name = "halls")
@XmlAccessorType(XmlAccessType.FIELD)
public class Halls {
    
    @XmlElement(name = "hall")
    private List<Hall> halls;

    public Halls() {
        this.halls = new ArrayList<>();
    }
    
    public List<Hall> getHalls() {
//        if (halls == null) {
//            halls = new ArrayList<>();
//        }
        return halls;
    }

    public void setHalls(List<Hall> halls) {
        this.halls = halls;
    }
    
    /**
     * Adds a hall to the database
     * @param hall 
     */
    public void addHall(Hall hall) {
        if (halls.contains(hall)) {
            return;
        }
        halls.add(hall);
    }
    
    
    /**
     * Creates the seats for all the halls in case there's need for it
     */
    public void createSeatsForHalls() {
        for (Hall hall : halls) {
            hall.createSeats();
        }
    }
    
    /**
     * Checks if the list of the halls contains the hall given as the parameter
     * @param hall
     * @return Returns true if the list of the halls contains the hall given
     * as the parameter
     */
    public boolean contains(Hall hall) {
        return halls.contains(hall);
    }
    
    /**
     * Searches for a hall that would have the name that is the search parameter
     * In case a matching hall is found, that hall is returned. If no matching
     * hall is found, the method returns null.
     * @param name
     * @return Returns true if a hall is found with the given name
     */
    public Hall findByName(String name) {
        if (name == null) {
            return null;
        }
        
        for (Hall hall : halls) {
            if (hall.getName().equals(name)) {
                return hall;
            }
        }
        return null;
    }
}