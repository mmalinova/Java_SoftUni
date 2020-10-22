import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Integer length = Integer.parseInt(scan.nextLine());
        String[] names = scan.nextLine().split("\\s+");

        BiFunction<String[], Integer, String> namesPredicate = (arr, len) -> {
            StringBuilder sb = new StringBuilder();
            for (String s : arr) {
                if (s.length() <= len) {
                    sb.append(s).append(System.lineSeparator());
                }
            }
            if (sb.length() > 0) {
                return sb.substring(0, sb.length() - 1);
            } else {
                return sb.substring(0, sb.length());
            }
        };

        System.out.println(namesPredicate.apply(names, length));
    }
}
