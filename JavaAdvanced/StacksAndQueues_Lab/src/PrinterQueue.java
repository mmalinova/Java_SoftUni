import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String input = scan.nextLine();
        while (!"print".equals(input)) {
            if ("cancel".equals(input)) {
                if (!queue.isEmpty()) {
                    System.out.println("Canceled " + queue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                queue.offer(input);
            }
            input = scan.nextLine();
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
