import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        double result = 0.0;
        for (int i = 0; i < input.length; i++) {
            String string = input[i];
            result += calculation(string);
        }
        System.out.println(String.format("%.2f", result));
    }

    private static double calculation(String string) {
        double firstResult = 0.0;
        double secondResult = 0.0;
        char firstLetter = string.charAt(0);
        char secondLetter = string.charAt(string.length() - 1);
        String num = string.substring(1, string.length() - 1);
        long number = Integer.parseInt(num);
        if (Character.isUpperCase(firstLetter)) {
            firstResult = number * 1.0 / (firstLetter - 64);
        } else {
            firstResult = number * (firstLetter - 96);
        }
        if (Character.isUpperCase(secondLetter)) {
            secondResult = firstResult - (secondLetter - 64);
        } else {
            secondResult = firstResult + (secondLetter - 96);
        }
        return secondResult;
    }
}
