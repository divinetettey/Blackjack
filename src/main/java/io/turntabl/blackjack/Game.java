package io.turntabl.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Deck cardDeck;
    private List<Player> playerList;
    private final int NUM_OF_PLAYERS;

    public Game(int NUM_OF_PLAYERS) {
        this.NUM_OF_PLAYERS = NUM_OF_PLAYERS;
        cardDeck = new Deck();
        cardDeck.initialize();

        setupPlayers();
        dealHands();
    }

    public void setupPlayers(){
        for(int i = 1; i <= this.NUM_OF_PLAYERS; i++){
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
        while(!cardDeck.getCards().empty()){
            newRound();

            for(Player player : playerList){

            }
        }

        //check for winner
    }

    public void newRound(){
        //check player status
        for(Player player : playerList){
            if(player.getStatus() == PlayerStatus.BUST){
                playerList.remove(player);
            } else if(player.getStatus() == PlayerStatus.HIT){
                player.addCard(cardDeck.getCards().pop());
            } else if(player.getStatus() == PlayerStatus.STICK){

            }


        }
    }

    public void getWinner() {

    }
}
