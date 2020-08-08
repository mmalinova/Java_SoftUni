import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String regex = "([@#])(?<firstLetter>[A-Za-z]{3,})\\1\\1(?<secondLetter>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> stringList = new ArrayList<>();

        int count = 0;
        while (matcher.find()) {
            count++;
            StringBuilder firstLetter = new StringBuilder(matcher.group("firstLetter"));
            StringBuilder secondLetter = new StringBuilder(matcher.group("secondLetter")).reverse();

            if (firstLetter.toString().equals(secondLetter.toString())) {
                stringList.add(firstLetter.toString() + " <=> " + secondLetter.reverse());
            }
        }
        if (count == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(String.format("%d word pairs found!", count));
        }
        if (stringList.size() == 0) {
             System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            String toPrint = stringList.toString().replaceAll("[\\[\\]]", "");
            System.out.println(toPrint);
        }
    }
}
