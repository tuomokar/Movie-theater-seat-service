
package seatservice.userinterface.listeners;

import seatservice.domain.Seat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener {
         
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
