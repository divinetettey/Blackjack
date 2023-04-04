package io.turntabl.blackjack;

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;

        setSuitRank();
    }

    public void setSuitRank() {
        if(this.rank == Rank.ACE){
            this.rank.setRank(11);
        }else if(this.rank == Rank.JACK || this.rank == Rank.QUEEN || this.rank == Rank.KING){
            this.rank.setRank(10);
        }
    }

    public void setSuit(Suit suit){
        this.suit = suit;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }
}
