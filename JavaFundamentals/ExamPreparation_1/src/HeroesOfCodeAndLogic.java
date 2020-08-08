import java.util.*;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Integer>> heroes = new TreeMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String heroName = input[0];
            int HP = Integer.parseInt(input[1]);
            int MP = Integer.parseInt(input[2]);
            heroes.putIfAbsent(heroName, new ArrayList<>());
            heroes.get(heroName).add(0, HP);
            heroes.get(heroName).add(1, MP);
        }
        String command = scan.nextLine();
        while (!"End".equals(command)) {
            String[] tokens = command.split(" - ");
            String name = tokens[1];
            switch (tokens[0]) {
                case "CastSpell":
                    int neededMP = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    if (heroes.get(name).get(1) >= neededMP) {
                        int oldMP = heroes.get(name).remove(1);
                        heroes.get(name).add(1, oldMP - neededMP);
                        System.out.println(String.format("%s has successfully cast %s and now has" +
                                " %d MP!", name, spellName, heroes.get(name).get(1)));
                    } else {
                        System.out.println(String.format("%s does not have enough MP to cast %s!",
                                name, spellName));
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    int oldHP = heroes.get(name).remove(0);
                    heroes.get(name).add(0, oldHP - damage);
                    if (heroes.get(name).get(0) > 0) {
                        System.out.println(String.format("%s was hit for %d HP by %s" +
                                " and now has %d HP left!", name, damage, attacker, heroes.get(name).get(0)));
                    } else {
                        heroes.remove(name);
                        System.out.println(String.format("%s has been killed by %s!", name, attacker));
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(tokens[2]);
                    int oldMP = heroes.get(name).remove(1);
                    int newMP = oldMP + amount;
                    if (newMP >= 200) {
                        heroes.get(name).add(1, 200);
                        System.out.println(String.format("%s recharged for %d MP!",
                                name, 200 - oldMP));
                    } else {
                        heroes.get(name).add(1, newMP);
                        System.out.println(String.format("%s recharged for %d MP!",
                                name, amount));
                    }
                    break;
                case "Heal":
                    amount = Integer.parseInt(tokens[2]);
                    oldHP = heroes.get(name).remove(0);
                    int newHP = oldHP + amount;
                    if (newHP >= 100) {
                        heroes.get(name).add(0, 100);
                        System.out.println(String.format("%s healed for %d HP!",
                                name, 100 - oldHP));
                    } else {
                        heroes.get(name).add(0, newHP);
                        System.out.println(String.format("%s healed for %d HP!",
                                name, amount));
                    }
                    break;
            }
            command = scan.nextLine();
        }
        heroes.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    return e2.getValue().get(0).compareTo(e1.getValue().get(0));
                })
                .forEach(element -> {
                    System.out.println(String.format("%s%n  HP: %d%n  MP: %d", element.getKey(),
                            element.getValue().get(0), element.getValue().get(1)));
                });
    }
}
