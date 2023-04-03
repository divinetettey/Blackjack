package io.turntabl.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Deck cardDeck;
    private List<Player> playerList;
    private static final int DEFAULT_NUM_OF_PLAYERS = 3;
    private static final int MAX_NUM_OF_PLAYERS = 6;

    private static final int MAX_SCORE = 21;

    private int numberOfPlayers;
    private boolean isGameEnd = false;

    public Game(int numberOfPlayers) {
        //this.NUM_OF_PLAYERS = NUM_OF_PLAYERS;
        this.numberOfPlayers = numberOfPlayers;
        if(numberOfPlayers <= 1 || numberOfPlayers > MAX_NUM_OF_PLAYERS) {
            //we cannot start game here
            throw new IllegalArgumentException("Number of players must be between 2 and " + MAX_NUM_OF_PLAYERS);
        }
        cardDeck = new Deck();
        cardDeck.initialize();

        setupPlayers();

        //Do not deal hands on game initialization, dealHands should be called when game starts
        //dealHands();
    }

    public void setupPlayers(){
        for(int i = 1; i <= this.numberOfPlayers; i++){
            Player player = new Player("Player "+i);
            playerList.add(player);
        }
    }

    /**
     * deal initial two cards to players
     *
     */
    public void dealHands() {
        for(int i = 0; i < playerList.size(); i++){

            for(int j = 0; j < 2; j++){
                playerList.get(i).addCard(
                        cardDeck.getCards().pop()
                );
            }

            playerList.get(i).checkStatus();
        }

    }

    public void play(){
        dealHands();
        boolean allPlayersHaveStickStatus = true;
        int highScore = 0;
        while(!cardDeck.getCards().empty()){
            newRound();
            for(Player player : playerList){

                //Check all players have stick
                if(player.getStatus() != PlayerStatus.STICK){
                    allPlayersHaveStickStatus = false;
                    isGameEnd = true;
                    //break out of the loop and end game
                    break;
                }
                int playerTotal = player.getValueOfHand();
                //check for winner
                if(playerTotal > highScore && playerTotal <= MAX_SCORE) {
                    //Set the player hasWon to true
                    highScore = playerTotal;
                    player.setHasWon(true);
                    isGameEnd = true;
                }

            }
        }

        if(allPlayersHaveStickStatus) {
            System.out.println("All players have a stick. Game ended " + isGameEnd);
        }


    }


    public void newRound(){
        //check player status
        for(Player player : playerList){
            if(player.getStatus() == PlayerStatus.BUST){
                System.out.println(player.getName() + " goes bust with total value of hand " + player.getValueOfHand());
                playerList.remove(player);
            } else if(player.getStatus() == PlayerStatus.HIT){
                System.out.println(player.getName() + " goes hit with total value of hand " + player.getValueOfHand());
                player.addCard(cardDeck.getCards().pop());
                System.out.println(player.getName() + " handed a new card " + player.getHand().toString());
            } else if(player.getStatus() == PlayerStatus.STICK){
                System.out.println(player.getName() + " goes stick with total value of hand " + player.getValueOfHand());
            }


        }
    }

    public void getWinner() {

    }
}
