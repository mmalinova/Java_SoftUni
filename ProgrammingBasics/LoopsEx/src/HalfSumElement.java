import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        double sum = 0;
        double max = Double.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            double value = Double.parseDouble(scan.nextLine());
            sum += value;
            if (value > max) {
                max = value;
            }
        }
        sum -= max;
        if (sum == max) {
            System.out.println("Yes");
            System.out.printf("Sum = " + sum);
        } else {
            System.out.println("No");
            System.out.printf("Diff = " + Math.abs(sum - max));
        }
    }
}
