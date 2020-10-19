package OpinionPoll;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, OpinionPoll> map = new TreeMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            if (age > 30) {
                OpinionPoll poll = new OpinionPoll(name, age);
                map.putIfAbsent(name, poll);
            }
        }

        map.entrySet()
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue().getAge()));
    }
}
