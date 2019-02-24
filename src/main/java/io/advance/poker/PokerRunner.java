package io.advance.poker;

import java.util.Collections;
import java.util.List;

import io.advance.poker.PokerGameFactory.GameType;
import io.advance.poker.domain.Card;
import io.advance.poker.domain.HandRank;
import io.advance.poker.domain.PokerGame;
import io.advance.poker.view.ConsoleRenderer;

/**
 * A demo application for demonstrating the modules in the project
 */
public class PokerRunner {
    private final ConsoleRenderer renderer = new ConsoleRenderer();
    private final PokerGameFactory factory = new PokerGameFactory();

    public static void main(String[] args) {
        new PokerRunner().play();
    }

    /**
     * Shuffle, deal and evaluate a hand
     */
    private void play() {
        PokerGame game = factory.create(GameType.Standard);

        // deal a hand of cards
        List<Card> hand;
        HandRank rank;

        // cheat until we get a winning hand
        do {
            game.getDeck().reset();
            game.shuffle();
            hand = game.deal();

            // evaluate and categorize the dealt hand
            rank = game.evaluate(hand);
        } while (rank.getValue() <= 1);

        // display the game status
        Collections.sort(hand);
        System.out.println("Your hand : " + renderer.render(hand));
        System.out.println("You have  : " + rank.getDescription());
    }

}
