import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, ArrayList<Double>> students = new TreeMap<>();

        int numberOfStudents = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < numberOfStudents; i++) {
            String name = scan.nextLine();
            String[] scores = scan.nextLine().split("\\s+");

            students.putIfAbsent(name, new ArrayList<>());
            for (String score : scores) {
                students.get(name).add(Double.parseDouble(score));
            }
        }

        for (Map.Entry<String, ArrayList<Double>> entry : students.entrySet()) {
            double sum = 0;
            System.out.print(String.format("%s is graduated with ", entry.getKey()));
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum += entry.getValue().get(i);
            }
            System.out.println(sum/entry.getValue().size());
        }
    }
}
