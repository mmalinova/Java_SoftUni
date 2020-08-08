import java.util.Scanner;

public class CaesarCipher {
    private static Object StringBuilder;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            encrypted.append((char) (input.charAt(i) + 3));
        }
        System.out.println(encrypted);
    }
}
