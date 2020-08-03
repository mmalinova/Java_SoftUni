package MoreExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> playerPool = new TreeMap<>();

        String command = scan.nextLine();
        while(!"Season end".equals(command)) {
            if (command.contains("->")) {
                String[] input = command.split("->");
                String playerName = input[0].trim();
                String playerPosition = input[1].trim();
                int skills = Integer.parseInt(input[2].trim());
                playerPool.putIfAbsent(playerName, new TreeMap<>());
                playerPool.get(playerName).putIfAbsent(playerPosition, skills);
                if (playerPool.get(playerName).get(playerPosition) < skills) {
                    playerPool.get(playerName).put(playerPosition, skills);
                }

            } else {
                String[] input = command.split("vs");
                String first = input[0].trim();
                String second = input[1].trim();
                if (playerPool.containsKey(first) && playerPool.containsKey(second)) {
                    Map<String, Integer> firstMap = playerPool.get(first);
                    Map<String, Integer> secondMap = playerPool.get(second);
                    for (Map.Entry<String, Integer> entry : firstMap.entrySet()) {
                        for (Map.Entry<String, Integer> e : secondMap.entrySet()) {
                            if (entry.getKey().compareTo(e.getKey()) == 0) {
                                if (entry.getValue().compareTo(e.getValue()) < 0) {
                                    playerPool.remove(first);
                                } else if (entry.getValue().compareTo(e.getValue()) > 0) {
                                    playerPool.remove(second);
                                }
                            }
                        }
                    }
                }
            }
            command = scan.nextLine();
        }

        playerPool.entrySet().stream().sorted((e1, e2) -> {
            int res = Integer.compare(e2.getValue().values().stream().mapToInt(Integer::intValue).sum(),
                    e1.getValue().values().stream().mapToInt(Integer::intValue).sum());
            return res;
        })
                .forEach(element -> {
                    System.out.printf("%s: %d skill%n", element.getKey(), element.getValue().values().stream()
                            .mapToInt(Integer::intValue).sum());
                    element.getValue().entrySet().stream().sorted((k2, k1) -> {
                        int sort = Integer.compare(k1.getValue(), k2.getValue());
                        return sort;
                    }).forEach(value -> System.out.printf("- %s <::> %d\n", value.getKey(), value.getValue()));
                });
    }
}
