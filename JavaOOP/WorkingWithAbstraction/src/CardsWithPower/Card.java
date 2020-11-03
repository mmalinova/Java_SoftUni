package CardsWithPower;

public class Card {
    private int power;

    public Card() {
        this.power = 0;
    }

    public int getPower(String rank, String suit) {
        return RankPowers.valueOf(rank).getPower() + SuitPowers.valueOf(suit).getPower();
    }
}
