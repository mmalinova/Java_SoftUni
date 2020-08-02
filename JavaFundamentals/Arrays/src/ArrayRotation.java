import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] numbers = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());

        String digit = "";
        for (int i = 0; i < n; i++) {
            digit = numbers[0];
            for (int j = 1; j < numbers.length; j++) {
                numbers[j - 1] = numbers[j];
            }
            numbers[numbers.length -  1] = digit;
        }
        System.out.println(String.join(" ", numbers));
    }
}
