import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int num = Integer.parseInt(scan.nextLine());
        int cakes = Integer.parseInt(scan.nextLine());
        int cor = Integer.parseInt(scan.nextLine());
        int pancakes = Integer.parseInt(scan.nextLine());
        int priceCakes = cakes * 45;
        double priceCor = cor * 5.80;
        double pricePan = pancakes * 3.20;
        double sum = (priceCakes + priceCor + pricePan) * num;
        double money = sum * days;
        double res = money / 8;
        System.out.printf("%.2f", money - res);
    }
}
