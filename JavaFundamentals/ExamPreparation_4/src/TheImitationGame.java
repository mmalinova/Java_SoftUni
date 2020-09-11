import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scan.nextLine());

        String command = scan.nextLine();
        while (!"Decode".equals(command)) {
            String[] tokens = command.split("\\|");
            switch (tokens[0]) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(tokens[1]);
                    if (numberOfLetters > 0 && numberOfLetters < sb.length()) {
                        String str = sb.substring(0, numberOfLetters);
                        sb.delete(0, numberOfLetters);
                        sb.append(str);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    if (index >= 0 && index < sb.length()) {
                        sb.insert(index, value);
                    } else if (index == sb.length()) {
                        sb.append(value);
                    }
                    break;
                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    if (sb.toString().contains(substring)) {
                        String repl = sb.toString().replace(substring, replacement);
                        sb.delete(0, sb.length());
                        sb.append(repl);
                    }
                    break;
            }
            command = scan.nextLine();
        }
        System.out.println(String.format("The decrypted message is: %s", sb.toString()));
    }
}
