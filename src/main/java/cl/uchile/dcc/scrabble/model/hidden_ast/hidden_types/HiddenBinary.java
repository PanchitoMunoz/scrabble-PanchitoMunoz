package cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types;

import cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types.abstract_types.AbstractHiddenType;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.types.TypeBinary;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeInt;
import cl.uchile.dcc.scrabble.model.types.TypeString;

/**
 * A class to wrap a {@code TypeBinary}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:01
 * @see TypeBinary
 */
public class HiddenBinary extends AbstractHiddenType {

    private final TypeBinary typeBinary;

    /**
     * Constructor.
     *
     * @param typeBinary a Type Binary
     */
    public HiddenBinary(TypeBinary typeBinary) {
        this.typeBinary = STypeFactory.createTypeBinary(typeBinary);
    }

    /**
     * Constructor
     *
     * @param value a string binary
     */
    public HiddenBinary(String value) {
        this(STypeFactory.createTypeBinary(value));
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeBinary toSType() {
        return STypeFactory.createTypeBinary(typeBinary);
    }

    @Override
    public String toString() {
        return "HiddenBinary{" +
            "value=" + typeBinary.getValue() +
            '}';
    }

    /**
     * Transform the current instance to a {@code HiddenBinary}.
     *
     * @return a {@code HiddenBinary} equivalent
     */
    @Override
    public HType toHiddenBinary() {
        TypeBinary computed = this.typeBinary.toTypeBinary();
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat} equivalent
     */
    @Override
    public HType toHiddenFloat() {
        TypeFloat computed = this.typeBinary.toTypeFloat();
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenInt}.
     *
     * @return a {@code HiddenInt} equivalent
     */
    @Override
    public HType toHiddenInt() {
        TypeInt computed = this.typeBinary.toTypeInt();
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenString}.
     *
     * @return a {@code HiddenString} equivalent
     */
    @Override
    public HType toHiddenString() {
        TypeString computed = this.typeBinary.toTypeString();
        return HTypeFactory.createHiddenString(computed);
    }

    /**
     * Returns the sum
     *
     * @param hType other type to sum
     * @return the sum
     */
    @Override
    public HType add(HType hType) {
        return hType.addWithBinary(this);
    }

    /**
     * Returns the disjunction between logicals
     *
     * @param hType another logical
     * @return the disjunction
     */
    @Override
    public HType and(HType hType) {
        return hType.andWithBinary(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param hType another number
     * @return the division
     */
    @Override
    public HType div(HType hType) {
        return hType.divWithBinary(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param hType another number
     * @return the multiplication
     */
    @Override
    public HType mult(HType hType) {
        return hType.multWithBinary(this);
    }

    /**
     * Returns the conjunction between logicals
     *
     * @param hType another logical
     * @return the conjunction
     */
    @Override
    public HType or(HType hType) {
        return hType.orWithBinary(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param hType another number
     * @return the subtraction
     */
    @Override
    public HType sub(HType hType) {
        return hType.subWithBinary(this);
    }

    /**
     * Returns the negation of the current instance
     *
     * @return the negation.
     */
    @Override
    public HType neg() {
        return HTypeFactory.createHiddenBinary(this.typeBinary.neg());
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public HType addWithBinary(HiddenBinary hiddenBinary) {
        TypeBinary computed = this.typeBinary.addWithBinary(hiddenBinary.toSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public HType addWithFloat(HiddenFloat hiddenFloat) {
        TypeFloat computed = this.typeBinary.addWithFloat(hiddenFloat.toSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HType addWithInt(HiddenInt hiddenInt) {
        TypeInt computed = this.typeBinary.addWithInt(hiddenInt.toSType());
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public HType subWithBinary(HiddenBinary hiddenBinary) {
        TypeBinary computed = this.typeBinary.subWithBinary(hiddenBinary.toSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public HType subWithFloat(HiddenFloat hiddenFloat) {
        TypeFloat computed = this.typeBinary.subWithFloat(hiddenFloat.toSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HType subWithInt(HiddenInt hiddenInt) {
        TypeInt computed = this.typeBinary.subWithInt(hiddenInt.toSType());
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public HType multWithBinary(HiddenBinary hiddenBinary) {
        TypeBinary computed = this.typeBinary.multWithBinary(hiddenBinary.toSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public HType multWithFloat(HiddenFloat hiddenFloat) {
        TypeFloat computed = this.typeBinary.multWithFloat(hiddenFloat.toSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HType multWithInt(HiddenInt hiddenInt) {
        TypeInt computed = this.typeBinary.multWithInt(hiddenInt.toSType());
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code div}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public HType divWithBinary(HiddenBinary hiddenBinary) {
        TypeBinary computed = this.typeBinary.divWithBinary(hiddenBinary.toSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code div}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public HType divWithFloat(HiddenFloat hiddenFloat) {
        TypeFloat computed = this.typeBinary.divWithFloat(hiddenFloat.toSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HType divWithInt(HiddenInt hiddenInt) {
        TypeInt computed = this.typeBinary.divWithInt(hiddenInt.toSType());
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code and}
     * @param hiddenBool a {@code HiddenBool}
     */
    @Override
    public HType andWithBool(HiddenBool hiddenBool) {
        TypeBinary computed = this.typeBinary.andWithBool(hiddenBool.toSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code and}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public HType andWithBinary(HiddenBinary hiddenBinary) {
        TypeBinary computed = this.typeBinary.andWithBinary(hiddenBinary.toSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     * @param hiddenBool a {@code HiddenBool}
     */
    @Override
    public HType orWithBool(HiddenBool hiddenBool) {
        TypeBinary computed = this.typeBinary.orWithBool(hiddenBool.toSType());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code or}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public HType orWithBinary(HiddenBinary hiddenBinary) {
        TypeBinary computed = this.typeBinary.orWithBinary(hiddenBinary.toSType());
        return HTypeFactory.createHiddenBinary(computed);
    }
}