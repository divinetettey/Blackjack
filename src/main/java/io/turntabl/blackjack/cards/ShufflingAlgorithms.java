package io.turntabl.blackjack.cards;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public enum ShufflingAlgorithms {
    OVERHAND{
        @Override
        public Stack<Card> shuffle(Stack<Card> deckCards){
            int rounds = (int) (Math.random() * 1000);
            while(rounds > 0){
                Card card = deckCards.firstElement();
                deckCards.remove(card);
                deckCards.addElement(card);
                --rounds;
            }

            return deckCards;
        }
    },
    RIFFLE {
        @Override
        public Stack<Card> shuffle(Stack<Card> deckCards){
            Stack<Card> leftHand = new Stack<>();
            for(int i  = 0; i < 26; i++){
                leftHand.push(deckCards.pop());
            }

            Stack<Card> shuffled  = new Stack<>();
            while(!leftHand.empty() && !deckCards.empty()){
                shuffled.push(leftHand.pop());
                shuffled.push(deckCards.pop());
            }

            return shuffled;
        }

    },
    FISHER_YATES{
        @Override
        public Stack<Card> shuffle(Stack<Card> deckCards){
            Stack<Card> newDeck =  new Stack<>();

            for(int i = 0; i < deckCards.size();  i++){
                int random = (int) (Math.random() * deckCards.size());
                Card card = deckCards.get(random);
                newDeck.push(card);
                deckCards.remove(card);
            }
            return newDeck;
        }
    };

    private String key;

    public String getKey(){
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    /**
     * shuffle the deck
     * @param deckCards
     * @return
     */
    public abstract  Stack<Card> shuffle(Stack<Card> deckCards);
}
