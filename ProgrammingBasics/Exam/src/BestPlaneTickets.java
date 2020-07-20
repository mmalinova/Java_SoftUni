import java.util.Scanner;

public class BestPlaneTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String number = "";
        double price1 = 0;
        int minMin = Integer.MAX_VALUE;
        int hour = 0;
        int mins = 0;
        while (!input.equals("End")) {
            double price = Double.parseDouble(scan.nextLine());
            int min = Integer.parseInt(scan.nextLine());
            if (min < minMin) {
                minMin = min;
                price1 = price * 1.96;
                number = input;
            }
            input = scan.nextLine();
        }
        if (minMin >= 60) {
            hour = 1;
            mins = minMin - 60;
        } else {
            mins = minMin;
        }
        System.out.printf("Ticket found for flight %s costs %.2f leva with %dh %dm stay", number, price1 , hour, mins);
    }
}
