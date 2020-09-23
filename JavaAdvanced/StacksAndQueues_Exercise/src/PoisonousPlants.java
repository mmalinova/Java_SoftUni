import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int[] plants = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();


        for (int i = plants.length - 1; i >= 0; i--) {
            queue.offer(plants[i]);
        }

        int days = 0;
        int count = 0;

        if (!queue.isEmpty()) {
            while (true) {
                int top = queue.poll();
                count++;
                if (count == n) {
                    queue.offer(top);
                    if (stack.isEmpty()) {
                        break;
                    }
                    days++;
                    stack.clear();
                    n = queue.size();
                    count = 0;
                } else if (top <= queue.peek()) {
                    queue.offer(top);
                } else {
                    stack.push(top);
                }
            }
        }
        System.out.println(days);
    }
}