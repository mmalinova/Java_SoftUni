import java.util.Scanner;

public class Sequence2kPlus1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int k = 0;

        while (k <= n) {
            k = 2 * k + 1;
            if (k > n)
                break;
            System.out.println(k);
        }
    }
}
