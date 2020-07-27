import java.util.Scanner;

public class EqualSumsEvenOdd {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());

        for (int i = num1; i <= num2 ; i++) {
            int odd = 0;
            int even = 0;
            boolean isEven = true;
            int current = i;
            while (current > 0) {
                int number = current % 10;
                current = current / 10;
                if (isEven) {
                    even += number;
                    isEven = false;
                } else {
                    odd += number;
                    isEven = true;
                }
            }
            if (even == odd) {
                System.out.printf("%d ", i);
            }
        }
    }
}
