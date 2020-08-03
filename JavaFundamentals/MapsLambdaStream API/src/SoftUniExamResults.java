import java.util.*;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> languages = new TreeMap<>();
        Map<String, Integer> points = new TreeMap<>();

        String command = scan.nextLine();
        while(!"exam finished".equals(command)) {
            String[] input = command.split("-");
            String username = input[0];
            String language = input[1];

            if ("banned".equals(input[1])) {
                points.remove(username);
            } else {
                int point = Integer.parseInt(input[2]);
                points.putIfAbsent(username, point);
                if (points.containsKey(username) && points.get(username) < point) {
                    points.put(username, point);
                }

                languages.putIfAbsent(language, new ArrayList<>());
                languages.get(language).add(username);
            }
            command = scan.nextLine();
        }
        System.out.println("Results:");
        points.entrySet()
                .stream()
                .sorted((v1, v2) -> Integer.compare(v2.getValue(), v1.getValue()))
                .forEach(e -> System.out.println(String.format("%s | %d", e.getKey(), e.getValue())));

        System.out.println("Submissions:");
        languages.entrySet()
                .stream()
                .sorted((v1, v2) -> Integer.compare(v2.getValue().size(), v1.getValue().size()))
                .forEach(e -> System.out.println(String.format("%s - %d", e.getKey(), e.getValue().size())));
    }
}
