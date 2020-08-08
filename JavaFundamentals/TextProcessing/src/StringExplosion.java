import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        StringBuilder sb = new StringBuilder();

        int strength = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '>') {
                strength += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
                sb.append('>');
            } else if (strength == 0) {
                sb.append(input.charAt(i));
            } else {
                strength--;
            }
        }
        System.out.println(sb);
    }
}
