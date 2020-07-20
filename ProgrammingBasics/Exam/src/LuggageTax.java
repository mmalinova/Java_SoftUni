import java.util.Scanner;

public class LuggageTax {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int width = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());
        int depth = Integer.parseInt(scan.nextLine());
        String isPriority = scan.nextLine();

        int size = width * height * depth;
        double fee = 0;

        switch (isPriority) {
            case "false":
                if (size > 50 && size <= 100) {
                    fee = 25;
                } else if (size > 100 && size <= 200) {
                    fee = 50;
                } else if (size > 200 && size <= 300) {
                    fee = 100;
                }
             break;
            case "true":
                if (size > 100 && size <= 200) {
                    fee = 10;
                } else if (size > 200 && size <= 300) {
                    fee = 20;
                }
                break;
        }
        System.out.printf("Luggage tax: %.2f", fee);
    }
}
