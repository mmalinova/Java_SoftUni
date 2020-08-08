import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Integer>> cities = new TreeMap<>();

        String input = scan.nextLine();
        while(!"Sail".equals(input)) {
            String[] tokens = input.split("\\|\\|");
            String city = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2].trim());
            if (cities.containsKey(city)) {
                int oldPopulation = cities.get(city).remove(0);
                cities.get(city).add(0, oldPopulation + population);
                int oldGold = cities.get(city).remove(1);
                cities.get(city).add(1, oldGold + gold);
            } else {
                cities.put(city, new ArrayList<>());
                cities.get(city).add(0, population);
                cities.get(city).add(1, gold);
            }
            input = scan.nextLine();
        }
        String command = scan.nextLine();
        while(!"End".equals(command)) {
            String[] tokens = command.split("=>");
            String town = tokens[1];
            switch (tokens[0]) {
                case "Plunder":
                    int people = Integer.parseInt(tokens[2].trim());
                    int gold = Integer.parseInt(tokens[3].trim());
                    int oldPeople = cities.get(town).remove(0);
                    cities.get(town).add(0, oldPeople - people);
                    int oldGold = cities.get(town).remove(1);
                    cities.get(town).add(1, oldGold - gold);
                    System.out.println(town + " plundered! " + gold + " gold stolen, " + people + " citizens killed.");
                    if (cities.get(town).get(0) <= 0 || cities.get(town).get(1) <= 0) {
                        cities.remove(town);
                        System.out.println(town + " has been wiped off the map!");
                    }
                    break;
                case "Prosper":
                    gold = Integer.parseInt(tokens[2].trim());
                    if (gold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        oldGold = cities.get(town).remove(1);
                        cities.get(town).add(1, oldGold + gold);
                        System.out.println(gold + " gold added to the city treasury. " + town + " now has " +
                                 + cities.get(town).get(1) + " gold.");
                    }
                    break;
            }
            command = scan.nextLine();
        }
        if (cities.size() > 0) {
            System.out.println("Ahoy, Captain! There are " + cities.size() + " wealthy settlements to go to:");
            cities.entrySet()
                    .stream()
                    .sorted((e1, e2) -> {
                        return e2.getValue().get(1).compareTo(e1.getValue().get(1));
                    })
                    .forEach(element -> {
                        System.out.println(element.getKey() + " -> Population: " + element.getValue().get(0) +
                                " citizens, Gold: " + element.getValue().get(1) + " kg");
                    });
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
