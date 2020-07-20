import java.util.Scanner;

public class Seats {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        int symbols = 0;
        for (int i = 0; i < num; i++) {
            String type = scan.nextLine();

            if (type.length() == 4) {
                if (type.charAt(0) >= 'A' && type.charAt(0) <= 'Z') {
                    System.out.printf("Seat decoded: %c%c%c%n", type.charAt(0), type.charAt(1), type.charAt(2));
                } else {
                    System.out.printf("Seat decoded: %c%c%c%n", type.charAt(3), type.charAt(1), type.charAt(2));
                }
            } else if (type.length() == 5){
                symbols = type.charAt(1);
                System.out.printf("Seat decoded: %c%d%n", type.charAt(0), symbols);
            } else if (type.length() == 6) {
                symbols = type.charAt(1);
                System.out.printf("Seat decoded: %c%d%n", type.charAt(0), symbols);
            }
        }
    }
}
