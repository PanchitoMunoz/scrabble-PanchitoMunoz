package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.types_bridge;

import cl.uchile.dcc.scrabble.model.factories.hidden_factories.HTypeFactory;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenBinary;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenInt;
import cl.uchile.dcc.scrabble.model.utils.BinaryUtilities;

/**
 * Abstract class for a general Integer Bridge.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/20 0:23
 */
public abstract class AbstractHiddenIntegerBridge extends AbstractHiddenNumberBridge {

    /**
     * Constructor.
     *
     * @param value an {@code HType}
     */
    protected AbstractHiddenIntegerBridge(
        HType value) {
        super(value);
    }

    /**
     * Gets the value as binary
     * @return the value as binary
     */
    public String getValueAsBinary() {
        return this.getValue().getValueAsBinary();
    }

    /**
     * Gets the value as int
     * @return Gets the value as int
     */
    public int getValueAsInt() {
        return this.getValue().getValueAsInt();
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public final HiddenBinary addWithBinary(HiddenBinary hiddenBinary) {
        String computed = BinaryUtilities.intToBinary(
            hiddenBinary.getValueAsInt() + this.getValueAsInt());
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code add}
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public final HiddenInt addWithInt(HiddenInt hiddenInt) {
        int computed = hiddenInt.getValueAsInt() + this.getValueAsInt();
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public final HiddenBinary subWithBinary(HiddenBinary hiddenBinary) {
        String computed = BinaryUtilities.intToBinary(
            hiddenBinary.getValueAsInt() - this.getValueAsInt()
        );
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code sub}
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public final HiddenInt subWithInt(HiddenInt hiddenInt) {
        int computed = hiddenInt.getValueAsInt() - this.getValueAsInt();
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public final HiddenBinary multWithBinary(HiddenBinary hiddenBinary) {
        String computed = BinaryUtilities.intToBinary(
            hiddenBinary.getValueAsInt() * this.getValueAsInt()
        );
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code mult}
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public final HiddenInt multWithInt(HiddenInt hiddenInt) {
        int computed = hiddenInt.getValueAsInt() * this.getValueAsInt();
        return HTypeFactory.createHiddenInt(computed);
    }

    /**
     * To use double dispatch in {@code div}
     * @param hiddenBinary a {@code HiddenBinary}
     */
    @Override
    public final HiddenBinary divWithBinary(HiddenBinary hiddenBinary) {
        if (this.getValueAsInt() == 0) {
            return HTypeFactory.createHiddenBinary("0000");
        }
        String computed = BinaryUtilities.intToBinary(
            (int) Math.round((double) hiddenBinary.getValueAsInt() / this.getValueAsInt())
        );
        return HTypeFactory.createHiddenBinary(computed);
    }

    /**
     * To use double dispatch in {@code div}
     * @param hiddenInt a {@code HiddenInt}
     */
    @Override
    public final HiddenInt divWithInt(HiddenInt hiddenInt) {
        if (this.getValueAsInt() == 0) {
            return HTypeFactory.createHiddenInt(0);
        }
        int computed = (int) Math.round((double) hiddenInt.getValueAsInt() / this.getValueAsInt());
        return HTypeFactory.createHiddenInt(computed);
    }
}
