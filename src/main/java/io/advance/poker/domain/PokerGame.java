package io.advance.poker.domain;

import java.util.List;

/**
 * Default implementation of a poker game.
 *
 * <p>
 * Delegates the game's functionality to specific classes in order to support any card game.
 *
 * This following dependencies must be specified when creating and instance of this class:
 * <ol>
 *   <li>{@code Deck }</li>
 *   <li>{@code Shuffler }</li>
 *   <li>{@code Dealer }</li>
 *   <li>{@code HandEvaluator }</li>
 * </ol>
 * </p>
 */
public class PokerGame {
    private final Deck deck;
    private final Shuffler shuffler;
    private final Dealer dealer;
    private final HandEvaluator evaluator;

    /**
     * Main constructor
     *
     * @param deck
     * @param shuffler
     * @param dealer
     * @param evaluator
     */
    public PokerGame(final Deck deck, final Shuffler shuffler, final Dealer dealer, final HandEvaluator evaluator) {
        this.deck = deck;
        this.shuffler = shuffler;
        this.dealer = dealer;
        this.evaluator = evaluator;
    }

    /**
     * Shuffle all cards accoring to the shuffler strategy
     */
    public void shuffle() {
        getDeck().shuffle(getShuffler());
    }

    /**
     * Deal a hand of cards accoring to the dealer strategy
     */
    public List<Card> deal() {
        return dealer.deal(getDeck());
    }

    /**
     * Categorize the hand according to the rank evaluator strategy
     *
     * @param hand
     * @return
     */
    public HandRank evaluate(List<Card> hand) {
        return evaluator.evaluate(hand);
    }

    public Deck getDeck() {
        return this.deck;
    }

    public Shuffler getShuffler() {
        return this.shuffler;
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public HandEvaluator getEvaluator() {
        return this.evaluator;
    }
}
