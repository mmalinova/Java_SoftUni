import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String flower = scan.nextLine();
        int number = Integer.parseInt(scan.nextLine());
        int budget = Integer.parseInt(scan.nextLine());

        double price = 0;

        switch (flower){
            case "Roses":
                if (number > 80)
                    price = (number * 5) * 0.9;
                else
                    price = (number * 5);
                break;
            case "Dahlias":
                if (number > 90)
                    price = (number * 3.8) * 0.85;
                else
                    price = (number * 3.8);
                break;
            case "Tulips":
                if (number > 80)
                    price = (number * 2.8) * 0.85;
                else
                    price = (number * 2.8);
                break;
            case "Narcissus":
                if (number < 120) {
                    price = (number * 3);
                    price += (price * 0.15);
                }
                else
                    price = (number * 3);
                break;
            case "Gladiolus":
                if (number < 80) {
                    price = (number * 2.5);
                    price += (price * 0.20);
                }
                else
                    price = (number * 2.5);
                break;
        }
        if (budget >= price)
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", number, flower, budget - price);
        else if (budget < price)
            System.out.printf("Not enough money, you need %.2f leva more.", price - budget);
    }
}
