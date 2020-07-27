import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        double sum = 0;
        double average = 0;
        double averageAll = 0;
        int count = 0;

        String name = scan.nextLine();
        while (!name.equals("Finish")) {
            for (int i = 0; i < n; i++) {
                double mark = Double.parseDouble(scan.nextLine());
                sum += mark;
            }
            average = sum / n;
            System.out.printf("%s - %.2f.%n", name, average);
            averageAll += average;
            name = scan.nextLine();
            average = 0;
            sum = 0;
            count++;
        }
        System.out.printf("Student's final assessment is %.2f.%n", averageAll / count);
    }
}
