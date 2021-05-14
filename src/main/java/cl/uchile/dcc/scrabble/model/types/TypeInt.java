package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.operations.add.IAddWithInt;
import cl.uchile.dcc.scrabble.model.operations.multiplication.IMultWithInt;
import cl.uchile.dcc.scrabble.model.operations.subtraction.ISubWithInt;

import java.util.Objects;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.addTwoBinaries;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.intToBinary;

/**
 * A class for the integer type.
 * @author Francisco Muñoz Guajardo
 */
public class TypeInt extends AbstractInteger {
    private final int value;

    /**
     * Constructor for the TypeInt.
     * @param value An int as a value.
     */
    public TypeInt(int value) {
        this.value = value;
    }

    protected int getValue() {
        return this.value;
    }

    /**
     * Method that determines if the object 'o' is equals to the current instance.
     * @param o Another object that is compared to the current instance.
     * @return A boolean that determines whether the current instance are equals with 'o'.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeInt)) return false;
        TypeInt typeInt = (TypeInt) o;
        return value == typeInt.value;
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
        return "TypeInt{" +
                "value=" + value +
                '}';
    }

    /**
     * Transforms the current type to a TypeString.
     *
     * @return TypeString with a value equivalent to the current type.
     */
    @Override
    public TypeString toTypeString() {
        return new TypeString(Integer.toString(this.value));
    }

    /**
     * Transforms the current type to a TypeFloat.
     *
     * @return TypeFloat with a value equivalent to the current type.
     */
    @Override
    public TypeFloat toTypeFloat() {
        return new TypeFloat(this.value);
    }

    /**
     * Transforms the current type to a TypeInt.
     *
     * @return TypeInt with a value equivalent to the current type.
     */
    @Override
    public TypeInt toTypeInt() {
        return new TypeInt(this.value);
    }

    /**
     * Transforms the current type to a TypeBinary.
     *
     * @return TypeBinary with a value equivalent to the current type.
     */
    @Override
    public TypeBinary toTypeBinary() {
        return new TypeBinary(intToBinary(this.value));
    }

    /**
     * Returns the negative of the current instance.
     *
     * @return The opposite of the current instance.
     */
    @Override
    public SType opposite() {
        return new TypeInt(-this.value);
    }

    /**
     * Method that returns the sum between a TypeInt and another type.
     * Returns the dominant type if possible, or throws an error if the operation is undefined.
     * @param otherType Another type that will be added to the current type.
     * @return The sum between the two types, returning the dominant type.
     */
    public SNumber add(IAddWithInt otherType) {
        return otherType.addWithInt(this);
    }

    /**
     * Returns the add between the current type and a String Type.
     *
     * @param typeString A string type who will be added to the current type.
     * @return The sum between the String type and the other type.
     */
    @Override
    public TypeString addWithString(TypeString typeString) {
        return new TypeString(typeString.getValue() + this.value);
    }

    /**
     * Returns the add between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be added to the current type.
     * @return The sum between the Int type and the other type.
     */
    @Override
    public SNumber addWithInt(TypeInt typeInt) {
        return new TypeInt(typeInt.value + this.value);
    }

    /**
     * Returns the add between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be added to the current type.
     * @return The sum between the Float type and the other type.
     */
    @Override
    public SNumber addWithFloat(TypeFloat typeFloat) {
        return new TypeFloat(typeFloat.getValue() + this.value);
    }

    /**
     * Returns the sum between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be added to the current type.
     * @return The sum between the Binary type and the other type.
     */
    @Override
    public SNumber addWithBinary(TypeBinary typeBinary) {
        return new TypeBinary(addTwoBinaries(typeBinary.getValue(), intToBinary(this.value)));
    }

    /**
     * Method that returns the subtraction between a TypeInt and another type.
     * Returns the dominant type if possible, or throws an error if the operation is undefined.
     * @param otherType Another type that will be added to the current type.
     * @return The subtraction between the two types, returning the dominant type.
     */
    public SNumber sub(ISubWithInt otherType) {
        return otherType.subWithInt(this);
    }

    /**
     * Returns the subtraction between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be subtracted to the current type.
     * @return The subtraction between the Float type and the other type.
     */
    @Override
    public SNumber subWithFloat(TypeFloat typeFloat) {
        return new TypeFloat(typeFloat.getValue() - this.value);
    }

    /**
     * Returns the subtraction between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be subtracted to the current type.
     * @return The subtraction between the Int type and the other type.
     */
    @Override
    public SNumber subWithInt(TypeInt typeInt) {
        return new TypeInt(typeInt.value - this.value);
    }

    /**
     * Returns the subtraction between the current type and a Binary Type.
     *
     * @param typeBinary A Binary type who will be subtracted to the current type.
     * @return The subtraction between the Binary type and the other type.
     */
    @Override
    public SNumber subWithBinary(TypeBinary typeBinary) {
        String subtraction = intToBinary(typeBinary.getValueAsInt() - this.value);
        return new TypeBinary(subtraction);
    }

    /**
     * Method that returns the multiplication between the current type and the other type.
     * Returns the dominant type if possible, or throws an error if the operation is undefined.
     *
     * @param otherType Another type that will be multiplied to the current type.
     * @return The multiplication between the two types, returning the dominant type.
     */
    public SNumber mult(IMultWithInt otherType) {
        return otherType.multWithInt(this);
    }

    /**
     * Returns the multiplication between the current type and a Float Type.
     *
     * @param typeFloat A Float type who will be multiplied to the current type.
     * @return The multiplication between the Float type and the other type.
     */
    @Override
    public SNumber multWithFloat(TypeFloat typeFloat) {
        return new TypeFloat(typeFloat.getValue() * this.value);
    }

    /**
     * Returns the multiplication between the current type and an Int Type.
     *
     * @param typeInt An Int type who will be multiplied to the current type.
     * @return The multiplication between the Int type and the other type.
     */
    @Override
    public SNumber multWithInt(TypeInt typeInt) {
        return new TypeInt(typeInt.value * this.value);
    }
}
