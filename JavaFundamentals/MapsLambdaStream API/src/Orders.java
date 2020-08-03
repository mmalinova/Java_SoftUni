import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Double> products = new LinkedHashMap<>();
        Map<String, Integer> quantity = new LinkedHashMap<>();

        String command = scan.nextLine();
        while (!"buy".equals(command)) {
            String[] input = command.split("\\s+");
            String prod = input[0];
            Double price = Double.parseDouble(input[1]);
            int count = Integer.parseInt(input[2]);
            products.put(prod, price);
            if (quantity.containsKey(prod)) {
                int oldCount = quantity.get(prod);
                int newCount = oldCount + count;
                quantity.replace(prod, newCount);
            } else {
                quantity.putIfAbsent(prod, count);
            }
            command = scan.nextLine();
        }
        products.forEach((key, value) -> System.out.printf("%s -> %.2f%n", key, value * quantity.get(key)));
    }
}
