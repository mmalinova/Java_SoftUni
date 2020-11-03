package greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long capacity = Long.parseLong(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(capacity);

        for (int i = 0; i < input.length; i += 2) {
            String name = input[i];
            long amount = Long.parseLong(input[i + 1]);

            if (name.length() == 3) {
                Cash cash = new Cash(name, amount);
                bag.addCash(cash);
            } else if (name.toLowerCase().endsWith("gem")) {
                Gem gem = new Gem(name, amount);
                bag.addGem(gem);
            } else if (name.toLowerCase().equals("gold")) {
                Gold gold = new Gold(name, amount);
                bag.addGold(gold);
            }
        }

        System.out.println(bag.toString());
    }
}