import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        double snowballSnow = 0.0;
        double snowballTime = 0.0;
        double snowballQuality = 0.0;
        double snowballValue = 0.0;
        long highestSnowballValue = 0;

        for (int i = 0; i < n; i++) {
            double snow = Double.parseDouble(scan.nextLine());
            double time = Double.parseDouble(scan.nextLine());
            double quality = Double.parseDouble(scan.nextLine());
            long value = Math.round(Math.pow((snow / time ), quality));
            if (highestSnowballValue < value) {
                highestSnowballValue = value;
                snowballSnow = snow;
                snowballTime = time;
                snowballQuality = quality;
                snowballValue = value;
            }
        }
        System.out.printf("%.0f : %.0f = %.0f (%.0f)", snowballSnow,
                snowballTime, snowballValue, snowballQuality);
    }
}
