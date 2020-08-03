import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] firstInput = scan.nextLine().split("\\s+");
        List<Integer> first = new ArrayList<>();
        for (int i = 0; i < firstInput.length; i++) {
            first.add(Integer.parseInt(firstInput[i]));
        }
        String[] secondInput = scan.nextLine().split("\\s+");
        List<Integer> second = new ArrayList<>();
        for (int i = 0; i < secondInput.length; i++) {
            second.add(Integer.parseInt(secondInput[i]));
        }

        int sum = 0;

        while (!first.isEmpty() && !second.isEmpty()) {
            if (first.get(0) > second.get(0)) {
                first.add(first.remove(0));
                first.add(second.remove(0));
               //second.remove(second.get(0));
            } else if (second.get(0) > first.get(0)) {
                second.add(second.remove(0));
                second.add(first.remove(0));
                //first.remove(first.get(0));
            } else if (first.get(0).equals(second.get(0))){
                first.remove(first.get(0));
                second.remove(second.get(0));
            }
        }
        if (!first.isEmpty()) {
            for (int cards: first) {
                sum += cards;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        } else if (!second.isEmpty()) {
            for (int cards: second) {
                sum += cards;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }
    }
}
