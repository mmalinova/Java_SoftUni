import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] nums = scan.nextLine().split("\\s+");
        int[] numbers = new int[nums.length];

        for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(nums[i]);
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            int digit = numbers[i];
            boolean print = true;
            for (int j = i + 1; j < numbers.length; j++) {
                if (digit <= numbers[j]) {
                    print = false;
                    break;
                }
            }
            if (print) {
                System.out.printf("%d ", digit);
            }
        }
        System.out.print(numbers[numbers.length - 1]);
    }
}
