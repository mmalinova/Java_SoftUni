import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String result = middleCharacters(input);
        System.out.println(result);
    }

    private static String middleCharacters(String input) {
        if (input.length() % 2 == 0) {
            return String.format("%s" + "%s", input.charAt(input.length() / 2 - 1), input.charAt(input.length() / 2));
        }
        else {
            return String.format("%s", input.charAt(input.length() / 2));
        }
    }
}
