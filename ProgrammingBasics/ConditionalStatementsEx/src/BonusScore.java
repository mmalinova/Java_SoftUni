import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        double bonus = 0.0;

        if (number <= 100) {
            bonus = 5.0;
        }
        else if (number > 100 && number <= 1000) {
            bonus = 0.20 * number;
        }
        else if (number > 1000) {
            bonus = 0.10 * number;
        }
        if (number % 2 == 0) {
            bonus = bonus + 1;
        }
        else if (number % 10 == 5) {
            bonus = bonus + 2;
        }

        double points = number + bonus;

        System.out.println(bonus);
        System.out.println(points);
    }
}
