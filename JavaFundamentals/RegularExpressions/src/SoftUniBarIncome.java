import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String regex = "%(?<customersName>[A-Z][a-z]+)%[^|$%.]*?<(?<product>\\w+)>[^|$%.]*?\\|(?<count>\\d+)\\|" +
                "[^|$%.]*?(?<price>\\d+\\.?\\d+)\\$";
        Pattern pattern = Pattern.compile(regex);

        double income = 0.0;
        while (!"end of shift".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            double totalPrice = 0.0;
            if (matcher.find()) {
                String customer = matcher.group("customersName");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                totalPrice += count * price;
                income += totalPrice;

                System.out.println(String.format("%s: %s - %.2f", customer, product, totalPrice));
            }
            input = scan.nextLine();
        }
        System.out.println(String.format("Total income: %.2f", income));
    }
}
