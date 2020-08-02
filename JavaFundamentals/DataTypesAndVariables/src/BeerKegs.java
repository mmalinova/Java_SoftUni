import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        double biggestVolume = 0.0;
        String biggestKeg = "";

        for (int i = 0; i < n; i++) {
            String model = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());
            double volume = 3.14159265359 * radius * radius * height;
            if (biggestVolume < volume) {
                biggestVolume = volume;
                biggestKeg = model;
            }
        }
        System.out.printf("%s", biggestKeg);
    }
}
