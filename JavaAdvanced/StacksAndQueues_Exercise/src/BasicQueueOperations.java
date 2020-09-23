import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
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
            numbers.offer(Integer.parseInt(nums[count]));
            count++;
        }

        if (!numbers.isEmpty()) {
            if (numbers.size() >= s) {
                for (int i = 0; i < s; i++) {
                    numbers.poll();
                }
            }
            if (numbers.contains(x)) {
                System.out.println("true");
            } else if (numbers.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(numbers));
            }
        }
    }
}
