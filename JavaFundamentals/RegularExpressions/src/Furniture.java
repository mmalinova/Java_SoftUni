import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String regex = ">>(?<furniture>[A-Z]+[a-z]*)<<(?<price>\\d+\\.?\\d+)!(?<quantity>\\d+)";

        Pattern pattern = Pattern.compile(regex);

        List<String> furniture = new ArrayList<>();

        double totalPrice = 0.0;
        while (!"Purchase".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String furnitureName = matcher.group("furniture");
                furniture.add(furnitureName);
                double furniturePrice = Double.parseDouble(matcher.group("price"));
                int furnitureQuantity = Integer.parseInt(matcher.group("quantity"));
                totalPrice += furniturePrice * furnitureQuantity;
            }
            input = scan.nextLine();
        }
        System.out.println("Bought furniture:");
        furniture.forEach(e -> System.out.println(e));
//        for (int i = 0; i < furniture.size(); i++) {
//            System.out.println(furniture.get(i));
//        }
        System.out.println(String.format("Total money spend: %.2f", totalPrice));
    }
}
