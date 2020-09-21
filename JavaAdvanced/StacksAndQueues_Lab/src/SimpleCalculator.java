import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String[] string = scan.nextLine().split("\\s+");
        for (int i = string.length - 1; i >= 0; i--) {
            stack.push(string[i]);
        }

        int number = 0;
        int result = Integer.parseInt(stack.pop());
        String sign = "";

        while (!stack.isEmpty()) {
            String element = stack.pop();
            if (element.equals("-")){
                sign = "-";
            } else if (element.equals("+")) {
                sign = "+";
            } else {
                number = Integer.parseInt(String.valueOf(element));
                if (sign.equals("+")) {
                    result += number;
                } else {
                    result -= number;
                }
            }
        }
        System.out.println(result);
    }
}
