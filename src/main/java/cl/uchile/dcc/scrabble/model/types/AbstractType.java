package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.operations.add.IAddWithStr;

/**
 * An abstract class for the general types used.
 * @author Francisco Muñoz Guajardo
 */
public abstract class AbstractType implements IType, IAddWithStr {
    /**
     * Transforms the current type to a TypeString.
     * @return TypeString with a value equivalent to the current type.
     */
    abstract public TypeString toTypeString();
}
