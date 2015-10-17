
package seatservice.userinterface;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * A listener for the <code>Jlist</code><code>hallNames</code> variable in the 
 * GUI. The listener watches if the user selects any object in the 
 * <code>Jlist</code> and always sets the selected value to the instance
 * variable <code>selectedName</code>
 */
public class HallNamesListener implements ListSelectionListener {


    private String selectedName;
  
    @Override
    public void valueChanged(ListSelectionEvent evt) {
        if (!evt.getValueIsAdjusting()) {
            JList hallNames = (JList) evt.getSource();
            if (hallNames.getSelectedValue() == null) {
                return;
            }
            selectedName = hallNames.getSelectedValue().toString();
        }
    }
    
    public String getSelectedName() {
        return selectedName;
    }
    
    public void resetSelection() {
        selectedName = null;
    }
}
