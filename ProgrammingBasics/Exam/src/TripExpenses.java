import java.util.Scanner;

public class TripExpenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int count = 0;
        double reminder = 0;

        for (int i = 0; i < n; i++) {
            double balance = 60 + reminder;
            String command = scan.nextLine();
            while (true) {
                if (command.equals("Day over")) {
                    System.out.printf("Money left from today: %.2f. You've bought %d products.%n", balance, count);
                    reminder = balance;
                    count = 0;
                    break;
                }
                double price = Double.parseDouble(command);
                if (price <= balance) {
                    count++;
                    balance -= price;
                }
                if (balance == 0) {
                    System.out.printf("Daily limit exceeded! You've bought %d products.%n", count);
                    count = 0;
                    break;
                }
                command = scan.nextLine();
            }
        }
    }
}
