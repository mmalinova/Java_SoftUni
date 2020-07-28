import java.util.Scanner;

public class DanceHall {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double l = Double.parseDouble(scan.nextLine());
        double w = Double.parseDouble(scan.nextLine());
        double a = Double.parseDouble(scan.nextLine());
        double area = (l * 100) * (w * 100);
        double area1 = (a * 100) * (a * 100);
        double area2 = area / 10;
        double free = area - area1- area2;
        double res = Math.floor(free / 7040);
        System.out.printf("%.0f%n", res);
    }
}
