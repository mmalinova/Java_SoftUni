import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());

        for (int i = num1; i <= num2; i++) {
            String current = "" + i;
            int odd = 0;
            int even = 0;
            for (int j = 0; j < current.length(); j++) {
                int currentDigit = Integer.parseInt("" + current.charAt(j));
                if (j % 2 == 0)
                    even += currentDigit;
                else
                    odd += currentDigit;
            }
            if (even == odd)
                System.out.printf(i + " ");
        }
    }
}
