import java.util.Scanner;

public class PoinOnRectangleBorder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double x1 = Double.parseDouble(scan.nextLine());
        double y1 = Double.parseDouble(scan.nextLine());
        double x2 = Double.parseDouble(scan.nextLine());
        double y2 = Double.parseDouble(scan.nextLine());
        double x = Double.parseDouble(scan.nextLine());
        double y = Double.parseDouble(scan.nextLine());

        boolean condition = (x == x1 || x == x2) && (y >= y1 && y <= y2);
        boolean con = (y == y1 || y == y2) && (x >= x1 && x <= x2);

        if (condition || con)
                System.out.println("Border");
        else
            System.out.println("Inside / Outside");
    }
}
