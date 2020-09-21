import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int input = Integer.parseInt(scan.nextLine());
        if (input == 0) {
            System.out.println(0);
        } else {
            while (input != 0) {
                stack.push(input % 2);
                input /= 2;
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
