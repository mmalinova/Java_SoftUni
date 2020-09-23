import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        ArrayDeque <Integer> numbers = new ArrayDeque<>();

        String[] nums = scan.nextLine().split("\\s+");

        int count = 0;
        for (int i = 0; i < n; i++) {
            numbers.push(Integer.parseInt(nums[count]));
            count++;
        }

        if (!numbers.isEmpty()) {
            if (numbers.size() >= s) {
                for (int i = 0; i < s; i++) {
                    numbers.pop();
                }
            }
            if (numbers.contains(x)) {
                System.out.println("true");
            } else {
                System.out.println(findSmallestElement(numbers));
            }
        }
    }

    private static int findSmallestElement(ArrayDeque<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        if (numbers.isEmpty()) {
            return 0;
        }
        for (Integer number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }
}
