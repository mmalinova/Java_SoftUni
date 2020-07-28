import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int begin = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int number = Integer.parseInt(scan.nextLine());
        int combination = 0;
        boolean isFound = false;

        for (int i = begin; i <= end ; i++) {
            for (int j = begin; j <= end; j++) {
                combination++;
                if (i + j == number){
                    System.out.printf("Combination N:%d (%d + %d = %d)", combination, i, j, number);
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        } if (!isFound)
            System.out.printf("%d combinations - neither equals %d", combination, number);
    }
}
