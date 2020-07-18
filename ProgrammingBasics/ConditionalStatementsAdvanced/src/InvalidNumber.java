import java.util.Scanner;

public class InvalidNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        if (!(num >= 100 && num <= 200 || num == 0))
            System.out.println("invalid");
    }
}
