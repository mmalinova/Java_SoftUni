import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Double>> students = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            Double grade = Double.parseDouble(scan.nextLine());
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        students.entrySet()
                .stream()
                .filter(e -> e.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0) >= 4.50)
                .sorted((e1, e2) -> {
                    double first = e1.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0);
                    double second = e2.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0);

                    return Double.compare(second, first);
                })
                .forEach(v -> System.out.println(String.format("%s -> %.2f", v.getKey(),
                        v.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0))));
    }
}
