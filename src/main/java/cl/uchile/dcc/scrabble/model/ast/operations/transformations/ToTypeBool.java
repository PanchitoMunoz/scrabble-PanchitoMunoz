package cl.uchile.dcc.scrabble.model.ast.operations.transformations;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.transformations.ToHiddenBool;
import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.HiddenOperation;
import cl.uchile.dcc.scrabble.model.ast.AST;
import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractOperation;
import cl.uchile.dcc.scrabble.model.ast.operations.abstract_operations.AbstractTransformation;

/**
 * TODO: DOCUMENTAR
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/22 23:57
 */
public class ToTypeBool extends AbstractTransformation {

    /**
     * Constructor.
     *
     * @param value an AST. It can be an {@code Operation} or a {@code SType}.
     */
    public ToTypeBool(AST value) {
        super(new ToHiddenBool(value.toHiddenAST()));
    }

}
