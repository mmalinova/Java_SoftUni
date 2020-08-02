import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int tankCapacity = 255;
        int litersInTheTank = 0;

        for (int i = 0; i < n; i++) {
            int liters = Integer.parseInt(scan.nextLine());
            if (tankCapacity < liters)
                System.out.println("Insufficient capacity!");
            else
                litersInTheTank += liters;
            if (tankCapacity < litersInTheTank) {
                System.out.println("Insufficient capacity!");
                litersInTheTank -= liters;
            }
        }
        System.out.printf("%d", litersInTheTank);
    }
}
