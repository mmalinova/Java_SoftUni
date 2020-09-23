import java.lang.reflect.Array;
import java.util.*;

public class PoisonousPlantsFaster {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[] plants = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dayOfDeath = new int[n];

        ArrayDeque<Integer> prevPlants = new ArrayDeque<>();
        prevPlants.push(0);

        for (int i = 1; i < n; i++) {
            int dayNumber = 0;

            while (!prevPlants.isEmpty() && plants[prevPlants.peek()] >= plants[i]) {
                dayNumber = Math.max(dayNumber, dayOfDeath[prevPlants.pop()]);
            }

            if (!prevPlants.isEmpty()) {
                dayOfDeath[i] = dayNumber + 1;
            }

            prevPlants.push(i);
        }

        System.out.println(Arrays.stream(dayOfDeath)
                .max().getAsInt());
    }
}
