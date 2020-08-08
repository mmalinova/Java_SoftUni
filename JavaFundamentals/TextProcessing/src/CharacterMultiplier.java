import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        int max = Math.max(input[0].length(), input[1].length());
        int min = Math.min(input[0].length(), input[1].length());

        int totalSum= 0;
        for (int i = 0; i < max; i++) {
            if (i < min) {
                totalSum += input[0].charAt(i) * input[1].charAt(i);
            } else if (max == input[0].length()) {
                totalSum += input[0].charAt(i);
            } else {
                totalSum += input[1].charAt(i);
            }
        }
        System.out.println(totalSum);
    }
}
