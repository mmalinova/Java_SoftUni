import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int counter = 1;
        boolean isBigger = false;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.printf("%d ", counter + 1);
                System.out.printf("%d ", counter);
                counter++;
                if (counter > n) {
                    isBigger = true;
                    break;
                }
            } if (isBigger)
                break;
            System.out.println();
        }
    }
}
