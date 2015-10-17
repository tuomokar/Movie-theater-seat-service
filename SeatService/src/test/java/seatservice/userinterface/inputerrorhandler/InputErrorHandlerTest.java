package seatservice.userinterface.inputerrorhandler;

import seatservice.userinterface.command.Command;
import seatservice.userinterface.inputerrorhandler.InputErrorHandler;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import seatservice.domain.Halls;
import seatservice.filehandling.HallHandler;

public class InputErrorHandlerTest {

    private Halls halls;
    private HallHandler hallHandler;
    private InputErrorHandler inputErrorHandler;

    private JLabel hallNameErrorLabel;
    private JLabel rowsErrorLabel;
    private JLabel seatsErrorLabel;
    private JTextField hallNameTextField;
    private JTextField rowsTextField;
    private JTextField seatsTextField;
    
    @Before
    public void setUp() {
        String filePath = "src/test/testFile.xml";
        hallHandler = new HallHandler();
        hallHandler.changeFilePath(filePath);
        hallNameErrorLabel = new JLabel();
        rowsErrorLabel = new JLabel();
        seatsErrorLabel = new JLabel();
        hallNameTextField = new JTextField();
        rowsTextField = new JTextField();
        seatsTextField = new JTextField();

        inputErrorHandler = new InputErrorHandler(
                hallNameErrorLabel,
                rowsErrorLabel,
                seatsErrorLabel,
                hallNameTextField,
                rowsTextField,
                seatsTextField,
                hallHandler);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void newHallValuesAreEmptyReturnsTrueWithAllEmptyValues() {
        assertTrue(inputErrorHandler.anyNewHallValueIsEmpty(""));
    }

    @Test
    public void newHallValuesAreEmptyReturnsTrueWithNameBeingNotEmpty() {
        assertTrue(inputErrorHandler.anyNewHallValueIsEmpty("test"));
    }

    @Test
    public void newHallValuesAreEmptyReturnsTrueWithNameAndRowsBeingNotEmpty() {
        rowsTextField.setText("test");
        assertTrue(inputErrorHandler.anyNewHallValueIsEmpty("test"));
    }

    @Test
    public void newHallValuesAreEmptyReturnsFalseWithNameAndRowsAndSeatsBeingNotEmpty() {
        rowsTextField.setText("test");
        seatsTextField.setText("test");
        assertFalse(inputErrorHandler.anyNewHallValueIsEmpty("test"));
    }

    @Test
    public void newHallValuesAreEmptyReturnsTrueWithRowsBeingNotEmpty() {
        rowsTextField.setText("test");
        assertTrue(inputErrorHandler.anyNewHallValueIsEmpty(""));
    }

    @Test
    public void newHallValuesAreEmptyReturnsTrueWithSeatsBeingNotEmpty() {
        seatsTextField.setText("test");
        assertTrue(inputErrorHandler.anyNewHallValueIsEmpty(""));
    }

    @Test
    public void newHallValuesAreEmptyReturnsTrueWithRowsAndSeatsBeingNotEmpty() {
        rowsTextField.setText("test");
        seatsTextField.setText("test");
        assertTrue(inputErrorHandler.anyNewHallValueIsEmpty(""));
    }

    @Test
    public void newHallValuesAreEmptyReturnsTrueWithNameAndSeatsBeingNotEmpty() {
        seatsTextField.setText("test");
        assertTrue(inputErrorHandler.anyNewHallValueIsEmpty("test"));
    }

    @Test
    public void newHallValuesAreEmptyReturnsFalseWithNameBeingEmptyAndRowsAndSeatsBeingNotEmpty() {
        rowsTextField.setText("test");
        seatsTextField.setText("test");
        assertTrue(inputErrorHandler.anyNewHallValueIsEmpty(""));
    }

    @Test
    public void rowsAndSeatsIntegersAndAboveZeroReturnsFalseWithEmptyValues() {
        assertFalse(inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero());
    }

    @Test
    public void rowsBeingZeroIsInvalidInput() {
        rowsTextField.setText("0");
        seatsTextField.setText("10");
        assertFalse(inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero());
    }
    
    @Test
    public void seatsBeingZeroIsInvalidInput() {
        rowsTextField.setText("10");
        seatsTextField.setText("0");
        assertFalse(inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero());
    }
    
    @Test
    public void rowsAndSeatsBeingZeroIsInvalidInput() {
        rowsTextField.setText("0");
        seatsTextField.setText("0");
        assertFalse(inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero());
    }
    
    @Test
    public void rowsAndSeatsBeingAboveZeroIsvalidInput() {
        rowsTextField.setText("1");
        seatsTextField.setText("1");
        assertTrue(inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero());
    }
    
    @Test
    public void rowsAndSeatsBeingNegativeIsInvalidInput() {
        rowsTextField.setText("-10");
        seatsTextField.setText("-15");
        assertFalse(inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero());
    }
    
    @Test
    public void rowsBeingNegativeIsInvalidInput() {
        rowsTextField.setText("-10");
        seatsTextField.setText("10");
        assertFalse(inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero());
    }
    
    @Test
    public void seatsBeingNegativeIsInvalidInput() {
        rowsTextField.setText("10");
        seatsTextField.setText("-10");
        assertFalse(inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero());
    }
    
    @Test
    public void seatsNotBeingIntegerIsInvalidInput() {
        rowsTextField.setText("10");
        seatsTextField.setText("rr");
        assertFalse(inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero());
    }
    
    @Test
    public void seatsAndRowsNotBeingIntegerIsInvalidInput() {
        rowsTextField.setText("6rr");
        seatsTextField.setText("rr");
        assertFalse(inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero());
    }
    
    @Test
    public void rowsNotBeingIntegerIsInvalidInput() {
        rowsTextField.setText("4rr");
        seatsTextField.setText("10");
        assertFalse(inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero());
    }
    
    @Test
    public void rowsNotBeingIntegerIsAndSeatsBeingNegativeInvalidInput() {
        rowsTextField.setText("15rr");
        seatsTextField.setText("-10");
        assertFalse(inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero());
    }
    
    @Test
    public void seatsNotBeingIntegerIsAndrowsBeingNegativeInvalidInput() {
        rowsTextField.setText("-11");
        seatsTextField.setText("11rr");
        assertFalse(inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero());
    }
    
    @Test
    public void seatsNotBeingIntegerSetsTheProperErrorMessage() {
        seatsTextField.setText("11rr");
        inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero();
        assertEquals("Integer value should be given!", seatsErrorLabel.getText());
    }
    
    @Test
    public void rowsNotBeingIntegerSetsTheProperErrorMessage() {
        rowsTextField.setText("020193rsjs");
        inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero();
        assertEquals("Integer value should be given!", rowsErrorLabel.getText());
    }
    
    @Test
    public void rowsBeingIntegerDoesntSetErrorMessage() {
        rowsTextField.setText("020193");
        inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero();
        assertTrue(rowsErrorLabel.getText().isEmpty());
    }
    
    @Test
    public void seatsBeingIntegerDoesntSetErrorMessage() {
        seatsTextField.setText("5555");
        inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero();
        assertTrue(seatsErrorLabel.getText().isEmpty());
    }
    
    @Test
    public void seatsBeingNegativeSetsTheProperErrorMessage() {
        seatsTextField.setText("-1");
        inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero();
        assertEquals("The hall must have at least one seat!", seatsErrorLabel.getText());
    }
    
    @Test
    public void rowsBeingNegativeSetsTheProperErrorMessage() {
        rowsTextField.setText("-1");
        inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero();
        assertEquals("The hall must have at least one row!", rowsErrorLabel.getText());
    }
    
    @Test
    public void rowsBeingZeroSetsTheProperErrorMessage() {
        rowsTextField.setText("0");
        inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero();
        assertEquals("The hall must have at least one row!", rowsErrorLabel.getText());
    }
    
    @Test
    public void seatsBeingZeroSetsTheProperErrorMessage() {
        seatsTextField.setText("0");
        inputErrorHandler.rowsAndSeatsAreIntegersAndAboveZero();
        assertEquals("The hall must have at least one seat!", seatsErrorLabel.getText());
    }
    
    @Test
    public void emptyRowsSetsTheProperErrorMessage() {
        inputErrorHandler.anyNewHallValueIsEmpty("");
        assertEquals("Rows must have a value!", rowsErrorLabel.getText());
    }
    
    @Test
    public void emptySeatsSetsTheProperErrorMessage() {
        inputErrorHandler.anyNewHallValueIsEmpty("");
        assertEquals("Seats must have a value!", seatsErrorLabel.getText());
    }
    
    @Test
    public void emptyNameSetsTheProperErrorMessage() {
        inputErrorHandler.anyNewHallValueIsEmpty("");
        assertEquals("Name must not be empty!", hallNameErrorLabel.getText());
    }
    
    @Test
    public void emptyNameDoesntSetErrorMessagesForOthers() {
        rowsTextField.setText("1");
        seatsTextField.setText("1");
        inputErrorHandler.anyNewHallValueIsEmpty("");
        assertNotEquals("Name must not be empty!", rowsErrorLabel.getText());
        assertNotEquals("Name must not be empty!", seatsErrorLabel.getText());
    }
    
    @Test
    public void hallIsFoundToBeExistingWhenTryingtoAddAlreadyExistingHall() {
        hallHandler.addNewHall("name", 4, 2);
        assertTrue(inputErrorHandler.hallExistsAlready("name", Command.ADD));
    }
    
    @Test
    public void hallIsNotFoundToExistWhenTryingToAddNotYetExistingHall() {
        assertFalse(inputErrorHandler.hallExistsAlready("testname", Command.ADD));
    }
    
    @Test
    public void tryingToAddAlreadyExistingHallSetsTheProperErrorMessage() {
        hallHandler.addNewHall("name", 4, 2);
        inputErrorHandler.hallExistsAlready("name", Command.ADD);
        assertEquals("Hall with that name already exists!", hallNameErrorLabel.getText());
    }
    
    @Test
    public void tryingToUpdateNonExistingHallReturnsFalse() {
        assertFalse(inputErrorHandler.hallExistsAlready("name", Command.UPDATE));
    }
    
    @Test
    public void updatingNonExistingHallSetsTheProperErrorMessage() {
        inputErrorHandler.hallExistsAlready("name", Command.UPDATE);
        assertEquals("No hall exists with that name!", hallNameErrorLabel.getText());
    }
    
    @Test
    public void hallIsFoundToBeExistingWhenTryingToUpdateIt() {
        hallHandler.addNewHall("name", 4, 2);
        assertTrue(inputErrorHandler.hallExistsAlready("name", Command.UPDATE));
    }
    
    @Test
    public void updatingExistingHallSetsNoErrorMessage() {
        hallHandler.addNewHall("name", 4, 2);
        inputErrorHandler.hallExistsAlready("name", Command.UPDATE);
        assertTrue(hallNameErrorLabel.getText().isEmpty());
    }
    
    @Test
    public void addingNonExistinHallSetsNoErrorMessage() {
        inputErrorHandler.hallExistsAlready("name", Command.ADD);
        assertTrue(hallNameErrorLabel.getText().isEmpty());
    }
    
    @Test
    public void updatingExistingHallReturnsTrue() {
        hallHandler.addNewHall("name", 4, 2);
        inputErrorHandler.hallExistsAlready("name", Command.UPDATE);
        assertTrue(inputErrorHandler.hallExistsAlready("name", Command.UPDATE));
    }
      
}
