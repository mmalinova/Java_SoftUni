package CardRank;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Ranks:");
        for (CardSuit card : CardSuit.values()) {
            System.out.println(card.toString());
        }
    }
}
