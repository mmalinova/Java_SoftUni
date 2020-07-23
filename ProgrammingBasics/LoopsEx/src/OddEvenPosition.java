import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        double sumE = 0.0;
        double maxE = -1000000000.0;
        double minE = 1000000000.0;

        double sumO = 0.0;
        double maxO = -1000000000.0;
        double minO = 1000000000.0;

        for (int i = 1; i <= n; i++) {
            double value = Double.parseDouble(scan.nextLine());
            if (i % 2 == 0) {
                sumE += value;
                if (value > maxE) {
                    maxE = value;
                }
                if (value < minE) {
                    minE = value;
                }
            } else {
                sumO += value;
                if (value > maxO) {
                    maxO = value;
                }
                if (value < minO) {
                    minO = value;
                }
            }
        }
        System.out.printf("OddSum=%.2f,%n", sumO);
        if (minO == 1000000000.0) {
            System.out.println("OddMin=No,");
        } else {
            System.out.printf("OddMin=%.2f,%n", minO);
        }
        if (maxO == -1000000000.0) {
            System.out.println("OddMax=No,");
        } else {
            System.out.printf("OddMax=%.2f,%n", maxO);
        }
        System.out.printf("EvenSum=%.2f,%n", sumE);
        if (minE == 1000000000.0) {
            System.out.println("EvenMin=No,");
        } else {
            System.out.printf("EvenMin=%.2f,%n", minE);
        }
        if (maxE == -1000000000.0) {
            System.out.println("EvenMax=No");
        } else {
            System.out.printf("EvenMax=%.2f%n", maxE);
        }
    }
}
