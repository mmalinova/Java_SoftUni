import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        int sum = 0;

        for (int i = 0; i < number; i++) {
            int n = Integer.parseInt(scan.nextLine());
            sum += n;
        }
        System.out.println(sum);
    }
}
