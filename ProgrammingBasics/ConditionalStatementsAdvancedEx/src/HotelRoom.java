import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String mount = scan.nextLine();
        int nights = Integer.parseInt(scan.nextLine());

        double priceS = 0;
        double priceA = 0;

        switch (mount) {
            case "May":
            case "October":
                priceS = 50 * nights;
                priceA = 65 * nights;
                if (nights > 7 && nights <= 14)
                    priceS *= 0.95;
                else if (nights > 14)
                    priceS *= 0.70;
                break;
            case "June":
            case "September":
                priceS = 75.20 * nights;
                priceA = 68.70 * nights;
                if (nights > 14)
                    priceS *= 0.80;
                break;
            case "July":
            case "August":
                priceS = 76 * nights;
                priceA = 77 * nights;
                break;
        }
        if (nights > 14)
            priceA *= 0.90;

        System.out.printf("Apartment: %.2f lv.", priceA);
        System.out.printf("%nStudio: %.2f lv.", priceS);
    }
}
