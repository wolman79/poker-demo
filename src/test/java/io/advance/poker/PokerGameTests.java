package io.advance.poker;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import io.advance.poker.domain.Card;
import io.advance.poker.domain.Dealer;
import io.advance.poker.domain.Deck;
import io.advance.poker.domain.HandEvaluator;
import io.advance.poker.domain.PokerGame;
import io.advance.poker.domain.Shuffler;

/**
 * We're just going to test if the game delegates the calls correctly
 */
public class PokerGameTests {

    @Test
    void testGameDelegation() {
        // Let's mockup all the dependencies for a game
        Deck deck = mock(Deck.class);
        Shuffler shuffler = mock(Shuffler.class);
        Dealer dealer = mock(Dealer.class);
        HandEvaluator evaluator = mock(HandEvaluator.class);
        PokerGame game = new PokerGame(deck, shuffler, dealer, evaluator);

        // test shuffler was called
        game.shuffle();
        verify(deck).shuffle(shuffler);

        // verify dealer was used to deal
        List<Card> hand = game.deal();
        verify(dealer).deal(deck);

        // verify evaluator was called
        game.evaluate(hand);
        verify(evaluator).evaluate(hand);
    }

}
