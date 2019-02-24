package io.advance.poker.domain;

import java.util.Objects;

/**
 * Card of a certain rank, value and suit
 *
 * <p>
 * The value field determines the hand value that a card represents. For example in some games,
 * the ace has a hand value (14) and others a low value (1). This allows us to play different games
 * with different rules
 * </p>
 *
 * <p>
 * Example of a card is: Ace (<i>value=14</i>) of spades
 * </p>
 */
public class Card implements Comparable<Card> {
    private final Rank rank;
    private final Suit suit;
    private final int value;

    /**
     * Main constructor
     *
     * @param rank
     * @param value
     * @param suit
     */
    public Card(final Rank rank, final int value, final Suit suit) {
        this.rank = rank;
        this.value = value;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card o) {
        if (o == null)
            return -1;
        return Integer.compare(this.getValue(), o.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Card other = (Card) obj;
        return rank == other.rank && suit == other.suit;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Card [rank=")
            .append(rank)
            .append(", value=")
            .append(value)
            .append(", suit=")
            .append(suit)
            .append("]");

        return builder.toString();
    }

    public Rank getRank() {
        return this.rank;
    }

    public int getValue() {
        return this.value;
    }

    public Suit getSuit() {
        return this.suit;
    }

}
