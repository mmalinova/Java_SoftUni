import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 1111; i <= 9999; i++) {
            int number = i;
            boolean isSpecial = true;
            while (number > 0) {
                int last = number % 10;
                if (last == 0 || n % last != 0) {
                    isSpecial = false;
                    break;
                }
                number /= 10;
            }
            if (isSpecial) {
                System.out.printf("%d ", i);
            }
        }
    }
}
