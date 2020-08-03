import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        System.out.println(vowelsCount(input));
    }

    private static int vowelsCount(String input) {
        int count = 0;
        for (char k = 0; k < input.length(); k++) {
            char i = input.charAt(k);
            if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u' || i == 'y'
            || i == 'A' || i == 'E' || i == 'I' || i == 'O' || i == 'U' || i == 'Y') {
                count++;
            }
        }
        return count;
    }
}
