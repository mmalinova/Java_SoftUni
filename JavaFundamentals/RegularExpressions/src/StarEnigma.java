import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> attackedPlanet = new ArrayList<>();
        List<String> destroyedPlanet = new ArrayList<>();

        String lowerCase = "[star]";
        String upperCase = "[STAR]";
        String regex = "@(?<planetName>[A-Z]+[a-z]+)[^\\@\\-\\!\\:\\>]*?:(?<population>\\d+)[^\\@\\-\\!\\:\\>]*?\\!" +
                "(?<attackType>[AD])\\![^\\@\\-\\!\\:\\>]*?->(?<soldierCount>\\d+)";

        Pattern patternL = Pattern.compile(lowerCase);
        Pattern patternU = Pattern.compile(upperCase);
        Pattern patternReg = Pattern.compile(regex);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String message = scan.nextLine();
            Matcher matcherL = patternL.matcher(message);
            Matcher matcherH = patternU.matcher(message);
            int count = 0;
            while (matcherL.find() || matcherH.find()) {
                count++;
            }
            for (int j = 0; j < message.length(); j++) {
                sb.append((char)(message.charAt(j) - count));
            }
            Matcher matcherReg = patternReg.matcher(sb.toString());
            if (matcherReg.find()) {
                String planetName = matcherReg.group("planetName");
                String population = matcherReg.group("population");
                String attackType = matcherReg.group("attackType");
                String soldierCount = matcherReg.group("soldierCount");
                switch (attackType) {
                    case "A":
                        attackedPlanet.add(planetName);
                        break;
                    case "D":
                        destroyedPlanet.add(planetName);
                        break;
                }
            }
        }
        System.out.println(String.format("Attacked planets: %d", attackedPlanet.size()));
        attackedPlanet.stream()
                .sorted(String::compareTo)
                .forEach(element -> System.out.println(String.format("-> %s", element)));

        System.out.println(String.format("Destroyed planets: %d", destroyedPlanet.size()));
        destroyedPlanet.stream()
                .sorted(String::compareTo)
                .forEach(element -> System.out.println(String.format("-> %s", element)));
    }
}
