import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque <Integer> numbers = new ArrayDeque<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commands = scan.nextLine().split("\\s+");
            //•	"1 X" - Push the element X into the stack.
            //•	"2" - Delete the element present at the top of the stack.
            //•	"3" - Print the maximum element in the stack.
            switch (commands[0]) {
                case "1":
                    int element = Integer.parseInt(commands[1]);
                    numbers.push(element);
                    break;
                case "2":
                    if (!numbers.isEmpty()) {
                        numbers.pop();
                    }
                    break;
                case "3":
                    if (!numbers.isEmpty()) {
                        int maxElement = findMaxElement(numbers);
                        System.out.println(maxElement);
                    }
                    break;
            }
        }
    }

    private static int findMaxElement(ArrayDeque<Integer> numbers) {
        int max = Integer.MIN_VALUE;
        for (Integer number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}
