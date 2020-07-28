import java.util.Scanner;

public class Bus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        int stops = Integer.parseInt(scan.nextLine());

        int n = 0;

        for (int i = 1; i <= stops; i++) {
            int minus = Integer.parseInt(scan.nextLine());
            int plus = Integer.parseInt(scan.nextLine());
            if (i % 2 == 0) {
                minus += 2;
                n = number - minus + plus;
                number = n;
            } else {
                plus += 2;
                n = number - minus + plus;
                number = n;
            }
        }
        System.out.printf("The final number of passengers is : %d", n);
    }
}
