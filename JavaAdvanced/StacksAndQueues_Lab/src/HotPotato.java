import java.util.*;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] childrenNames = scan.nextLine().split("\\s+");

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < childrenNames.length; i++) {
            queue.offer(childrenNames[i]);
        }

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
    }
}
