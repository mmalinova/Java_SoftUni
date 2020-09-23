import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int fibonacciNumber = Integer.parseInt(scan.nextLine());
        long[] memoization = new long[fibonacciNumber + 1];

        long output = getFibonacci(fibonacciNumber, memoization);
        if (output < 0) {
            System.out.println("Invalid number");
        } else {
            System.out.println(output);
        }
    }

    private static long getFibonacci(int fibonacciNumber, long[] memoization) {
        if (fibonacciNumber == 0 || fibonacciNumber == 1) {
            return 1;
        } else if (fibonacciNumber < 0){
            return -1;
        } else if (memoization[fibonacciNumber] == 0) {
            return memoization[fibonacciNumber] = getFibonacci(fibonacciNumber - 1, memoization)
                    + getFibonacci(fibonacciNumber - 2, memoization);
        } else {
            return memoization[fibonacciNumber];
        }
    }
}
