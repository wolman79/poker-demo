package io.advance.poker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.advance.poker.domain.Card;
import io.advance.poker.domain.Deck;
import io.advance.poker.domain.Rank;
import io.advance.poker.domain.Suit;
import io.advance.poker.standard.FiftyTwoCardDeck;
import io.advance.poker.standard.RandomShuffler;

class DefaultShufflerTests {

    @Test
    void testRandomShuffle() {
        Deck deck = new FiftyTwoCardDeck();

        // for non-stochastic unit test, lock the seed to 0
        RandomShuffler shuffler = new RandomShuffler(0);

        // assert that the card is in the deck
        Card card = FiftyTwoCardDeck.newCard(Rank.ACE, Suit.SPADE);
        int index = deck.indexOf(card);
        Assertions.assertTrue(index >= 0);

        // get some stats from our shuffles
        int totalAtPos0 = 0;
        int iterations = 100000;
        for (int i = 0; i < 100000; i++) {
            deck.shuffle(shuffler);
            if (deck.indexOf(card) == 0)
                totalAtPos0++;
        }

        // test that there is ~ 1/52 chance of the card being at position 0
        double exp = (1 / 52d) * 100;
        double act = (totalAtPos0 / (double) iterations) * 100;
        double epsilon = 0.1d;
        Assertions.assertTrue(Math.abs(exp - act) <= epsilon,
                "The shuffle isn't random enough. exp=" + exp + " act=" + act);
    }

}
