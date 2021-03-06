package cl.uchile.dcc.scrabble.model.factories;

/**
 * Interface to describe any factory of Types, such as {@code SType} or {@code HType}.
 *
 * @author Francisco Muñoz Guajardo
 * @create 2021/06/20 20:47
 */
public interface GeneralTypeFactory {

    /**
     * Clear the current caché.
     */
    void clear();

    /**
     * Returns {@code true} if the caché is empty, {@code false} otherwise.
     *
     * @return a boolean
     */
    boolean isEmpty();
}
