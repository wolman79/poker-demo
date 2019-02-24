package io.advance.poker.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * See <a href="https://en.wikipedia.org/wiki/List_of_poker_hands">Wikipedia</a> article
 * </p>
 */
public enum Suit {
    SPADE, HEART, DIAMOND, CLUB;

    /**
     * Convenience method
     *
     * @return
     */
    public static List<Suit> toList() {
        return Collections.unmodifiableList(Arrays.asList(values()));
    }
}
