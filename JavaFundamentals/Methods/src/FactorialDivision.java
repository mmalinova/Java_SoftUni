import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scan.nextLine());
        int secondNumber = Integer.parseInt(scan.nextLine());

        long firstFactorial = calcFactorial(firstNumber);
        long secondFactorial = calcFactorial(secondNumber);

        double result = firstFactorial * 1.0 / secondFactorial;
        System.out.printf("%.2f", result);

    }

    private static long calcFactorial(int number) {
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}

