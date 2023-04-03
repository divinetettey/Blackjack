package io.turntabl.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {

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

    private boolean canPlay() {

        return false;
    }


    public void addCard(Card card) {
        if(this.hand.isEmpty()) {
            hand = new ArrayList<>();
        }
        hand.add(card);
        valueOfHand += card.getRank().getRank();
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
}
