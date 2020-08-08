import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /*BigInteger number = new BigInteger(scan.nextLine());
        int multiplier = Integer.parseInt(scan.nextLine());

        BigInteger result = number.multiply(BigInteger.valueOf(multiplier));
        System.out.println(result);
        */

        StringBuilder number = new StringBuilder(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        if (n == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder result = new StringBuilder();
        while (number.charAt(0) == '0') {
            number.deleteCharAt(0);
        }

        int reminder  = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int m = Integer.parseInt(String.valueOf(number.charAt(i))) * n + reminder;
            reminder = 0;
            if (m > 9) {
                reminder = m / 10;
                m = m % 10;
            }
            result.append(m);
        }
        if (reminder != 0) {
            result.append(reminder);
        }
        System.out.println(result.reverse());
    }
}