package MoreExercise;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, TreeMap<String, List<Integer>>> dragons = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            //{type} {name} {damage} {health} {armor}
            //default -> : health 250, damage 45 and armor 10
            String type = input[0];
            String name = input[1];
            String damage = input[2];
            if ("null".equals(damage)) {
                damage = "45";
            }
            String health = input[3];
            if ("null".equals(health)) {
                health = "250";
            }
            String armor = input[4];
            if ("null".equals(armor)) {
                armor = "10";
            }
            dragons.putIfAbsent(type, new TreeMap<>());
            List<Integer> stats = new LinkedList<>();
            stats.add(Integer.parseInt(damage));
            stats.add(Integer.parseInt(health));
            stats.add(Integer.parseInt(armor));
            dragons.get(type).put(name, stats);
        }
        for (Map.Entry<String, TreeMap<String, List<Integer>>> entry : dragons.entrySet()) {
            double avgDamage = 0.0;
            double avgHealth = 0.0;
            double avgArmor = 0.0;
            int count = 0;

            for (Map.Entry<String, List<Integer>> subEntry : entry.getValue().entrySet()) {
                List<Integer> dragonStats = subEntry.getValue();
                avgDamage += dragonStats.get(0);
                avgHealth += dragonStats.get(1);
                avgArmor += dragonStats.get(2);
                count++;
            }
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), avgDamage/count, avgHealth/count, avgArmor/count);

            entry
                    .getValue()
                    .forEach((key, value) -> {
                        double dragonDamage = value.get(0);
                        double dragonHealth = value.get(1);
                        double dragonArmor = value.get(2); 
                        System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n", key, dragonDamage, dragonHealth, dragonArmor);
                    });
        }

    }
}
