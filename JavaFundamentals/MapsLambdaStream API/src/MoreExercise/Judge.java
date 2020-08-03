package MoreExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, TreeMap<String, Integer>> contests = new LinkedHashMap<>();
        String input;

        while (!"no more time".equals(input = scan.nextLine())) {

            String[] inputLine = input.split(" -> ");

            String name = inputLine[0];
            String contest = inputLine[1];
            int points = Integer.parseInt(inputLine[2]);

            contests.putIfAbsent(contest, new TreeMap<>());
            contests.get(contest).putIfAbsent(name, -1);
            if (contests.get(contest).get(name) < points) {
                contests.get(contest).put(name, points);
            }
        }
        AtomicInteger num = new AtomicInteger(1);

        contests.entrySet()
                .forEach(e -> {
            num.set(1);
            System.out.println(e.getKey() + ": " + e.getValue().size() + " participants");
            e.getValue()
                    .entrySet()
                    .stream()
                    .sorted((k2, k1) -> Integer.compare(k1.getValue(), k2.getValue()))
                    .forEach(element -> {
                System.out.printf("%d. %s <::> %d\n", num.getAndIncrement(), element.getKey(), element.getValue());
            });
        });

        Map<String, Integer> standings = new TreeMap<>();

        for(Map.Entry<String, TreeMap<String, Integer>> wtf : contests.entrySet()) {
            for (Map.Entry<String, Integer> lol : wtf.getValue().entrySet()) {
                standings.putIfAbsent(lol.getKey(), 0);
                standings.put(lol.getKey(), standings.get(lol.getKey()) + lol.getValue());
            }
        }
        System.out.println("Individual standings:");
        num.set(1);

        standings.entrySet()
                .stream()
                .sorted((e2, e1) -> Integer.compare(e1.getValue(), e2.getValue()))
                .forEach(element -> {
            System.out.printf("%d. %s -> %d\n", num.getAndIncrement(), element.getKey(), element.getValue());
        });
    }
}
