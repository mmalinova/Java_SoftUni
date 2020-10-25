import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Scheduling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Stack<Integer> tasks = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(Stack::new));

        ArrayDeque<Integer> threads = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        int taskValue =Integer.parseInt(scan.nextLine());
        int killThread = 0;

        while (!tasks.isEmpty() && !threads.isEmpty()) {
            int task = tasks.peek();
            int thread = threads.peek();
            if (taskValue == task) {
                killThread = thread;
                break;
            }
            if (thread >= task) {
                tasks.pop();
                threads.poll();
            } else {
                threads.poll();
            }
        }
        System.out.printf("Thread with value %d killed task %d%n", killThread, taskValue);

        String toPrint = threads.toString().replaceAll("[\\[\\]]", "");
        System.out.println(toPrint.replaceAll(",", ""));
    }
}
