package io.advance.poker.standard;

import java.util.ArrayList;
import java.util.List;

import io.advance.poker.domain.Card;
import io.advance.poker.domain.Dealer;
import io.advance.poker.domain.Deck;

/**
 * Default implemention for dealing a hand of 5 {@link Card}
 *
 * <p>
 * After the {@link #deal(Deck)} method has been called, the {@link Deck} won't have those
 * cards anymore
 * </p>
 *
 */
public class FiveCardDealer implements Dealer {

    @Override
    public List<Card> deal(Deck deck) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cards.add(deck.draw());
        }

        return cards;
    }

}
