import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        Consumer<ArrayList<Integer>> addConsumer = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) + 1);
            }
        };

        Consumer<ArrayList<Integer>> subtractConsumer = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) - 1);
            }
        };

        Consumer<ArrayList<Integer>> multiplyConsumer = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) * 2);
            }
        };

        Consumer<ArrayList<Integer>> printConsumer = list -> {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : list) {
                sb.append(integer).append(" ");
            }
            if (sb.length() > 0) {
                System.out.println(sb.substring(0, sb.length() - 1));
            } else {
                System.out.println(sb.substring(0, sb.length()));
            }
        };

        String command = scan.nextLine();
        while(!"end".equals(command)) {
            switch ((command)) {
                case "add":
                    addConsumer.accept(numbers);
                    break;
                case "multiply":
                    multiplyConsumer.accept(numbers);
                    break;
                case "subtract":
                    subtractConsumer.accept(numbers);
                    break;
                case "print":
                    printConsumer.accept(numbers);
                    break;
            }
            command = scan.nextLine();
        }
    }
}
