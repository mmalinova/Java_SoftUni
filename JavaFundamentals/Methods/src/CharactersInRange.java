import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char first = scan.nextLine().charAt(0);
        char second = scan.nextLine().charAt(0);
        if (first <= second) {
            printASCII(first, second);
        }
        else {
            printASCII(second, first);
        }
    }

    private static void printASCII(char first, char second) {
        for (char i = ++first; i < second; i++) {
            System.out.printf("%s ", i);
        }
    }
}
