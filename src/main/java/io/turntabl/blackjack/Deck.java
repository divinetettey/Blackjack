package io.turntabl.blackjack;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> cards;

    private Deck(){
        cards = new Stack<>();
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }
}
