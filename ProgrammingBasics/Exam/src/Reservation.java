import java.util.Scanner;

public class Reservation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int resDay = Integer.parseInt(scan.nextLine());
        int resMonth = Integer.parseInt(scan.nextLine());
        int nasDay = Integer.parseInt(scan.nextLine());
        int nasMonth = Integer.parseInt(scan.nextLine());
        int leaveDay = Integer.parseInt(scan.nextLine());
        int leaveMonth = Integer.parseInt(scan.nextLine());

        double sum = 0;
        int night = 30;
        double discount = 0;
        int count = 0;

        count = leaveDay - nasDay;
        sum = count * night;
        if (resDay + 10 <= nasDay) {
            sum = count * 25;
        }
        if (resMonth < nasMonth) {
            discount = (count * 25) * 0.20;
            sum = (count * 25) - discount;
        }
        System.out.printf("Your stay from %d/%d to %d/%d will cost %.2f", nasDay, nasMonth, leaveDay, leaveMonth, sum);
    }
}
