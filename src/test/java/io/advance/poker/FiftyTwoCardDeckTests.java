package io.advance.poker;

import static io.advance.poker.domain.Rank.*;

import java.util.HashSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.advance.poker.domain.Card;
import io.advance.poker.domain.Rank;
import io.advance.poker.domain.Suit;
import io.advance.poker.standard.FiftyTwoCardDeck;

class FiftyTwoCardDeckTests {

    @Test
    void drawCard() {
        FiftyTwoCardDeck deck = new FiftyTwoCardDeck();
        Card card = deck.draw();
        Assertions.assertNotNull(card);
        System.out.println("Drew card: " + card);
    }

    @Test
    void check52Cards() {
        FiftyTwoCardDeck deck = new FiftyTwoCardDeck();

        // must be 52 cards in a standard deck
        Assertions.assertEquals(52, deck.size());

        // no duplicates
        Assertions.assertEquals(deck.size(), new HashSet<>(deck.getImmutableCardList()).size());
    }

    @Test
    void testCorrectCards() {
        FiftyTwoCardDeck deck = new FiftyTwoCardDeck();

        // assert 13 of each suits
        for (Suit suit : FiftyTwoCardDeck.SUITS) {
            Assertions.assertEquals(13, count(deck, suit));
        }

        // assert 4 of each type
        for (Rank type : FiftyTwoCardDeck.RANKS) {
            Assertions.assertEquals(4, count(deck, type));
        }
    }

    @Test
    void testCardRanks() {
        for (Suit s : FiftyTwoCardDeck.SUITS) {
            Assertions.assertTrue(cv(ACE, s) > cv(QUEEN, s));
            Assertions.assertTrue(cv(QUEEN, s) > cv(JACK, s));
            Assertions.assertTrue(cv(JACK, s) > cv(TEN, s));
            Assertions.assertTrue(cv(TEN, s) > cv(NINE, s));
            Assertions.assertTrue(cv(NINE, s) > cv(EIGHT, s));
            Assertions.assertTrue(cv(EIGHT, s) > cv(SEVEN, s));
            Assertions.assertTrue(cv(SEVEN, s) > cv(SIX, s));
            Assertions.assertTrue(cv(SIX, s) > cv(FIVE, s));
            Assertions.assertTrue(cv(FIVE, s) > cv(FOUR, s));
            Assertions.assertTrue(cv(FOUR, s) > cv(THREE, s));
            Assertions.assertTrue(cv(THREE, s) > cv(TWO, s));
        }
    }

    /**
     * Convenience method
     *
     * @param deck
     * @param s
     * @return
     */
    private long count(FiftyTwoCardDeck deck, Suit s) {
        return deck.getImmutableCardList()
            .stream()
            .filter(c -> c.getSuit() == s)
            .count();
    }

    /**
     * Convenience method
     *
     * @param deck
     * @param s
     * @return
     */
    private long count(FiftyTwoCardDeck deck, Rank t) {
        return deck.getImmutableCardList()
            .stream()
            .filter(c -> c.getRank() == t)
            .count();
    }

    /**
     * Convenience method for getting card ranks
     *
     * @param r
     * @param s
     * @return
     */
    private int cv(Rank r, Suit s) {
        return FiftyTwoCardDeck.newCard(r, s).getValue();
    }
}
