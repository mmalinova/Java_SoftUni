import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scan.nextLine());
        int secondNumber = Integer.parseInt(scan.nextLine());
        int thirdNumber = Integer.parseInt(scan.nextLine());

        int sum = sum(firstNumber, secondNumber);
        int result = subtract(sum, thirdNumber);

        System.out.println(result);
    }

    private static int subtract(int sum, int thirdNumber) {
        return sum - thirdNumber;
    }

    private static int sum(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
