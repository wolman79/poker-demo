package io.advance.poker.domain;

/**
 * POJO that describes the strength and category for a hand of cards.
 *
 * <p>
 * We compare two ranks to find which one was the winner by comparing the following:
 * <ol>
 * <li>value</li>
 * <li>highCard</li>
 * </ol>
 * </p>
 */
public class HandRank implements Comparable<HandRank> {
    private int value;
    private int highCard;
    private String description;

    /**
     * Main constructor
     *
     *
     * @param value - the strength of the rank
     * @param highCard - the high card is used for tie breaking
     * @param description - description of the rank, ex: Three of a Kind
     */
    public HandRank(int value, int highCard, String description) {
        this.value = value;
        this.highCard = highCard;
        this.description = description;
    }

    @Override
    public int compareTo(HandRank o) {
        if (o == null)
            return -1;
        if (this.getValue() == o.getValue())
            return Integer.compare(this.getHighCard(), o.getHighCard());

        return Integer.compare(this.getValue(), o.getValue());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("HandRank [value=")
            .append(value)
            .append(", highCard=")
            .append(highCard)
            .append(", description=")
            .append(description)
            .append("]");

        return builder.toString();
    }

    public int getValue() {
        return this.value;
    }

    public int getHighCard() {
        return this.highCard;
    }

    public String getDescription() {
        return this.description;
    }

}
