
package seatservice.userinterface.command;

/**
 * This is a simple enum class, intended for use to determine the purpose of
 * use for a method in the InputErrorHandler class, couple of methods in the
 * InputErrorHandler class and a couple of methods in  the UILogicHandler class.
 * By using these, unnecessary similar code can be reduced as those methods do
 * largely the same things with small variations.
 * 
 * @author Tuomo Oila
 */
public enum Command {
    
    UPDATE,
    ADD,
    REMOVE,
    RESET,
    SHOW;
}
