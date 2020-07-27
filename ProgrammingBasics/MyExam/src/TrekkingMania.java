import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfGroups = Integer.parseInt(scan.nextLine());

        int musala = 0, monblan = 0, kilimandjaro = 0, k2 = 0, everest = 0;
        int all = 0;
        double forMusala = 0, forMonblan = 0, forKilimandjaro = 0, forK2 = 0, forEverest = 0;

        for (int i = 0; i < numberOfGroups; i++) {
            int numberOfPeople = Integer.parseInt(scan.nextLine());
            all += numberOfPeople;
            if (numberOfPeople <= 5) {
                musala += numberOfPeople;
            } else if (numberOfPeople <= 12) {
                monblan += numberOfPeople;
            } else if (numberOfPeople <= 25) {
                kilimandjaro += numberOfPeople;
            } else if (numberOfPeople <= 40) {
                k2 += numberOfPeople;
            } else {
                everest += numberOfPeople;
            }
        }
        forMusala = (musala * 1.0/ all) * 100;
        System.out.printf("%.2f%%%n", forMusala);
        forMonblan = (monblan * 1.0/ all) * 100;
        System.out.printf("%.2f%%%n", forMonblan);
        forKilimandjaro = (kilimandjaro * 1.0/ all) * 100;
        System.out.printf("%.2f%%%n", forKilimandjaro);
        forK2 = (k2 * 1.0/ all) * 100;
        System.out.printf("%.2f%%%n", forK2);
        forEverest = (everest * 1.0/ all) * 100;
        System.out.printf("%.2f%%%n", forEverest);
    }
}
