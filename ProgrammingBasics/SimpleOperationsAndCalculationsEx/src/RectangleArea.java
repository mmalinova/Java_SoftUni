import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x1 = Double.parseDouble(scan.nextLine());
        double y1 = Double.parseDouble(scan.nextLine());
        double x2 = Double.parseDouble(scan.nextLine());
        double y2 = Double.parseDouble(scan.nextLine());
        double area = Math.abs(x1 - x2) * Math.abs(y2 - y1);
        double per = 2 * (Math.abs(x1 - x2) + Math.abs(y1 - y2));
        System.out.printf("%.2f%n", area);
        System.out.printf("%.2f%n", per);
    }
}
