import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char firstChar = scan.nextLine().charAt(0);
        char secondChar = scan.nextLine().charAt(0);
        String input = scan.nextLine();

        int start = Math.min(firstChar, secondChar);
        int end = Math.max(firstChar, secondChar);

        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            int currentChar = input.charAt(i);
            if (currentChar > start && currentChar < end) {
                sum += currentChar;
            }
        }
        System.out.println(sum);
    }
}
