import java.util.Scanner;

public class DivideWithoutRemainder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int countP1 = 0;
        int countP2 = 0;
        int countP3 = 0;

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(scan.nextLine());
            if (value % 2 == 0)
                countP1++;
            if (value % 3 == 0)
                countP2++;
            if (value % 4 == 0)
                countP3++;
        }
        double p1 = countP1 * 1.0 / n * 100;
        double p2 = countP2 * 1.0 / n * 100;
        double p3 = countP3 * 1.0 / n * 100;

        System.out.printf("%.2f%%%n", p1);
        System.out.printf("%.2f%%%n", p2);
        System.out.printf("%.2f%%%n", p3);
    }
}
