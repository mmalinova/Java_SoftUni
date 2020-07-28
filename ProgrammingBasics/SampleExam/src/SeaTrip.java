import java.util.Scanner;

public class SeaTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double moneyForEat = Double.parseDouble(scan.nextLine()) * 3;
        double moneyForSouvenirs = Double.parseDouble(scan.nextLine()) * 3;
        double moneyForHotel = Double.parseDouble(scan.nextLine());

        double liters = (420 * 1.0 / 100)* 7;
        double moneyForLiters = liters * 1.85;

        double moneyForFirst = moneyForHotel * 0.9;
        double moneyForSecond = moneyForHotel * 0.85;
        double moneyForThird = moneyForHotel * 0.80;

        double sum = moneyForEat + moneyForSouvenirs + moneyForLiters + moneyForFirst + moneyForSecond + moneyForThird;

        System.out.printf("Money needed: %.2f", sum);
    }
}
