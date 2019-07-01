package cards;

public class Card {

    CardSuit suit;
    CardRank rank;
    int power;

    public Card(CardSuit suit, CardRank rank){
        this.rank = rank;
        this.suit = suit;
        this.power = rank.value + suit.value;
    }


    @Override
    public String toString() {
        return String.format( "Card name: %s of %s; Card power: %d",this.rank, this.suit, this.power);
    }
}
