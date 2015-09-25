
package seatservice.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import seatservice.domain.Hall;

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
        return halls;
    }

    public void setHalls(List<Hall> halls) {
        this.halls = halls;
    }
    
    public void addHall(Hall hall) {
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
     * @return 
     */
    public boolean contains(Hall hall) {
        return halls.contains(hall);
    }
 
}