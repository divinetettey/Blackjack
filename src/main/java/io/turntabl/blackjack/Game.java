package io.turntabl.blackjack;

import io.turntabl.blackjack.cards.Deck;
import io.turntabl.blackjack.players.Player;
import io.turntabl.blackjack.players.PlayerStatus;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Deck cardDeck;
    private List<Player> playerList;
    private static final int MAX_NUM_OF_PLAYERS = 6;

    private static final int WINNING_SCORE = 21;

    private final int initialNumOfPlayers;
    private boolean gameEnd = false;

    private Player winner = null;

    private int numRounds = 1;

    /**
     * initialize a new game with number fo players and a list of strategies
     * @param numberOfPlayers
     * @param strategyList
     */
    public Game(int numberOfPlayers, List<String> strategyList) {
        this.initialNumOfPlayers = numberOfPlayers;
        if(numberOfPlayers <= 1 || numberOfPlayers > MAX_NUM_OF_PLAYERS) {
            //we cannot start game here
            throw new IllegalArgumentException("Number of players must be between 2 and " + MAX_NUM_OF_PLAYERS);
        }
        cardDeck = new Deck();
        cardDeck.initialize();

        setupPlayers(strategyList);
    }

    /**
     * setup new players. passing a strategy to the players.
     * @param strategyList
     */
    public void setupPlayers(List<String> strategyList){
        if(playerList == null){
            playerList = new ArrayList<>();
        }

        for(int i = 1; i <= this.initialNumOfPlayers; i++){
            String strategy = strategyList.isEmpty() ? "default" : strategyList.get(i-1);

            Player player = new Player("Player "+i, strategy);
            playerList.add(player);
        }
    }

    /**
     * deal initial two cards to each player
     */
    public void dealHands() {
        for (Player player : playerList) {
            for (int j = 0; j < 2; ++j) {
                player.addCard(
                        cardDeck.getCards().pop()
                );
            }
        }
    }

    /**
     * play game
     */
    public void play(){
        System.out.println("ROUND "+numRounds + "\n***********************************************");
        dealHands();
        applyRules();


        while(!gameEnd ){
            ++numRounds;
            System.out.println("ROUND "+numRounds + "\n********************************************");
            applyRules();
        }


        //we have winner
        if(winner != null){
            System.out.println(winner.getName() + " has won with a hand of "+winner.getValueOfHand());
        }
    }

    /**
     * apply rules to the game
     */
    public void applyRules(){
        if(playerList.size() == 1){
            System.out.println("Only "+playerList.get(0).getName()+" is left in the game");
            gameEnd = true;
            return;
        }

        List<Player> stickPlayers = new ArrayList<>();

        for(Player player : playerList){
            if(player.getValueOfHand() == WINNING_SCORE) {
                //Set the player hasWon to true
                player.setHasWon(true);
                gameEnd = true;
                winner = player;
                break;
            }

            //Check all players have stick
            if(player.getStatus() == PlayerStatus.STICK) {
                stickPlayers.add(player);
            }
        }

        if(stickPlayers.size() == playerList.size() && this.winner == null){
            gameEnd = true;
            System.out.println("Remaining "+stickPlayers.size() + " have stick \n Game Ends");
            return;
        }

        newRound();
    }

    /**
     * start a new round of the game play
     */
    public void newRound(){
        //check player status
        List<Player> playersGoneBust = new ArrayList<>();

        for(Player player : playerList){
            System.out.println(player.getName() + " has initial total hand of "+ player.getValueOfHand() + " with cards "+player.getHand().toString());

            if(player.getStatus() == PlayerStatus.BUST){
                System.out.println(player.getName() + " goes bust with total value of hand " + player.getValueOfHand());
                playersGoneBust.add(player);

            } else if(player.getStatus() == PlayerStatus.HIT){
                System.out.println(player.getName() + " goes hit with total value of hand " + player.getValueOfHand());
                player.addCard(cardDeck.getCards().pop());

                System.out.println(player.getName() + " handed a new card " + player.getHand().toString() +" value of hand "+player.getValueOfHand());
            } else if(player.getStatus() == PlayerStatus.STICK){
                System.out.println(player.getName() + " goes stick with total value of hand " + player.getValueOfHand());
            }
        }

        playerList.removeAll(playersGoneBust); //remove all players that have gone bust before the next iteration of our game
    }


    public Deck getCardDeck() {
        return cardDeck;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public int getInitialNumOfPlayers() {
        return initialNumOfPlayers;
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public int getNumRounds() {
        return numRounds;
    }

}