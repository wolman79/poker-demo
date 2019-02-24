package io.advance.poker.domain;

import java.util.List;

/**
 * Some shuffle operations that can be performed on a set of card
 *
 * <p>
 * <b>NOTE:</b> The {@link #shuffle(List)} method expects its list parameter to
 *  be mutable in order to shuffle it
 * </p>
 */
public interface Shuffler {

    /**
     * Shuffle cards according to a specific strategy
     *
     * @param cards must be a mutable list
     */
    void shuffle(List<Card> hand);

}
