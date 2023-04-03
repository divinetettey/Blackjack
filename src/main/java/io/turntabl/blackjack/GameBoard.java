package io.turntabl.blackjack;

public class GameBoard {
    public static void main(String[] args){
        System.out.println("Welcome To Blackjack");

        Deck deck = new Deck();
        deck.initialize();

        System.out.println(deck.toString());
    }
}
