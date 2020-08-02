import java.util.Scanner;

public class IntegerOperators {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());
        int thirdNum = Integer.parseInt(scan.nextLine());
        int fourNum = Integer.parseInt(scan.nextLine());

        int result = ((firstNum + secondNum) / thirdNum) * fourNum;
        System.out.printf("%d", result);
    }
}
