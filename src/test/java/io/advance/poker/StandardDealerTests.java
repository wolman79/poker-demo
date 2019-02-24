package io.advance.poker;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.advance.poker.domain.Card;
import io.advance.poker.domain.Dealer;
import io.advance.poker.standard.FiveCardDealer;
import io.advance.poker.standard.FiftyTwoCardDeck;

class StandardDealerTests {

    @Test
    void test() {
        Dealer dealer = new FiveCardDealer();
        FiftyTwoCardDeck deck = new FiftyTwoCardDeck();
        Assertions.assertEquals(52, deck.size());

        // deal some cards
        List<Card> cards = dealer.deal(deck);
        Assertions.assertEquals(5, cards.size());
        Assertions.assertEquals(47, deck.size());

        // make sure there are no duplicates
        Assertions.assertEquals(cards.size(), new HashSet<>(cards).size());
    }

}
