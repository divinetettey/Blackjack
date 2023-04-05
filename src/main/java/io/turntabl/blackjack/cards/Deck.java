package io.turntabl.blackjack.cards;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> cards;

    public Deck(){
        cards = new Stack<>();
    }

    public  Deck(Stack<Card> cards){
        this.cards = cards;
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


    /**
     * initialize a new deck
     */
    public void initialize() {
        for(Suit suit : Suit.values()){
            for(Rank rank: Rank.values()){
                Card card =  new Card(suit, rank);
                this.cards.add(card);
            }
        }

        shuffle();
    }

    @Override
    public String toString() {
        return cards.toString();
    }

}