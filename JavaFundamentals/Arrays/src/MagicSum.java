import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());
        int[] numbers = new int[input.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                if (current + numbers[j] == n) {
                    System.out.printf("%d %d%n", current, numbers[j]);
                }
            }
        }
    }
}
