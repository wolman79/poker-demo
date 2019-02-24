package io.advance.poker;

import io.advance.poker.domain.PokerGame;
import io.advance.poker.exceptions.PokerGameException;
import io.advance.poker.standard.FiftyTwoCardDeck;
import io.advance.poker.standard.FiveCardDealer;
import io.advance.poker.standard.RandomShuffler;
import io.advance.poker.standard.StandardHandEvaluator;

/**
 * Factory class that creates a new {@link PokerGame} depending on the give type.
 *
 * <p>
 * Using this factory class, the api developer doesn't need to know all the required dependencies
 * </p>
 */
public class PokerGameFactory {

    /**
     * All the different poker games we intend to support
     */
    public enum GameType {
        Standard, Badugi;
    }

    /**
     * The main factory method that instantiate a ready to use {@link PokerGame}
     *
     * @param type
     * @return the poker game you're about to play
     */
    public PokerGame create(GameType type) {
        switch (type) {
        case Standard:
            return new PokerGame(
                    new FiftyTwoCardDeck(),
                    new RandomShuffler(),
                    new FiveCardDealer(),
                    new StandardHandEvaluator());

        default:
            throw new PokerGameException("Sorry, poker game of type " + type + " not yet implemented!");
        }
    }

}
