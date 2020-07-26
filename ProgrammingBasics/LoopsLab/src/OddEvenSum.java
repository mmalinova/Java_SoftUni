import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int odd = 0; // nechetno
        int even = 0; // chetno

        for (int i = 0; i < n ; i++){
            int num = Integer.parseInt(scan.nextLine());
            if (i % 2 == 0) {
                even += num;
            } else {
                odd += num;
            }
        }
        if (even == odd){
            System.out.println("Yes");
            System.out.printf("Sum = %d", even);
        } else {
            System.out.println("No");
            System.out.printf("Diff = %d", Math.abs(odd - even));
        }
    }
}
