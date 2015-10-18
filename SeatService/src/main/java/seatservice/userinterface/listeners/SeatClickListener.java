
package seatservice.userinterface.listeners;

import seatservice.domain.Seat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is responsible for listening the user's clicks in the part of the
 * UI that shows all the seats of halls visually
 * @author Tuomo Oila
 */
public class ClickListener implements ActionListener {
         
    /**
     * The method listens to any mouse clicks. If the clicked seat is
     * available, the method sets it to unavailable and vice versa.
     * @param event the event through which the clicked seat can be accessed
     */
    @Override
    public void actionPerformed(ActionEvent event) {       
        
        Seat seat = (Seat) event.getSource();
        
        if (seat.isAvailable()) {
            seat.setToUnavailable();
        } else {
            seat.setToAvailable();
        }
    }
}
