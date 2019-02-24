package io.advance.poker.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.advance.poker.domain.Card;
import io.advance.poker.domain.Rank;
import io.advance.poker.domain.Suit;

/**
 * Separate the visualization from the rest of the program in order to keep the API's clean
 */
public class ConsoleRenderer {
    private static final Map<Suit, String> SUITS = new HashMap<>();
    static {
        SUITS.put(Suit.SPADE, "♠");
        SUITS.put(Suit.CLUB, "♣");
        SUITS.put(Suit.HEART, "♥");
        SUITS.put(Suit.DIAMOND, "♦");
    };

    private static final Map<Rank, String> RANKS = new HashMap<>();
    static {
        RANKS.put(Rank.TWO, "2");
        RANKS.put(Rank.THREE, "3");
        RANKS.put(Rank.FOUR, "4");
        RANKS.put(Rank.FIVE, "5");
        RANKS.put(Rank.SIX, "6");
        RANKS.put(Rank.SEVEN, "7");
        RANKS.put(Rank.EIGHT, "8");
        RANKS.put(Rank.NINE, "9");
        RANKS.put(Rank.TEN, "10");
        RANKS.put(Rank.JACK, "J");
        RANKS.put(Rank.KING, "K");
        RANKS.put(Rank.QUEEN, "Q");
        RANKS.put(Rank.ACE, "A");
        RANKS.put(Rank.JOKER, "JoK3r");
    };

    /**
     * Get a string representation of the current card
     *
     * @param card
     * @return
     */
    public String render(Card card) {
        try {
            Rank rank = card.getRank();
            Suit suit = card.getSuit();

            return String.format("%s%s", RANKS.get(rank), SUITS.get(suit));
        } catch (Exception e) {
            System.err.println("Failed to render card " + card);
            return "?";
        }
    }

    /**
     * Render a list of cards
     *
     * @param cards
     * @return
     */
    public String render(List<Card> cards) {
        return cards.stream()
            .map(this::render)
            .collect(Collectors.joining(" "));
    }

}
