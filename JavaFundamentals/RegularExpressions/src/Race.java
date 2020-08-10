import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");

        Map<String, Integer> rice = new LinkedHashMap<>();
        for (int i = 0; i < input.length; i++) {
            rice.putIfAbsent(input[i], 0);
        }

        String regexFirstLetter = "([A-Z]+)";
        String regexLetter = "([a-z]+)";
        String regexDigits = "(\\d)";

        Pattern patternFirstLetter = Pattern.compile(regexFirstLetter);
        Pattern patternLetters = Pattern.compile(regexLetter);
        Pattern patternDigits = Pattern.compile(regexDigits);

        String command = scan.nextLine();
        while(!"end of race".equals(command))  {
            StringBuilder sb = new StringBuilder();
            Matcher matcher = patternFirstLetter.matcher(command);
            if (matcher.find()) {
                sb.append(matcher.group());
            }
            Matcher matcherSecond = patternLetters.matcher(command);
            while (matcherSecond.find()) {
                sb.append(matcherSecond.group());
            }
            if (rice.containsKey(sb.toString())) {
                Matcher matcherDigits = patternDigits.matcher(command);
                int km = 0;
                while (matcherDigits.find()) {
                    km += Integer.parseInt(matcherDigits.group());
                }
                int newDistance = rice.get(sb.toString()) + km;
                rice.put(sb.toString(), newDistance);
            }
            command = scan.nextLine();
        }
        List<String> count = new ArrayList<>() {
            {
                add("1st place:");
                add("2nd place:");
                add("3rd place:");
            }};

        rice.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(3)
                .forEach(element -> System.out.println(String.format("%s %s", count.remove(0),
                        element.getKey())));
    }
}
