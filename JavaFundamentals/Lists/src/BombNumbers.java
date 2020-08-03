import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] listInput = scan.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < listInput.length; i++) {
            numbers.add(Integer.parseInt(listInput[i]));
        }

        String[] input = scan.nextLine().split("\\s+");
        int bombNumber = Integer.parseInt(input[0]);
        int bombPower = Integer.parseInt(input[1]);

        int sum = 0;

        while (numbers.contains(bombNumber)) {
            int indexBomb = numbers.indexOf(bombNumber);

            int left = Math.max(0, indexBomb - bombPower);
            int right = Math.min(numbers.size() - 1, indexBomb + bombPower);

            for (int i = right; i >= left; i--) {
                numbers.remove(i);
            }
        }

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        System.out.println(sum);
    }
}
