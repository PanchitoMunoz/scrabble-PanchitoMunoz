package cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations;

import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.operations.Operation;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.HiddenOperator;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/**
 * Abstract class for a general {@code Operation}.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/14 9:52
 * @see Operation
 * @see SType
 * @see AST
 */
public abstract class AbstractOperation implements Operation {

    private final HiddenOperator adaptee;

    /**
     * Constructor by default.
     *
     * @param adaptee a HiddenOperator to adapt
     */
    protected AbstractOperation(HiddenOperator adaptee) {
        this.adaptee = adaptee;
    }

    /**
     * Transform an {@code AST} into its equivalent {@code HiddenASTComponent}.
     *
     * @return a transformation
     */
    @Override
    public @NotNull HiddenOperator asHiddenAST() {
        return adaptee;
    }

    /**
     * Sets the variable in an {@code Operation}.
     *
     * @param name  the name of the variable
     * @param value the current value to set
     */
    @Override
    public void setVariable(String name, SType value) {
        this.adaptee.setVariable(name, value.asHiddenAST());
    }

    /**
     * Calculate the {@code SType} result of performing all operations
     *
     * @return SType result of operations.
     */
    @Override
    public SType calculate() {
        return adaptee.calculate().asSType();
    }

    /**
     * A String representation of the current instance.
     *
     * @return a string representation
     */
    @Override
    public String toString() {
        return adaptee.toString();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Operation)) {
            return false;
        }

        Operation that = (Operation) o;

        return asHiddenAST().equals(that.asHiddenAST());
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     * @see Object#equals(Object)
     * @see System#identityHashCode
     */
    @Override
    public int hashCode() {
        return asHiddenAST().hashCode();
    }
}
