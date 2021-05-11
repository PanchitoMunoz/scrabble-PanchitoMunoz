package cl.uchile.dcc.scrabble.model.types;

import java.util.Objects;

/**
 * A class for the boolean type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeBool extends AbstractType {
    private final boolean value;

    /**
     * Constructor for the BoolType.
     * @param value A boolean as a value.
     */
    public TypeBool(boolean value) {
        this.value = value;
    }

    /**
     * Method that determines if the object 'o' is equals to the current instance.
     * @param o Another object that is compared to the current instance.
     * @return A boolean that determines whether the current instance are equals with 'o'.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeBool)) return false;
        TypeBool typeBool = (TypeBool) o;
        return Objects.equals(value, typeBool.value);
    }

    /**
     * Method that returns the hash code of the current instance.
     * @return The hash code of the current instance.
     */
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    /**
     * Method that provides a representation of the current instance as a String.
     * @return The representation as a String.
     */
    @Override
    public String toString() {
        return "TypeBool{"
                + "value=" + value
                + "}";
    }

    /**
     * Transforms the current type to a TypeString.
     *
     * @return TypeString with a value equivalent to the current type.
     */
    @Override
    public TypeString toTypeString() {
        return new TypeString(Boolean.toString(this.value));
    }

    /**
     * Transforms the current type to a TypeBool.
     *
     * @return TypeBool with a value equivalent to the current type.
     */
    public TypeBool toTypeBool() {
        return new TypeBool(this.value);
    }
}
