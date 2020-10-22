import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);

        Function<Integer[], Integer> findSmallest = arr -> {
            int num = Integer.MAX_VALUE;
            int numIndex = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= num) {
                    num = arr[i];
                    numIndex = i;
                }
            }
            return numIndex;
        };

        System.out.println(findSmallest.apply(numbers));
    }
}
