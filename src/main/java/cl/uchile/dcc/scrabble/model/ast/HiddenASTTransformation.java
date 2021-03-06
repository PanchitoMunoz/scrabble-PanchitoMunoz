package cl.uchile.dcc.scrabble.model.ast;

import cl.uchile.dcc.scrabble.model.ast.operations.Operation;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenAST;
import cl.uchile.dcc.scrabble.model.hidden_layer.HiddenASTComponent;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.HiddenOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.types.interface_types.SType;
import org.jetbrains.annotations.NotNull;

/**
 * Interface that provides the transformation to a Hidden Type. This functionality allows mapping
 * {@code SType} and {@code Operation} to {@code HType} and {@code HiddenOperator} in the {@code
 * HiddenASTComponent}.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/14 8:53
 * @see SType
 * @see HType
 * @see Operation
 * @see HiddenOperator
 * @see HiddenASTComponent
 */
public interface HiddenASTTransformation {

    /**
     * Transform an {@code AST} into its equivalent {@code HiddenASTComponent}.
     *
     * @return a transformation
     */
    @NotNull HiddenAST asHiddenAST();
}
