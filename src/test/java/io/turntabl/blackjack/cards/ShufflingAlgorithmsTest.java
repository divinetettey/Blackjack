package io.turntabl.blackjack.cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class ShufflingAlgorithmsTest {

    @Mock
    Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
        deck.initialize();
    }

    @Test
    void testCanShuffleWithOverHandAlgorithm(){
        Stack<Card> oldCards = deck.getCards();
        Stack<Card> shuffledCards = ShufflingAlgorithms.OVERHAND.shuffle(deck.getCards());

        assertFalse(oldCards.equals(shuffledCards));
    }

    @Test
    void testCanShuffleWithRiffleAlgorithm() {
        Stack<Card> oldCards = deck.getCards();
        Stack<Card> shuffledCards = ShufflingAlgorithms.RIFFLE.shuffle(deck.getCards());

        assertEquals(oldCards, shuffledCards);
    }

    @Test
    void testCanShuffleWithFisherYatesAlgorithm() {
        Stack<Card> shuffledCards = ShufflingAlgorithms.FISHER_YATES.shuffle(deck.getCards());

        assertEquals(deck.getCards(), shuffledCards);
    }
}