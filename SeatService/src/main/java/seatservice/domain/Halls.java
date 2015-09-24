
package seatservice.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import seatservice.domain.Hall;

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
    
    public void createSeatsForHalls() {
        for (Hall hall : halls) {
            hall.createSeats();
        }
    }
    
    public boolean contains(Hall hall) {
        return halls.contains(hall);
    }
 
}