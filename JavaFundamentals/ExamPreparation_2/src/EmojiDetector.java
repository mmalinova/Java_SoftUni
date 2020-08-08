import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String regex = "(:{2}|\\*{2})(?<letters>[A-Z]{1}[a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        String digitRegex = "\\d";
        Pattern digitPattern = Pattern.compile(digitRegex);
        Matcher digitMatcher = digitPattern.matcher(input);

        BigInteger threshold = new BigInteger("1");
        List<String> emoji = new ArrayList<>();

        while (digitMatcher.find()) {
            threshold = threshold.multiply(BigInteger.valueOf(Long.parseLong(digitMatcher.group())));
        }

        int counter = 0;
        BigInteger coolness = new BigInteger("0");
        while (matcher.find()) {
            counter++;
            for (int i = 0; i < matcher.group("letters").length(); i++) {
                int asciiCode = matcher.group("letters").charAt(i);
                coolness = coolness.add(BigInteger.valueOf(asciiCode));
            }
            if (coolness.compareTo(threshold) > 0) {
                emoji.add(matcher.group());
            }
            coolness = new BigInteger("0");
        }

        System.out.println("Cool threshold: " + threshold);
        System.out.println(counter + " emojis found in the text. The cool ones are:");
        emoji.forEach(System.out::println);
    }
}
