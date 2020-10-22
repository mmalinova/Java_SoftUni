import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        Consumer<String> consumer = string -> System.out.println("Sir " + string);

        for (String s : input) {
            consumer.accept(s);
        }
    }
}
