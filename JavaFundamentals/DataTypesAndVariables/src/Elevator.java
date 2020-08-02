import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int p = Integer.parseInt(scan.nextLine());

        int number = 0 ;
        if (n < p)
            number = 1;
        else {
            number = n / p;
            if (n % p > 0)
                number++;
        }
        System.out.printf("%d", number);
    }
}
