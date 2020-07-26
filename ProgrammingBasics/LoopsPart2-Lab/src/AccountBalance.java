import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            double sum = Double.parseDouble(scan.nextLine());
            if (sum < 0) {
                System.out.println("Invalid operation!");
                break;
            }
            System.out.printf("Increase: %.2f%n", sum);
            total += sum;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
