import java.util.Scanner;

public class Savings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double dohod = Double.parseDouble(scan.nextLine());
        int mount = Integer.parseInt(scan.nextLine());
        double money = Double.parseDouble(scan.nextLine());

        double razhodi = dohod * 0.30;

        double ostavat = dohod - (money + razhodi);
        double all = ostavat * (1.0 * mount);

        System.out.printf("She can save %.2f%%%n", (ostavat / dohod) * 100);
        System.out.printf("%.2f", all);
    }
}
