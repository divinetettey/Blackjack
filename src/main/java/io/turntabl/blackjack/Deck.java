package io.turntabl.blackjack;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> cards;
    private String shuffleType;

    public Deck(){
        cards = new Stack<>();
    }

    public  Deck(Stack<Card> cards){
        this.cards = cards;
    }

    public Deck(String shuffleType){
        this.shuffleType = shuffleType;
        cards = new Stack<>();
    }

    public void shuffle(){
        //TODO: Implement different shuffle types is supplied
        Collections.shuffle(cards);
    }


    public Stack<Card> getCards() {
        return cards;
    }

    public void setCards(Stack<Card> cards) {
        this.cards = cards;
    }



    public void initialize() {
        for(Suit suit : Suit.values()){
            for(Rank rank: Rank.values()){
                Card card =  new Card(suit, rank);
                this.cards.add(card);
            }
        }

        shuffle();
    }

    public String getShuffleType() {
        return shuffleType;
    }

    public void setShuffleType(String shuffleType) {
        this.shuffleType = shuffleType;
    }

    @Override
    public String toString() {
        return cards.toString();
    }

}
