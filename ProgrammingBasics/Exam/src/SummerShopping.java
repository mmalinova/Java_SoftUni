import java.util.Scanner;

public class SummerShopping {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        double towel = Double.parseDouble(scan.nextLine());
        int discount = Integer.parseInt(scan.nextLine());

        double sum = 0;
        double umbrella = towel * 2 / 3;
        double flipFlops = umbrella * 0.75;
        double bag = (flipFlops + towel) * 1 / 3;
        double all = 0;

        all = (towel + umbrella + flipFlops + bag) * (discount * 1.0 / 100);
        sum = (towel + umbrella + flipFlops + bag) - all;

        if (budget >= sum) {
            System.out.printf("Annie's sum is %.2f lv. She has %.2f lv. left.", sum, budget - sum);
        } else {
            System.out.printf("Annie's sum is %.2f lv. She needs %.2f lv. more.", sum, sum - budget);
        }
    }
}
