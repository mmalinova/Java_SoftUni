import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        double sum = 0.0;

        while (!input.equals("Start"))
        {
            double money = Double.parseDouble(input);
            if (money == 0.1 || money == 0.2 || money == 0.5 || money == 1 || money == 2) {
                sum += money;
            }
            else
                System.out.printf("Cannot accept %.2f%n", money);
            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!input.equals("End"))
        {
            switch (input)
            {
                case "Nuts":
                    if (sum < 2.0)
                        System.out.println("Sorry, not enough money");
                    else {
                        System.out.printf("Purchased %s%n", input);
                        sum -= 2.0;
                    }
                    break;
                case "Water":
                    if (sum < 0.7)
                        System.out.println("Sorry, not enough money");
                    else {
                        System.out.printf("Purchased %s%n", input);
                        sum -= 0.7;
                    }
                    break;
                case "Crisps":
                    if (sum < 1.5)
                        System.out.println("Sorry, not enough money");
                    else {
                        System.out.printf("Purchased %s%n", input);
                        sum -= 1.5;
                    }
                    break;
                case "Soda":
                    if (sum < 0.8)
                        System.out.println("Sorry, not enough money");
                    else {
                        System.out.printf("Purchased %s%n", input);
                        sum -= 0.8;
                    }
                    break;
                case "Coke":
                    if (sum < 1.0)
                        System.out.println("Sorry, not enough money");
                    else {
                        System.out.printf("Purchased %s%n", input);
                        sum -= 1.0;
                    }
                    break;
                default:
                    System.out.println("Invalid product");
            }
            input = scan.nextLine();
        }
        System.out.printf("Change: %.2f%n", sum);
    }
}
