import java.util.Scanner;

public class VowelsSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int output = 0;

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            switch (letter) {
                case 'a':
                    output++;
                    break;
                case 'e':
                    output += 2;
                    break;
                case 'i':
                    output += 3;
                    break;
                case 'o':
                    output += 4;
                    break;
                case 'u':
                    output += 5;
                    break;
            }
        }
        System.out.printf("%d", output);
    }
}
