import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        
        Consumer<String> consumer = System.out::println;

        for (String s : input) {
            consumer.accept(s);
        }
    }
}
