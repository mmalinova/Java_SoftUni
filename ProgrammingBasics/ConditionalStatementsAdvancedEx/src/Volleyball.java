import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String year = scan.nextLine();
        int p = Integer.parseInt(scan.nextLine()); // broi praznici v godinata
        int h = Integer.parseInt(scan.nextLine()); // broi uikenda v rodniq grad

        double number = 0;

        number = (((48 - h) * 1.0) * 3 / 4) + h + (p * 1.0) * 2 / 3;

        if (year.equals("leap")) {
            number += number * 0.15;
        }

        System.out.printf("%.0f", Math.floor(number));
    }
}
