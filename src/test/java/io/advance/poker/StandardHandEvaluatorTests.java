package io.advance.poker;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.advance.poker.domain.Card;
import io.advance.poker.domain.HandEvaluator;
import io.advance.poker.domain.HandRank;
import io.advance.poker.domain.Rank;
import io.advance.poker.domain.Suit;
import io.advance.poker.standard.FiftyTwoCardDeck;
import io.advance.poker.standard.StandardHandEvaluator;

public class StandardHandEvaluatorTests {

    @Test
    void testHighCard() {
        List<Card> hand = Arrays.asList(
                c(Rank.TWO, Suit.SPADE),
                c(Rank.THREE, Suit.DIAMOND),
                c(Rank.FIVE, Suit.HEART),
                c(Rank.SEVEN, Suit.CLUB),
                c(Rank.NINE, Suit.HEART));

        HandEvaluator evaluator = new StandardHandEvaluator();
        HandRank rank = evaluator.evaluate(hand);
        Assertions.assertEquals(0, rank.getValue());
        Assertions.assertEquals(9, rank.getHighCard());
        Assertions.assertEquals("High Card", rank.getDescription());
    }

    @Test
    void testPair() {
        List<Card> hand = Arrays.asList(
                c(Rank.TWO, Suit.SPADE),
                c(Rank.TWO, Suit.DIAMOND),
                c(Rank.FOUR, Suit.HEART),
                c(Rank.FIVE, Suit.CLUB),
                c(Rank.SIX, Suit.HEART));

        HandEvaluator evaluator = new StandardHandEvaluator();
        HandRank rank = evaluator.evaluate(hand);
        Assertions.assertEquals(1, rank.getValue());
        Assertions.assertEquals(6, rank.getHighCard());
        Assertions.assertEquals("Pair", rank.getDescription());
    }

    @Test
    void testTwoPair() {
        List<Card> hand = Arrays.asList(
                c(Rank.TWO, Suit.SPADE),
                c(Rank.TWO, Suit.DIAMOND),
                c(Rank.FOUR, Suit.HEART),
                c(Rank.FOUR, Suit.CLUB),
                c(Rank.SIX, Suit.HEART));

        HandEvaluator evaluator = new StandardHandEvaluator();
        HandRank rank = evaluator.evaluate(hand);
        Assertions.assertEquals(2, rank.getValue());
        Assertions.assertEquals(6, rank.getHighCard());
        Assertions.assertEquals("Two Pair", rank.getDescription());
    }

    @Test
    void testThreeOfaKind1() {
        List<Card> hand = Arrays.asList(
                c(Rank.TWO, Suit.SPADE),
                c(Rank.TWO, Suit.DIAMOND),
                c(Rank.TWO, Suit.HEART),
                c(Rank.FOUR, Suit.CLUB),
                c(Rank.FIVE, Suit.HEART));

        HandEvaluator evaluator = new StandardHandEvaluator();
        HandRank rank = evaluator.evaluate(hand);
        Assertions.assertEquals(3, rank.getValue());
        Assertions.assertEquals(5, rank.getHighCard());
        Assertions.assertEquals("Three of a Kind", rank.getDescription());
    }

    @Test
    void testThreeOfaKind2() {
        List<Card> hand = Arrays.asList(
                c(Rank.ACE, Suit.SPADE),
                c(Rank.TWO, Suit.DIAMOND),
                c(Rank.FIVE, Suit.SPADE),
                c(Rank.FIVE, Suit.CLUB),
                c(Rank.FIVE, Suit.HEART));

        HandEvaluator evaluator = new StandardHandEvaluator();
        HandRank rank = evaluator.evaluate(hand);
        Assertions.assertEquals(3, rank.getValue());
        Assertions.assertEquals(14, rank.getHighCard());
        Assertions.assertEquals("Three of a Kind", rank.getDescription());
    }

    @Test
    void testStraight() {
        List<Card> hand = Arrays.asList(
                c(Rank.TWO, Suit.SPADE),
                c(Rank.THREE, Suit.DIAMOND),
                c(Rank.FOUR, Suit.HEART),
                c(Rank.FIVE, Suit.CLUB),
                c(Rank.SIX, Suit.CLUB));

        HandEvaluator evaluator = new StandardHandEvaluator();
        HandRank rank = evaluator.evaluate(hand);
        Assertions.assertEquals(4, rank.getValue());
        Assertions.assertEquals(6, rank.getHighCard());
        Assertions.assertEquals("Straight", rank.getDescription());
    }

    @Test
    void testFlush() {
        List<Card> hand = Arrays.asList(
                c(Rank.TWO, Suit.DIAMOND),
                c(Rank.FOUR, Suit.DIAMOND),
                c(Rank.SIX, Suit.DIAMOND),
                c(Rank.EIGHT, Suit.DIAMOND),
                c(Rank.ACE, Suit.DIAMOND));

        HandEvaluator evaluator = new StandardHandEvaluator();
        HandRank rank = evaluator.evaluate(hand);
        Assertions.assertEquals(5, rank.getValue());
        Assertions.assertEquals(14, rank.getHighCard());
        Assertions.assertEquals("Flush", rank.getDescription());
    }

    @Test
    void testFullHouse() {
        List<Card> hand = Arrays.asList(
                c(Rank.TWO, Suit.DIAMOND),
                c(Rank.TWO, Suit.CLUB),
                c(Rank.TWO, Suit.HEART),
                c(Rank.ACE, Suit.SPADE),
                c(Rank.ACE, Suit.DIAMOND));

        HandEvaluator evaluator = new StandardHandEvaluator();
        HandRank rank = evaluator.evaluate(hand);
        Assertions.assertEquals(6, rank.getValue());
        Assertions.assertEquals(14, rank.getHighCard());
        Assertions.assertEquals("Full House", rank.getDescription());
    }

    @Test
    void testFourOfaKind() {
        List<Card> hand = Arrays.asList(
                c(Rank.TWO, Suit.CLUB),
                c(Rank.TWO, Suit.DIAMOND),
                c(Rank.TWO, Suit.HEART),
                c(Rank.TWO, Suit.SPADE),
                c(Rank.TEN, Suit.DIAMOND));

        HandEvaluator evaluator = new StandardHandEvaluator();
        HandRank rank = evaluator.evaluate(hand);
        Assertions.assertEquals(7, rank.getValue());
        Assertions.assertEquals(10, rank.getHighCard());
        Assertions.assertEquals("Four of a Kind", rank.getDescription());
    }

    @Test
    void testStraightFlush() {
        List<Card> hand = Arrays.asList(
                c(Rank.TEN, Suit.HEART),
                c(Rank.JACK, Suit.HEART),
                c(Rank.QUEEN, Suit.HEART),
                c(Rank.KING, Suit.HEART),
                c(Rank.ACE, Suit.HEART));

        HandEvaluator evaluator = new StandardHandEvaluator();
        HandRank rank = evaluator.evaluate(hand);
        Assertions.assertEquals(8, rank.getValue());
        Assertions.assertEquals(14, rank.getHighCard());
        Assertions.assertEquals("Straight Flush", rank.getDescription());
    }

    /**
     * Convenience method
     *
     * @param r
     * @param s
     * @return
     */
    private Card c(Rank r, Suit s) {
        return FiftyTwoCardDeck.newCard(r, s);
    }

}
