import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        String room = scan.nextLine();
        String mark = scan.nextLine();

        int nights = days - 1;
        double price = 0;

        switch (room) {
            case "room for one person":
                if (days < 10) {
                    price = 18 * nights;
                } else if (days > 10 && days < 15 || days == 10) {
                    price = 18 * nights;
                } else if (days > 15) {
                    price = 18 * nights;
                }
                if (mark.equals("positive")) {
                    price += 0.25 * price;
                } else if (mark.equals("negative")) {
                    price -= 0.1 * price;
                }
                System.out.printf("%.2f", price);
                break;
            case "apartment":
                if (days < 10) {
                    price = (25 * nights) * 0.7;
                } else if (days > 10 && days < 15 || days == 10) {
                    price = (25 * nights) * 0.65;
                } else if (days > 15) {
                    price = (25 * nights) * 0.5;
                }
                if (mark.equals("positive")) {
                    price += 0.25 * price;
                } else if (mark.equals("negative")) {
                    price -= 0.1 * price;
                }
                System.out.printf("%.2f", price);
                break;
            case "president apartment":
                if (days < 10) {
                    price = (35 * nights) * 0.9;
                } else if (days > 10 && days < 15 || days == 10) {
                    price = (35 * nights) * 0.85;
                } else if (days > 15) {
                    price = (35 * nights) * 0.8;
                }
                if (mark.equals("positive")) {
                    price += 0.25 * price;
                } else if (mark.equals("negative")) {
                    price -= 0.1 * price;
                }
                System.out.printf("%.2f", price);
                break;
        }
    }
}
