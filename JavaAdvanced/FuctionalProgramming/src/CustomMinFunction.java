import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);

        Function<Integer[], Integer> findMin = arr -> Arrays.stream(arr).mapToInt(Integer::valueOf).min().orElse(0);

        System.out.println(findMin.apply(numbers));
    }
}
