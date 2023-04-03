package io.turntabl.blackjack;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {
    private Stack<Card> cards;

    public Deck(){
        cards = new Stack<>();
    }

    public Deck(Stack<Card> cards){
        this.cards = cards;
    }
    public void shuffle(){
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
    }

    @Override
    public String toString() {
        return cards.toString();
    }

}
