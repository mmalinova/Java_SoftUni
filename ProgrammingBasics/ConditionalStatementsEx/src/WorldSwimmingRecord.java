import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double seconds = Double.parseDouble(scan.nextLine());
        double distance = Double.parseDouble(scan.nextLine());
        double timeInSecFor1Meter = Double.parseDouble(scan.nextLine());

        double sec = distance * timeInSecFor1Meter;
        double plus = (Math.floor(distance / 15) * 12.5);
        double sum = sec + plus;

        if (seconds <= sum) {
            System.out.printf("No, he failed! He was %.2f seconds slower.", sum - seconds);
        } else {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", sum);
        }
    }
}
