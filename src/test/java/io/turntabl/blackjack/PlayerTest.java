package io.turntabl.blackjack;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class PlayerTest extends TestCase {

    @Mock
    Player player;

    @Mock
    Card card;

    @BeforeEach
    public void setup() {
        player = new Player("Player 1", new ArrayList<>());
        card = new Card( mock(Suit.class), mock(Rank.class));
    }

    @Test
    public void testPlayerCanBeCreatedSuccessfully() {
        Player newPlayer = new Player("Player 2", new ArrayList<>());
        Assert.assertEquals(0, newPlayer.getHand().size());
        Assert.assertFalse(newPlayer.isHasWon());
        Assert.assertNull(newPlayer.getStatus());
        Assert.assertEquals(0, newPlayer.getValueOfHand());
    }

    @Test
    public void testCanAddCardSuccessfully() {
        player.addCard(card);

        Assert.assertNotSame(0,player.getHand().size());
        Assert.assertEquals(card.getRank().getRank(), player.getValueOfHand());
    }

}