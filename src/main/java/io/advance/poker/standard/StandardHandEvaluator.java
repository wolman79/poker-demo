package io.advance.poker.standard;

import java.util.HashSet;
import java.util.List;

import io.advance.poker.domain.Card;
import io.advance.poker.domain.HandEvaluator;
import io.advance.poker.domain.HandRank;
import io.advance.poker.exceptions.PokerGameException;

/**
 * From a hand of 5 cards, determine to which category the hand belongs
 *
 * Disclaimer: this code was adapted and refactored for readability from:
 *  - http://cobweb.cs.uga.edu/~gtb/1302/Project1/PokerHand.java
 */
public class StandardHandEvaluator implements HandEvaluator {

    @Override
    public HandRank evaluate(List<Card> hand) {
        validate(hand);

        // sort cards by rank in ascending hand-value order
        Card[] cards = sortCards(hand);

        // get the card with highest value
        int highCard = cards[cards.length - 1].getValue();

        // hand rank logic
        int rank = 0;
        rank = checkTwoPair(cards, rank);
        rank = checkThreeOfaKind(cards, rank);
        rank = checkStraight(cards, rank);
        rank = checkFourOfaKind(cards, rank);
        rank = checkFlush(cards, rank);

        return new HandRank(rank, highCard, rankToName(rank));
    }

    /**
     * Assert the correct number of cards in the hand
     *
     * @param hand
     */
    private void validate(List<Card> hand) {
        if (hand.size() != 5)
            throw new PokerGameException("The evaluator only works if there are five cards");

        if (new HashSet<>(hand).size() != 5)
            throw new PokerGameException("The cards are not unique");
    }

    /**
     * One pair, or simply a pair, is a hand that contains two cards of one rank and three
     * cards of three other ranks (the kickers).
     * It ranks below two pair and above high card
     *
     * Two pair is a hand that contains two cards of one rank, two cards of another rank and
     * one card of a third rank (the kicker).
     * It ranks below three of a kind and above one pair.[6]
     *
     * @param cards
     * @param rank
     * @return
     */
    private int checkTwoPair(Card[] cards, int rank) {
        int pairIndex = -1;
        for (int i = 0; i < 4; i++) {
            if (cards[i].getRank() == cards[i + 1].getRank()) {
                pairIndex = i;
                rank = 1;
                i = 4;
            }
        }

        if (rank == 1) {
            for (int i = pairIndex + 2; i < 4; i++) {
                if (cards[i].getRank() == cards[i + 1].getRank())
                    rank = 2;
            }
        }
        return rank;
    }

    /**
     * Three of a kind, also known as trips or a set, is a hand that contains three cards of one
     * rank and two cards of two other ranks (the kickers).
     *
     * It ranks below a straight and above two pair.
     *
     * This also check for a full house since it's just and extension
     *
     * @param cards
     * @param rank
     * @return
     */
    private int checkThreeOfaKind(Card[] cards, int rank) {
        for (int i = 0; i < 3; i++) {
            if (cards[i].getRank() == cards[i + 1].getRank() && cards[i + 1].getRank() == cards[i + 2].getRank()) {
                rank = 3;

                // check for a full house
                if (i == 0 && cards[3].getRank() == cards[4].getRank()
                        || i == 2 && cards[0].getRank() == cards[1].getRank())
                    rank = 6;
            }
        }
        return rank;
    }

    /**
     * A straight is a hand that contains five cards of sequential rank, not all of the same suit.
     *
     * It ranks below a flush and above three of a kind
     *
     * @param cards
     * @param rank
     * @return
     */
    private int checkStraight(Card[] cards, int rank) {
        if (rank == 0) {
            if ((cards[4].getValue() - cards[0].getValue() == 4) ||
                    (cards[3].getValue() - cards[0].getValue() == 3 &&
                            cards[4].getValue() == 14 && cards[0].getValue() == 2)) {
                rank = 4;
            }
        }
        return rank;
    }

    /**
     * A flush is a hand that contains five cards all of the same suit, not all of sequential rank.
     *
     * It ranks below a full house and above a straight
     *
     * @param cards
     * @param rank
     * @return
     */
    private int checkFlush(Card[] cards, int rank) {
        boolean flush;
        if (rank == 0 || rank == 4) {
            flush = true;
            for (int i = 0; i < 4; i++)
                if (cards[i].getSuit() != cards[i + 1].getSuit())
                    flush = false;
            if (flush && rank == 4)
                rank = 8; // straight flush!
            else if (flush)
                rank = 5;
        }
        return rank;
    }

    /**
     * Four of a kind, also known as quads, is a hand that contains four cards of one rank and
     * one card of another rank (the kicker).
     *
     * It ranks below a straight flush and above a full house
     *
     * @param cards
     * @param rank
     * @return
     */
    private int checkFourOfaKind(Card[] cards, int rank) {
        for (int i = 0; i < 2; i++) {
            if (cards[i].getRank() == cards[i + 1].getRank()
                    && cards[i + 1].getRank() == cards[i + 2].getRank()
                    && cards[i + 2].getRank() == cards[i + 3].getRank()) {
                rank = 7;
            }
        }
        return rank;
    }

    /**
     * Sort cards according to hand value
     *
     * @param hand
     * @return array of sorted cards
     */
    private Card[] sortCards(List<Card> hand) {
        return hand.stream()
            .sorted((a, b) -> a.getValue() - b.getValue())
            .toArray(Card[]::new);
    }

    /**
     * @param rank
     * @return
     */
    private static String rankToName(int rank) {
        switch (rank) {
        case 0:
            return "High Card";
        case 1:
            return "Pair";
        case 2:
            return "Two Pair";
        case 3:
            return "Three of a Kind";
        case 4:
            return "Straight";
        case 5:
            return "Flush";
        case 6:
            return "Full House";
        case 7:
            return "Four of a Kind";
        case 8:
            return "Straight Flush";
        default:
            return "Error";
        }
    }
}
