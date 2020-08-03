import java.util.Arrays;
import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int initialHealth = 100;
        int initialBitcoins = 0;
        int myHealth = 100;
        String[] input = scan.nextLine().split("\\|");

        for (int i = 0; i < input.length; i++) {
            String[] arrays = input[i].split("\\s+");
            String command = arrays[0];
            int number = Integer.parseInt(arrays[1]);
            switch (command) {
                case "potion":
                    int healed = myHealth; // 90
                    myHealth += number; // 120;
                    if (myHealth > initialHealth) {
                        healed = initialHealth - healed;
                        myHealth = initialHealth;

                    } else {
                        healed = number;
                    }
                    System.out.printf("You healed for %d hp.%n", healed);
                    System.out.printf("Current health: %d hp.%n", myHealth);
                    break;
                case "chest":
                    initialBitcoins += number;
                    System.out.printf("You found %d bitcoins.%n", number);
                    break;
                default:
                    myHealth -= number;
                    if (myHealth <= 0) {
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d%n", i + 1);
                        return;
                    } else {
                        System.out.printf("You slayed %s.%n", command);
                    }
            }
        }
        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d%n", initialBitcoins);
        System.out.printf("Health: %d", myHealth);
    }
}
