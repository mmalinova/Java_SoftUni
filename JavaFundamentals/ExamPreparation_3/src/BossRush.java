import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String regex = "\\|(?<boss>[A-Z]{4,})\\|:#(?<title>[A-Za-z]+ [A-Za-z]+)#";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String bossName = matcher.group("boss");
                String title = matcher.group("title");
                System.out.println(bossName + ", The " + title);
                System.out.println(">> Strength: " + bossName.length());
                System.out.println(">> Armour: " + title.length());
            } else {
                System.out.println("Access denied!");
            }
        }
    }
}
