import java.util.*;

public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> heroes = new TreeMap<>();

        String command = scan.nextLine();
        while(!"End".equals(command)) {
            String[] tokens = command.split("\\s+");
            String heroName = tokens[1];
            switch(tokens[0]) {
                case "Enroll":
                    if (heroes.containsKey(heroName)) {
                        System.out.println(heroName + " is already enrolled.");
                    } else {
                        heroes.putIfAbsent(heroName, new ArrayList<>());
                    }
                    break;
                case "Learn":
                    String spellName = tokens[2];
                    if (heroes.containsKey(heroName)) {
                        if (heroes.get(heroName).contains(spellName)) {
                            System.out.println(heroName + " has already learnt " + spellName + ".");
                        } else {
                            heroes.get(heroName).add(spellName);
                        }
                    } else {
                        System.out.println(heroName + " doesn't exist.");
                    }
                    break;
                case "Unlearn":
                    spellName = tokens[2];
                    if (heroes.containsKey(heroName)) {
                        if (heroes.get(heroName).contains(spellName)) {
                            heroes.get(heroName).remove(spellName);
                        } else {
                            System.out.println(heroName + " doesn't know " + spellName + ".");
                        }
                    } else {
                        System.out.println(heroName + " doesn't exist.");
                    }
                    break;
            }
            command = scan.nextLine();
        }

        System.out.println("Heroes:");
        heroes.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    return Integer.compare(e2.getValue().size(), e1.getValue().size());
                })
                .forEach(element -> {
                    System.out.println("== " + element.getKey() + ": " + element.getValue().toString()
                    .replaceAll("[\\[\\]]", ""));
                });
    }
}
