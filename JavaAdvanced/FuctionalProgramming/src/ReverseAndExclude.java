import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        Integer n = Integer.parseInt(scan.nextLine());

        BiConsumer<ArrayList<Integer>, Integer> remove = (list, number) ->
                list.removeIf(integer -> integer % number == 0);

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

        Collections.reverse(numbers);
        remove.accept(numbers, n);
        printConsumer.accept(numbers);
    }
}
