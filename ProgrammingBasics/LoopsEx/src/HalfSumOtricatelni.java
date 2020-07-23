import java.util.Scanner;

public class HalfSumOtricatelni {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        double [] a = new double [n];
        double max = 0.0;
        double sum = 0.0;
        double sumAll = 0.0;
        int flag = 0;

        for (int i = 0; i < a.length; i++) {
            a[i] = Double.parseDouble(scan.nextLine());
            sumAll += a[i];
        }
        for (int i = 0; i < a.length; i++) {
            sum = sumAll - a[i];
            if (a[i] == sum && flag == 0) {
                System.out.println("Yes");
                System.out.printf("Sum = %.2f%n", sum);
                flag = 1;
            }
        }
        if (flag == 0){
            System.out.println("No");
        }
    }
}
