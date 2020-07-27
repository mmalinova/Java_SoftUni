import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int chemicals = Integer.parseInt(scan.nextLine());
        int markers = Integer.parseInt(scan.nextLine());
        double drug = Double.parseDouble(scan.nextLine());
        int dis = Integer.parseInt(scan.nextLine());

        double money = 0;
        money = (chemicals * 5.80) + (markers * 7.20) + (drug * 1.20);
        money -= (money * dis) / 100;

        System.out.printf("%.3f", money);
    }
}
