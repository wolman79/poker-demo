package io.advance.poker.domain;

/**
 * Deck defines what a deck of playing cards should be able to do
 */
public interface Deck {

    /**
     * Reset the deck to its original state
     */
    void reset();

    /**
     * Shuffle the order of the cards in the deck to make the game unpredictable
     *
     * @param shuffler
     */
    void shuffle(Shuffler shuffler);

    /**
     * Get the next card from the deck
     *
     * @return a card
     */
    Card draw();

    /**
     * Count the number of cards
     *
     * @return
     */
    int size();

    /**
     * Get the position of a specific card in the deck
     *
     * @param first
     * @return
     */
    int indexOf(Card first);

}
