package io.turntabl.blackjack.players;

import io.turntabl.blackjack.cards.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Player {

    private String name;
    private List<Card> hand;
    private int valueOfHand = 0;
    private boolean hasWon = false;
    private PlayerStatus status = null;

    private String strategy;

    public Player(String name, List<Card> hand) {
        this.name = name;
        this.hand = hand;
    }

    public Player(String name, String strategy){
        this.name = name;
        this.strategy = strategy;
    }

    /**
     * add new card to the players hand
     *
     * @param card
     */
    public void addCard(Card card) {
        if(this.hand == null) {
            hand = new ArrayList<>();
        }

        hand.add(card);
        valueOfHand += card.getRank().getRank();
        checkStatus();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public int getValueOfHand() {
        return valueOfHand;
    }

    public void setValueOfHand(int valueOfHand) {
        this.valueOfHand = valueOfHand;
    }

    public boolean isHasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }


    /**
     * check the status of the player
     * use a strategy to assign as specific strategy to the player
     */
    public void checkStatus(){
        if(hand.size() >= 2){
            switch (strategy) {
                case "always-stick" -> status = PlayerStatus.STICK;
                case "always-hit" ->
                        status = valueOfHand < 21 ? PlayerStatus.HIT : PlayerStatus.BUST; //to avoid infinite loop
                case "risk-calculator" -> calculateRisk();
                default -> defaultStrategy();
            }
        }
    }

    /**
     * calculate a risky status change for the user
     */
    private void calculateRisk() {
        //if hand is closer to 21 by 3 we stick
        //if hand is less 10, we hit
        if(21 - valueOfHand <= 3){
            status = PlayerStatus.STICK;
        } else if (valueOfHand <= 10){
            status = PlayerStatus.HIT;
        } else {
            status = PlayerStatus.STICK;
        }
    }

    /**
     * default strategy for the player
     */
    private void defaultStrategy(){
        if(valueOfHand < 17){
            status  = PlayerStatus.HIT;
        }  else if(valueOfHand < 21){
            status = PlayerStatus.STICK;
        } else if(valueOfHand == 21) {
            status = PlayerStatus.WON;
        } else {
            status = PlayerStatus.BUST;
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                ", valueOfHand=" + valueOfHand +
                ", hasWon=" + hasWon +
                ", status=" + status +
                ", strategy='" + strategy + '\'' +
                '}';
    }
}