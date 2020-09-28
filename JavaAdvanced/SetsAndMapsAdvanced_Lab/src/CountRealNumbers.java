import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<Double, Integer> numbers = new LinkedHashMap<>();

        String[] command = scan.nextLine().split("\\s+");
        for (int i = 0; i < command.length; i++) {
            numbers.putIfAbsent(Double.parseDouble(command[i]), 0);
            numbers.put(Double.parseDouble(command[i]), numbers.get(Double.parseDouble(command[i])) + 1);
        }

        numbers.entrySet()
                .forEach(e -> {
            System.out.println(String.format("%.1f -> %d", e.getKey(), e.getValue()));
        });
    }
}
