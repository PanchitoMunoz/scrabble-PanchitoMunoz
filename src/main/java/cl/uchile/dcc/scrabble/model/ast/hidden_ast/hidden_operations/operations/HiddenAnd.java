package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.abstract_classes.AbstractHiddenBinaryOperation;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.abstract_classes.AbstractHiddenOperation;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.HiddenAST;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/21 17:33
 */
public class HiddenAnd extends AbstractHiddenBinaryOperation {

    /**
     * Default constructor. It can receive an {@code HiddenOperation} or a {@code HType}.
     *
     * @param leftValue  left value, it can be an {@code HiddenOperation} or a {@code HType}.
     * @param rightValue right value, it can be an {@code HiddenOperation} or a {@code HType}.
     */
    public HiddenAnd(HiddenAST leftValue, HiddenAST rightValue) {
        super(leftValue, rightValue);
    }

    /**
     * Operator symbol as {@code String}. To use template pattern in {@code asString}.
     *
     * @return Operator symbol as {@code String}
     */
    @Override
    protected String operatorSymbol() {
        return "and";
    }

    /**
     * Operator name as {@code String}. To use template pattern in {@code asString}.
     *
     * @return Operator name as {@code String}.
     */
    @Override
    protected String operatorName() {
        return "And";
    }

    /**
     * Compute the operation between 2 {@code HType} and returns its operation. To use template
     * pattern.
     *
     * @param value1 the value at the left
     * @param value2 the value at the right
     * @return the value computed
     */
    @Override
    protected HType mainOperation(HType value1, HType value2) {
        return value1.and(value2);
    }
}
