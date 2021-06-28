package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.abstract_types.AbstractHiddenType;
import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.factories.types_factories.STypeFactory;
import cl.uchile.dcc.scrabble.model.types.TypeFloat;
import cl.uchile.dcc.scrabble.model.types.TypeString;

/**
 * A class to wrap a {@code TypeFloat}. To use adapter pattern.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/13 0:02
 * @see TypeFloat
 */
public class HiddenFloat extends AbstractHiddenType {

    private final TypeFloat typeFloat;

    /**
     * Constructor.
     *
     * @param typeFloat a type float
     */
    public HiddenFloat(TypeFloat typeFloat) {
        this.typeFloat = STypeFactory.createTypeFloat(typeFloat);
    }

    /**
     * Constructor.
     *
     * @param value a double
     */
    public HiddenFloat(double value) {
        this(STypeFactory.createTypeFloat(value));
    }

    /**
     * Gets the current instance in the wrapper
     *
     * @return the instance in the wrapper
     */
    @Override
    public TypeFloat toSType() {
        return STypeFactory.createTypeFloat(typeFloat);
    }

    @Override
    public String toString() {
        return "HiddenFloat{" +
            "value=" + typeFloat.getValue() +
            '}';
    }

    /**
     * Transform the current instance to a {@code HiddenFloat}.
     *
     * @return a {@code HiddenFloat} equivalent
     */
    @Override
    public HiddenFloat toHiddenFloat() {
        TypeFloat computed = this.typeFloat.toTypeFloat();
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * Transform the current instance to a {@code HiddenString}.
     *
     * @return a {@code HiddenString} equivalent
     */
    @Override
    public HiddenString toHiddenString() {
        TypeString computed = this.typeFloat.toTypeString();
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
        return hType.addWithFloat(this);
    }

    /**
     * Returns the division between numbers
     *
     * @param hType another number
     * @return the division
     */
    @Override
    public HType div(HType hType) {
        return hType.divWithFloat(this);
    }

    /**
     * Returns the multiplication between numbers
     *
     * @param hType another number
     * @return the multiplication
     */
    @Override
    public HType mult(HType hType) {
        return hType.multWithFloat(this);
    }

    /**
     * Returns the subtraction between numbers
     *
     * @param hType another number
     * @return the subtraction
     */
    @Override
    public HType sub(HType hType) {
        return hType.subWithFloat(this);
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public HType addWithFloat(HiddenFloat hiddenFloat) {
        TypeFloat computed = this.typeFloat.addWithFloat(hiddenFloat.toSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HType addWithInt(HiddenInt hiddenInt) {
        TypeFloat computed = this.typeFloat.addWithInt(hiddenInt.toSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public HType subWithFloat(HiddenFloat hiddenFloat) {
        TypeFloat computed = this.typeFloat.subWithFloat(hiddenFloat.toSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     *
     *
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HType subWithInt(HiddenInt hiddenInt) {
        TypeFloat computed = this.typeFloat.subWithInt(hiddenInt.toSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     *
     *
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public HType multWithFloat(HiddenFloat hiddenFloat) {
        TypeFloat computed = this.typeFloat.multWithFloat(hiddenFloat.toSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     *
     *
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HType multWithInt(HiddenInt hiddenInt) {
        TypeFloat computed = this.typeFloat.multWithInt(hiddenInt.toSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     *
     *
     * @param hiddenFloat a {@code HiddenFloat}
     */
    @Override
    public HType divWithFloat(HiddenFloat hiddenFloat) {
        TypeFloat computed = this.typeFloat.divWithFloat(hiddenFloat.toSType());
        return HTypeFactory.createHiddenFloat(computed);
    }

    /**
     * To use double dispatch in {@code div}
     *
     *
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public HType divWithInt(HiddenInt hiddenInt) {
        TypeFloat computed = this.typeFloat.divWithInt(hiddenInt.toSType());
        return HTypeFactory.createHiddenFloat(computed);
    }
}
