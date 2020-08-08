import java.util.Collection;
import java.util.Scanner;

public class ValidUsername {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");
        for (int i = 0; i < input.length; i++) {
            if (input[i].length() >= 3 && input[i].length() <= 16) {
                if (isValid(input[i])) {
                    System.out.println(input[i]);
                }
            }
        }
    }
    public static boolean isValid(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetterOrDigit(word.charAt(i)) && word.charAt(i) != '-' && word.charAt(i) != '_') {
                return  false;
            }
        }
        return  true;
    }
}
