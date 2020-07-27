import java.util.Scanner;

public class CatWalking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int minutes = Integer.parseInt(scan.nextLine());
        int number = Integer.parseInt(scan.nextLine());
        int calories = Integer.parseInt(scan.nextLine());

        int allMinutes = minutes * number;
        int burnCalories = allMinutes * 5;

        if (burnCalories >= calories / 2) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", burnCalories);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.", burnCalories);
        }
    }
}
