import java.util.*;
import java.util.stream.Collectors;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Queue<Integer> firstBox = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        Stack<Integer> secondBox = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(Stack::new));

        ArrayList<Integer> claimedItems = new ArrayList<>();

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int item = firstBox.peek() + secondBox.peek();
            if (item % 2 == 0) {
                claimedItems.add(firstBox.poll() + secondBox.pop());
            } else {
                firstBox.offer(secondBox.pop());
            }
        }

        if (firstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        int sum = claimedItems.stream().mapToInt(Integer::intValue).sum();
        if (sum >= 100) {
            System.out.printf("Your loot was epic! Value: %d", sum);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n", sum);
        }
    }
}
