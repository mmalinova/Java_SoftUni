import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String places = scan.nextLine();

        String regex = "(=|\\/)(?<location>[A-Z]{1}[A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(places);

        List<String> locations = new ArrayList<>();

        int points = 0;
        while (matcher.find()) {
            locations.add(matcher.group("location"));
            points += matcher.group("location").length();
        }
        System.out.println(String.format("Destinations:" + " %s", locations.toString().replaceAll("[\\[\\]]", "")));
        System.out.println("Travel Points: " + points);
    }
}

