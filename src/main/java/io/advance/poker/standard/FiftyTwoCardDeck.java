package io.advance.poker.standard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import io.advance.poker.domain.Card;
import io.advance.poker.domain.Deck;
import io.advance.poker.domain.Rank;
import io.advance.poker.domain.Shuffler;
import io.advance.poker.domain.Suit;
import io.advance.poker.exceptions.PokerGameException;

/**
 * The standard 52 card deck
 *
 * <p>
 * The undelying implemtation for storing the cards is a {@link LinkedList}
 * </p>
 *
 * <p>
 * See more here: <a href="https://en.wikipedia.org/wiki/Standard_52-card_deck">Wikipedia</a>
 * </p>
 */
public class FiftyTwoCardDeck implements Deck {
    /**
     * Maps ranks to hand value
     */
    private static final Map<Rank, Integer> RANK_VALUES = new HashMap<>();
    static {
        RANK_VALUES.put(Rank.TWO, 2);
        RANK_VALUES.put(Rank.THREE, 3);
        RANK_VALUES.put(Rank.FOUR, 4);
        RANK_VALUES.put(Rank.FIVE, 5);
        RANK_VALUES.put(Rank.SIX, 6);
        RANK_VALUES.put(Rank.SEVEN, 7);
        RANK_VALUES.put(Rank.EIGHT, 8);
        RANK_VALUES.put(Rank.NINE, 9);
        RANK_VALUES.put(Rank.TEN, 10);
        RANK_VALUES.put(Rank.JACK, 11);
        RANK_VALUES.put(Rank.QUEEN, 12);
        RANK_VALUES.put(Rank.KING, 13);
        RANK_VALUES.put(Rank.ACE, 14);
    }

    // Ranks used in the standard 52 card deck (no joker)
    public static final List<Rank> RANKS = Collections.unmodifiableList(new ArrayList<>(RANK_VALUES.keySet()));

    // The four suits used in the standard 52 card deck
    public static final List<Suit> SUITS = Suit.toList();

    // Keep the cards in a linked list so we can modify the head of the deck
    private final List<Card> cards = new LinkedList<>();

    /**
     * Default constructor
     */
    public FiftyTwoCardDeck() {
        build();
    }

    /**
     * Build the 52 unique different {@link Card} of a standard deck
     */
    private void build() {
        for (Rank rank : RANKS) {
            for (Suit suit : SUITS) {
                cards.add(newCard(rank, suit));
            }
        }
    }

    @Override
    public Card draw() {
        if (cards.size() == 0)
            throw new PokerGameException("No more cards in the deck");

        return cards.remove(0);
    }

    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public void reset() {
        cards.clear();
        build();
    }

    @Override
    public void shuffle(Shuffler shuffler) {
        shuffler.shuffle(cards);
    }

    @Override
    public int indexOf(Card card) {
        return cards.indexOf(card);
    }

    /**
     * Create a card with its correct hand value
     *
     * @param r
     * @param s
     * @return
     */
    public static Card newCard(Rank r, Suit s) {
        int value = RANK_VALUES.get(r);

        return new Card(r, value, s);
    }

    /**
     * Expose the card list implementation but make it immutable
     *
     * @return immutable list of cards in the deck
     */
    public List<Card> getImmutableCardList() {
        return Collections.unmodifiableList(cards);
    }

}
