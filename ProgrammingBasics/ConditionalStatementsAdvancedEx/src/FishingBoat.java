import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int budget = Integer.parseInt(scan.nextLine());
        String sezon = scan.nextLine();
        int number = Integer.parseInt(scan.nextLine());

        double price = 0;

        switch (sezon) {
            case "Spring":
                price = 3000;
                 break;
            case "Summer":
                price = 4200;
                break;
            case "Autumn":
                price = 4200;
                break;
            case "Winter":
                price = 2600;
                break;
        }

        if (number <= 6)
            price *= 0.90;
        else if (number > 7 && number <= 11 || number == 7)
            price *= 0.85;
        else if (number > 12)
            price *= 0.75;
        if ((number % 2 == 0) && !(sezon.equals("Autumn")))
            price *= 0.95;

        if (budget >= price)
            System.out.printf("Yes! You have %.2f leva left.", budget - price);
        else
            System.out.printf("Not enough money! You need %.2f leva.", price - budget);
    }
}
