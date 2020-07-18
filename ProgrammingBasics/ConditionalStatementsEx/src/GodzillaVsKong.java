import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int number = Integer.parseInt(scan.nextLine());
        double price = Double.parseDouble(scan.nextLine());

        double decor = 0.10 * budget;
        double priceForAll = number * price;
        if (number > 150) {
            priceForAll = priceForAll - (0.10 * priceForAll);
        }
        if ((priceForAll + decor) > budget) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", (priceForAll + decor) - budget);
        } else if ((priceForAll + decor) <= budget) {
            System.out.println("Action!" );
            System.out.printf("Wingard starts filming with %.2f leva left.", budget - (priceForAll + decor));
        }
    }
}
