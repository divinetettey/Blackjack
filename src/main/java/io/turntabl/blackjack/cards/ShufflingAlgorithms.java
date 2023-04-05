package io.turntabl.blackjack.cards;

import java.util.Stack;

public enum ShufflingAlgorithms {
    OVERHAND{
        @Override
        public Stack<Card> shuffle(Stack<Card> deckCards){
            int rounds = (int) (Math.random() * 1000);
            while(rounds > 0){
                Card card = deckCards.firstElement();
                deckCards.remove(card);
                deckCards.push(card);

                --rounds;
            }

            return deckCards;
        }
    },
    RIFFLE {
        @Override
        public Stack<Card> shuffle(Stack<Card> deckCards){
            return deckCards;
        }
    },
    FISHER_YATES{
        @Override
        public Stack<Card> shuffle(Stack<Card> deckCards){
            return deckCards;
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
