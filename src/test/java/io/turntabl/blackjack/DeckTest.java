package io.turntabl.blackjack;


import java.util.Stack;

public class DeckTest extends TestCase {

    @Mock
    Deck deck = new Deck();

    @BeforeClass
    public void setup() {
        deck.initialize();
    }

    @Test
    public void testDeckSize() {
        System.out.println(deck.getCards().toString());
        Assert.assertEquals(52, deck.getCards().size());
    }

    public void testShuffle() {
        System.out.println(deck.getCards().toString());
        Card cardBeforeShuffle = deck.getCards().firstElement();
        deck.shuffle();

        Card cardAfterShuffle = deck.getCards().firstElement();
        Assert.assertNotEquals(cardBeforeShuffle, cardAfterShuffle);
    }


    @Test
    public void testHasInitializeEntireDeck() {
       Stack<Card> cardStack =  deck.getCards();


    }
}