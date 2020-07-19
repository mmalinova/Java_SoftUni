import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double price = Double.parseDouble(scan.nextLine());
        int numP = Integer.parseInt(scan.nextLine());
        int numK = Integer.parseInt(scan.nextLine());
        int numM = Integer.parseInt(scan.nextLine());
        int numMi = Integer.parseInt(scan.nextLine());
        int numKa = Integer.parseInt(scan.nextLine());

        double sum = numP * 2.60 + numK * 3 + numM * 4.10 + numMi * 8.20 + numKa * 2;

        int number = numP + numK +numM + numMi + numKa;
        double endSum = 0.0;

        if (number >= 50) {
            endSum = sum - (0.25 * sum);
        }
        else {
            endSum = sum;
        }
        double rent = 0.1 * endSum;
        double profit = endSum - rent;

        if (profit >= price) {
            System.out.printf("Yes! %.2f lv left.", profit - price);
        }
        else {
            System.out.printf("Not enough money! %.2f lv needed.", price - profit);
        }
    }
}
