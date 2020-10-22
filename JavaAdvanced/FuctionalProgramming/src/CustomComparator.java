import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        for (Integer number : numbers) {
            if (number % 2 == 0) {
                even.add(number);
            } else {
                odd.add(number);
            }
        }

        Collections.sort(even);
        Collections.sort(odd);

        BiConsumer<ArrayList<Integer>, ArrayList<Integer>> printConsumer = (evenList, oddList) -> {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : evenList) {
                sb.append(integer).append(" ");
            }
            for (Integer integer : oddList) {
                sb.append(integer).append(" ");
            }
            if (sb.length() > 0) {
                System.out.println(sb.substring(0, sb.length() - 1));
            } else {
                System.out.println(sb.substring(0, sb.length()));
            }
        };

        printConsumer.accept(even, odd);
    }
}
