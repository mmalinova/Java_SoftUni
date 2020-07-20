import java.util.Scanner;

public class Lemonade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double lemons = Double.parseDouble(scan.nextLine());
        double sugar = Double.parseDouble(scan.nextLine());
        double water = Double.parseDouble(scan.nextLine());

        double juice = (980 * lemons) + (sugar * 0.30) + (water * 1000);
        double cups = Math.floor(juice / 150);
        double profit = cups * 1.20;

        System.out.printf("All cups sold: %.0f%n", cups);
        System.out.printf("Money earned: %.2f", profit);
    }
}
