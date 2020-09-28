import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();

        String input = scan.nextLine();
        while(!"Revision".equals(input)) {
            String[] tokens = input.split(", ");
            String shopName = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shops.putIfAbsent(shopName, new LinkedHashMap<>());
            shops.get(shopName).put(product, price);
            input = scan.nextLine();
        }

        shops.forEach((shop, products) -> {
            System.out.println(shop + "->");
            products.forEach((product, price) -> System.out.println(String.format("Product: %s, Price: %.1f",
                    product, price)));
        });
    }
}
