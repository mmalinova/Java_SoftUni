import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque <String> stack = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).forEach(stack :: push);

        stack.forEach(e -> System.out.print(e + " "));
    }
}