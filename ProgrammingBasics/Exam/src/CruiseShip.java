import java.util.Scanner;

public class CruiseShip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String cruise = scan.nextLine();
        String cabin = scan.nextLine();
        int nights = Integer.parseInt(scan.nextLine());

        double sum = 0;
        double allSum = 0;

        switch (cruise) {
            case "Mediterranean":
                if (cabin.equals("standard cabin")) {
                    sum = 27.50;
                } else if (cabin.equals("cabin with balcony")) {
                    sum = 30.20;
                } else {
                    sum = 40.50;
                }
                break;
            case "Adriatic":
                if (cabin.equals("standard cabin")) {
                    sum = 22.99;
                } else if (cabin.equals("cabin with balcony")) {
                    sum = 25.00;
                } else {
                    sum = 34.99;
                }
                break;
            case "Aegean":
                if (cabin.equals("standard cabin")) {
                    sum = 23.00;
                } else if (cabin.equals("cabin with balcony")) {
                    sum = 26.60;
                } else {
                    sum = 39.80;
                }
                break;
        }
        allSum = sum * 4 * nights;
        if (nights > 7) {
            double discount = allSum * 0.25;
            allSum -= discount;
        }
        System.out.printf("Annie's holiday in the %s sea costs %.2f lv.", cruise, allSum);
    }
}
