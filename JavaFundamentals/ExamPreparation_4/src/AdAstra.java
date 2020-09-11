import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String regex = "(\\||#)(?<name>[A-Z]+[a-z]+\\s*[A-Z]*[a-z]*)\\1" +
                "(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>[^0]\\d{1,4})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        double totalCalories = 0.0;
        int lastDays = 0;

        while (matcher.find()) {
            double calories = Double.parseDouble(matcher.group("calories"));
            totalCalories += calories;
            lastDays = (int) (totalCalories / 2000);
        }
        System.out.println(String.format("You have food to last you for: %d days!", lastDays));

        matcher = pattern.matcher(input);
        while (matcher.find()) {
            String name = matcher.group("name");
            String date = matcher.group("date");
            double calories = Double.parseDouble(matcher.group("calories"));
            System.out.println(String.format("Item: %s, Best before: %s, Nutrition: %.0f", name, date, calories));
        }
    }
}
