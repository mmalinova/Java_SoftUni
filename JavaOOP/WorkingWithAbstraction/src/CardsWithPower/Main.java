package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Card card = new Card();

        String rank = scan.nextLine();
        String suit = scan.nextLine();

        int power = card.getPower(rank, suit);
        System.out.printf("Card name: %s of %s; Card power: %d%n", rank, suit, power);
    }
}
