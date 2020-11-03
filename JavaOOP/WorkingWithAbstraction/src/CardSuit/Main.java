package CardSuit;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Suits:");
        for (CardSuit card : CardSuit.values()) {
            System.out.println(card.toString());
        }
    }
}
