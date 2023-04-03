package io.turntabl.blackjack;


import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Stack;

public class DeckTest extends TestCase {

    @Mock
    Deck deck = new Deck();

    @BeforeEach
    public void setup() {
        deck.initialize();
    }

    @Test
    public void testDeckSize() {
        Assert.assertEquals(52, deck.getCards().size());
    }

    @Test
    public void testShuffle() {
        Card cardBeforeShuffle = deck.getCards().firstElement();
        deck.shuffle();

        Card cardAfterShuffle = deck.getCards().firstElement();
        Assert.assertNotSame(cardBeforeShuffle, cardAfterShuffle);
    }

}