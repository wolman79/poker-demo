package io.advance.poker.standard;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import io.advance.poker.domain.Card;
import io.advance.poker.domain.Shuffler;

/**
 * The default implemention for shuffling cards.
 *
 * <p>
 * This strategy uses a PRNG to shuffle the cards
 * </p>
 *
 */
public class RandomShuffler implements Shuffler {
    private final Random rnd;

    /**
     * Default constructor
     */
    public RandomShuffler() {
        rnd = new Random();
    }

    /**
     * Constructor with a seed to the random number generator so we can creat reproducable results
     *
     * @param seed
     */
    public RandomShuffler(long seed) {
        rnd = new Random(seed);
    }

    @Override
    public void shuffle(List<Card> cards) {
        Collections.shuffle(cards, rnd);
    }

}
