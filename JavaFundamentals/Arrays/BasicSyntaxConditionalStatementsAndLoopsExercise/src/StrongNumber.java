import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        int allFact = 0;

        int n = num;
        int m = 0;

        while (n > 0) {
            int factorial = 1;
            m = n % 10;
            n /= 10;
            if (m == 0)
                factorial = 1;
            else
                for (int i = 1; i <= m; i++) {
                    factorial *= i;
                }
            allFact += factorial;
        }
        if (num == allFact)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
