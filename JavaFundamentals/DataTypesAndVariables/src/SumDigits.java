import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }
        System.out.printf("%d", sum);
    }
}
