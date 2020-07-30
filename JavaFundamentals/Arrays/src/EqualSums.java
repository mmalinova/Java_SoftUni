import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int[] numbers = new int[input.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        boolean isExists = false;
        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];
            int leftSum = 0, rightSum = 0;
            if (numbers.length <= 1) {
                System.out.print("0");
                return;
            }
            for (int j = i - 1; j >= 0; j--) {
                leftSum += numbers[j];
            }
            for (int k = i + 1; k < numbers.length; k++) {
                    rightSum += numbers[k];
                }

            if (leftSum == rightSum) {
                System.out.print(i);
                isExists = true;
            }
        }
        if(!isExists) {
            System.out.print("no");
        }
    }
}
