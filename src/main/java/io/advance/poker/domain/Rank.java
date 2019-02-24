package io.advance.poker.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The commonly used ranks for playing card games
 *
 * <p>
 * See <a href="https://en.wikipedia.org/wiki/List_of_poker_hands">Wikipedia</a> article
 * </p>
 */
public enum Rank {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE, JOKER;

    /**
     * Convenience method
     *
     * @return
     */
    public static List<Rank> toList() {
        return Collections.unmodifiableList(Arrays.asList(values()));
    }
}
