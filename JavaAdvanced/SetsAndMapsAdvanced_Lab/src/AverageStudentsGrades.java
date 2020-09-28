import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, ArrayList<Double>> students = new TreeMap<String, ArrayList<Double>>();

        int numberOfStudents = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < numberOfStudents; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String name= input[0];
            double grade = Double.parseDouble(input[1]);

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        for (Map.Entry<String, ArrayList<Double>> entry : students.entrySet()) {
            double sum = 0;
            System.out.print(String.format("%s -> ", entry.getKey()));
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.print(String.format("%.2f ", entry.getValue().get(i)));
                sum += entry.getValue().get(i);
            }
            System.out.print(String.format("(avg: %.2f)", sum/entry.getValue().size()));
            System.out.println();
        }
    }
}
