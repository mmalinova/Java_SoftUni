import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "\\s([^\\.\\-\\_\\s])?(?<user>[^\\.\\-\\_\\s][A-Za-z]*\\d*[\\.\\-\\_]?[A-Za-z]*\\d*[^\\.\\-\\_\\s])" +
                "\\1?@\\1?(?<host>[^\\.\\-\\_\\s][A-Za-z]+\\-?[A-za-z]+(\\.[A-Za-z]+\\-?[A-Za-z]+)+)";

        String input = scan.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group().trim());
        }
    }
}
