
package seatservice.domain;

import javax.swing.JButton;
import java.awt.Color;

/**
* This class represents a single seat within a hall of the movie theater
* The seat is represented as a button, which changes its color depending on its
* state of availability
* 
* @author Tuomo Oila
*/
public class Seat extends JButton {
      
    /**
     * The constructor sets the default state of this seat to available and any
     * text it contains to non focusable
     */
    public Seat() {
        setToAvailable();
        setToNonFocusable();
    }   
    
    /**
     * Sets the seat's availability to unavailable, which is represented in the
     * color red
     */
    public void setToUnavailable() {
        setBackground(Color.red);
    }
    
    /**
     * Sets the seat available, which is represented in the color green.
     */
    public void setToAvailable() {
        setBackground(Color.green);
    }
    
    /**
     * Returns whether or not the seat is available. If the color is green,
     * then the seat is available.
     * @return the state of availability of the seat
     */
    public boolean isAvailable() {
        return getBackground().equals(Color.green);
    }
    
    private void setToNonFocusable() {
        this.setFocusable(false);
    }
}
