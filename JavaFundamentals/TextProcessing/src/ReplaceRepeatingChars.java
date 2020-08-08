import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length() - 1; i++) {
            char base = input.charAt(i);
            char nextChat = input.charAt(i + 1);
            if (base != nextChat) {
                result.append(base);
                base = nextChat;
            }
        }
        result.append(input.charAt(input.length() - 1));
        System.out.println(result);
    }
}
