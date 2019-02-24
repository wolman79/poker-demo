package io.advance.poker.domain;

import java.util.List;

/**
 * Operations for evaluating and categorizing a set of cards
 */
public interface HandEvaluator {
    HandRank evaluate(List<Card> hand);
}
