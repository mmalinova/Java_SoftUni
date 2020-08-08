import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        StringBuilder sb = new StringBuilder();

        String[] morseLetters = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        String[] englishLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
        "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("|")) {
                sb.append(" ");
                continue;
            }
            for (int j = 0; j < morseLetters.length; j++) {
                if (input[i].equals(morseLetters[j])) {
                    sb.append(englishLetters[j]);
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
