package cl.uchile.dcc.scrabble.model.operations.subtraction;

import cl.uchile.dcc.scrabble.model.types.IType;
import cl.uchile.dcc.scrabble.model.types.TypeInt;

/**
 * Interface for the subtraction operation. It is in case an Int is subtracted with any type.
 * Currently this interface is for the other types.
 * @author Francisco Muñoz Guajardo
 */
public interface ISubWithInt {
    /**
     * Returns the subtraction between the current type and an Int Type.
     * @param typeInt An Int type who will be subtracted to the current type.
     * @return The subtraction between the Int type and the other type.
     */
    IType subWithInt(TypeInt typeInt);
}