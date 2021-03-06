package cl.uchile.dcc.scrabble.model.hidden_layer;

import cl.uchile.dcc.scrabble.model.ast.ASTLeaf;
import org.jetbrains.annotations.NotNull;

/**
 * An interface to define a generic leaf in {@code HiddenASTComponent}
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/07/04 0:47
 */
public interface HiddenASTLeaf extends HiddenASTComponent {

    /**
     * Returns the number of vertices in the current {@code HiddenASTComponent}
     *
     * @return the number of vertices
     */
    @Override
    default int size() {
        return 1;
    }

    /**
     * Returns the AST equivalent.
     *
     * @return an AST equivalent.
     */
    @NotNull ASTLeaf asAST();
}
