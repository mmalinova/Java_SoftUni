import java.util.Scanner;

public class AlcoholMarket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double price = Double.parseDouble(scan.nextLine());
        double bear = Double.parseDouble(scan.nextLine());
        double wine = Double.parseDouble(scan.nextLine());
        double rakia = Double.parseDouble(scan.nextLine());
        double whiskey = Double.parseDouble(scan.nextLine());
        double priceRakia = price / 2;
        double priceWine = priceRakia - (priceRakia * 0.4);
        double priceBear = priceRakia - (priceRakia * 0.8);
        double sumR = rakia * priceRakia;
        double sumW = wine * priceWine;
        double sumB = bear * priceBear;
        double sumWh = whiskey * price;
        double money = sumR + sumW + sumB + sumWh;
        System.out.printf("%.2f", money);
    }
}
