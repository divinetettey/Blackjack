package io.turntabl.blackjack;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest extends TestCase {

    @Mock
    Game game;

    @BeforeEach
    public void setup(){
        game = new Game(3);
    }

    @Test
    public void testSetupPlayers() {
        assertEquals(3, game.getPlayerList().size());
    }

    @Test
    public void testIllegalArgumentExceptionIsThrown() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> {
            new Game(10);
        });

        String message = exception.getMessage();
        assertTrue(message.contains("Number of players must be between 2 "));
    }

    @Test
    public void testCanDealHands() {
        game.dealHands();
        Player player = game.getPlayerList().get(0);
        assertEquals(2, player.getHand().size());
    }

    @Test
    public void testNewRound() {
        int numOfPlayers = game.getInitialNumOfPlayers();
        Player player1 = game.getPlayerList().get(0);
        player1.setStatus(PlayerStatus.BUST);
        game.newRound();

        assertEquals(numOfPlayers - 1, game.getPlayerList().size());
    }

    @Test
    public void testCanPlay() {
        Player player1 = game.getPlayerList().get(1);
        player1.setValueOfHand(21);

        game.play();

        System.out.println("Num of Rounds: "+game.getNumRounds());
        assertTrue(game.isGameEnd());
    }
}