import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> course = new LinkedHashMap<>();
        String command = scan.nextLine();
        while(!"end".equals(command)) {
            String[] input = command.split(" : ");
            String courseName = input[0];
            String studentName = input[1];
            course.putIfAbsent(courseName, new ArrayList<>());
            List<String> students = course.get(courseName);
            students.add(studentName);
            //course.get(courseName).add(studentName);
            command = scan.nextLine();
        }

        course.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(e -> {
                    System.out.println(String.format("%s: %d", e.getKey(), e.getValue().size()));
                    e.getValue()
                            .stream()
                            .sorted((e1, e2) -> e1.compareTo(e2))
                            .forEach(v -> System.out.println(String.format("-- %s", v)));
                });
    }
}
