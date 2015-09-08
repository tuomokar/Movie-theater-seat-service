
package seatservice.domain;

import javax.swing.JButton;
import java.awt.Color;

/**
* This class represents a single seat within a hall of the movie theater
* The seat is represented as a button, which changes its color depending on its
* state of availability
*/
public class Seat {
    
    private JButton button;
    
    /**
     * Creates the button representing the seat, and sets its default state to
     * available
     */
    public Seat() {
        button = new JButton();
        setToAvailable();
    }   
    
    /**
     * Sets the seat's availability to unavailable, which is represented in the
     * color red
     */
    public void setToUnavailable() {
        button.setBackground(Color.red);
    }
    
    /**
     * Sets the seat available, which is represented in the color green.
     */
    public void setToAvailable() {
        button.setBackground(Color.green);
    }
    
    /**
     * Returns the button representing the seat
     * @return JButton
     */
    public JButton getButton() {
        return button;
    }
    
    /**
     * Returns whether or not the seat is available. If the color is green,
     * then the seat is available.
     * @return the state of availability of the seat
     */
    public boolean isAvailable() {
        return button.getBackground().equals(Color.green);
    }
}
