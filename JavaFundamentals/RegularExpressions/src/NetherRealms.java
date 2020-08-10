import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(",\\s*");
        Map<String, List<Double>> demons = new TreeMap<>();

        double health = 0.0;
        double damage = 0.0;

        String damageRegex = "\\-?\\+?\\d+\\.?\\d*";
        String healthRegex = "[^\\d*+\\-*\\/.\\s]";

        Pattern patternD = Pattern.compile(damageRegex);
        Pattern patternH = Pattern.compile(healthRegex);

        for (String s : input) {
                s = s.replaceAll("[,\\s+]", "");
                health = 0;
                damage = 0;

                Matcher matcherD = patternD.matcher(s);
                while (matcherD.find()) {
                    damage += Double.parseDouble(matcherD.group());
                }
                Matcher matcherH = patternH.matcher(s);
                while (matcherH.find()) {
                    health += matcherH.group().charAt(0);
                }
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == '*') {
                        damage *= 2;
                    } else if (s.charAt(j) == '/') {
                        damage /= 2;
                    }
                }

                demons.putIfAbsent(s, new ArrayList<>());
                demons.get(s).add(health);
                demons.get(s).add(damage);
        }

        for (Map.Entry<String, List<Double>> entry : demons.entrySet()) {
            System.out.printf("%s - ", entry.getKey());
            List<Double> print = entry.getValue();
            System.out.printf("%.0f health, ", print.remove(0));
            System.out.printf("%.2f damage%n", print.remove(0));
        }
    }
}
