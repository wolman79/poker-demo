package io.advance.poker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.advance.poker.domain.Rank;
import io.advance.poker.domain.Suit;
import io.advance.poker.standard.FiftyTwoCardDeck;

public class CardTests {

    @Test
    public void testEquality() {
        Assertions.assertEquals(FiftyTwoCardDeck.newCard(Rank.ACE, Suit.SPADE),
                FiftyTwoCardDeck.newCard(Rank.ACE, Suit.SPADE));

        Assertions.assertNotEquals(FiftyTwoCardDeck.newCard(Rank.ACE, Suit.CLUB),
                FiftyTwoCardDeck.newCard(Rank.TWO, Suit.CLUB));

        Assertions.assertNotEquals(FiftyTwoCardDeck.newCard(Rank.ACE, Suit.CLUB),
                FiftyTwoCardDeck.newCard(Rank.ACE, Suit.DIAMOND));
    }

}
