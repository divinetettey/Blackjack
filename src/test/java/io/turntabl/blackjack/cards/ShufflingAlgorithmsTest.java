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
        Card card = deck.getCards().peek();
        Stack<Card> shuffledCards = ShufflingAlgorithms.OVERHAND.shuffle(deck.getCards());

        deck.setCards(shuffledCards);

        Card currentFirstCard = deck.getCards().peek();
        assertNotEquals(card.getRank().getRank(),currentFirstCard.getRank().getRank());
    }
}