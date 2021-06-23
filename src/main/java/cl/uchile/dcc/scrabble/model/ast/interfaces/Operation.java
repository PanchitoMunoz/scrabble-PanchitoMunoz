package cl.uchile.dcc.scrabble.model.ast.interfaces;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.interfaces.HiddenAST;

/**
 * This interface is to define the different types of operations that exists. This is the composite
 * part of {@code HiddenAST}, using the composite pattern
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/12 23:47
 * @see HiddenAST
 */
public interface Operation extends AST {

    /**
     * Transform the current instance into a {@code TypeBinary}.
     *
     * @return a {@code TypeBinary}
     */
    Operation toTypeBinary();

    /**
     * Transform the current instance into a {@code TypeBool}.
     *
     * @return a {@code TypeBool}
     */
    Operation toTypeBool();

    /**
     * Transform the current instance into a {@code TypeFloat}.
     *
     * @return a {@code TypeFloat}
     */
    Operation toTypeFloat();

    /**
     * Transform the current instance into a {@code TypeInt}.
     *
     * @return a {@code TypeInt}
     */
    Operation toTypeInt();

    /**
     * Transform the current instance into a {@code TypeString}.
     *
     * @return a {@code TypeString}
     */
    Operation toTypeString();
}
