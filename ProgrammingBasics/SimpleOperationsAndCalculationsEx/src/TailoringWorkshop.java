import java.util.Scanner;

public class TailoringWorkshop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        double lenght = Double.parseDouble(scan.nextLine());
        double width = Double.parseDouble(scan.nextLine());
        double tableclothsArea = number * (lenght + 2 * 0.30) * (width + 2 * 0.30);
        double coachArea = number * (lenght / 2) * (lenght / 2);
        double usd = (tableclothsArea * 7) + (coachArea * 9);
        double bgn = usd * 1.85;
        System.out.printf("%.2f USD%n", usd);
        System.out.printf("%.2f BGN", bgn);
    }
}
