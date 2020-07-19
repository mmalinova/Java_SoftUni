import java.util.Scanner;

public class Covid {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char output = '*';
        int total = 0;
        int number = 0;
        int num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0, num6 = 0, num7 = 0;

        for (int i = 1; i <= 7; i++) {
            System.out.printf("Day %d: ", i);
            number = Integer.parseInt(scan.nextLine());
            switch (i) {
                case 1:
                    num1 = number;
                    break;
                case 2:
                    num2 = number;
                    break;
                case 3:
                    num3 = number;
                    break;
                case 4:
                    num4 = number;
                    break;
                case 5:
                    num5 = number;
                    break;
                case 6:
                    num6 = number;
                    break;
                case 7:
                    num7 = number;
                    break;
            }
            total += number;
        }
        System.out.printf("%nDay 1: ");
        for (int i = 1; i <= num1; i++) {
            System.out.printf("%c", output);
        }
        System.out.printf("%nDay 2: ");
        for (int i = 1; i <= num2; i++) {
            System.out.printf("%c", output);
        }
        System.out.printf("%nDay 3: ");
        for (int i = 1; i <= num3; i++) {
            System.out.printf("%c", output);
        }
        System.out.printf("%nDay 4: ");
        for (int i = 1; i <= num4; i++) {
            System.out.printf("%c", output);
        }
        System.out.printf("%nDay 5: ");
        for (int i = 1; i <= num5; i++) {
            System.out.printf("%c", output);
        }
        System.out.printf("%nDay 6: ");
        for (int i = 1; i <= num6; i++) {
            System.out.printf("%c", output);
        }
        System.out.printf("%nDay 7: ");
        for (int i = 1; i <= num7; i++) {
            System.out.printf("%c", output);
        }
        System.out.printf("%nTotal sick people: %d%n", total);
        System.out.printf("Total increasing from day 1 to 7: %.2f%%.%n", (total * 1.0/ num7) * 100);
    }
}
