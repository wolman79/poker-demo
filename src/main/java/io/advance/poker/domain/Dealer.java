package io.advance.poker.domain;

import java.util.List;

/**
 * Operations to abstract away the dealing of hands
 */
public interface Dealer {

    /**
     * Deal card(s) from the deck and give to a player
     *
     * @param deck
     */
    List<Card> deal(Deck deck);

}
