import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashSet<String>> hands = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> players = new LinkedHashMap<>();

        String command = scan.nextLine();
        while(!"JOKER".equals(command)) {
            String[] tokens = command.split(": ");
            String name = tokens[0];
            hands.putIfAbsent(name, new LinkedHashSet<>());

            String[] cardsOfPlayer = tokens[1].split(", ");
            hands.get(name).addAll(Arrays.asList(cardsOfPlayer));

            LinkedHashSet<String> cards = hands.get(name);
            int power = calculateThePower(cards);
            players.put(name, power);
            command = scan.nextLine();
        }

        players.entrySet().forEach(e -> {
            System.out.println(e.getKey() + ": " + e.getValue());
        });
    }

    private static int calculateThePower(LinkedHashSet<String> cards) {
        int power = 0;

        HashMap<Character, Integer> powerAndType = new HashMap<>();
        powerAndType.put('2', 2);
        powerAndType.put('3', 3);
        powerAndType.put('4', 4);
        powerAndType.put('5', 5);
        powerAndType.put('6', 6);
        powerAndType.put('7', 7);
        powerAndType.put('8', 8);
        powerAndType.put('9', 9);
        powerAndType.put('J', 11);
        powerAndType.put('Q', 12);
        powerAndType.put('K', 13);
        powerAndType.put('A', 14);
        powerAndType.put('S', 4);
        powerAndType.put('H', 3);
        powerAndType.put('D', 2);
        powerAndType.put('C', 1);

        for (String card : cards) {
            if (card.contains("10")) {
                power += 10 * powerAndType.get(card.charAt(2));
            } else {
                char cardPower = card.charAt(0);
                char type = card.charAt(1);
                power += powerAndType.get(cardPower) * powerAndType.get(type);
            }
        }
        return power;
    }
}
