import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int marks = Integer.parseInt(scan.nextLine());
        String last = "";
        int number = 0;
        double average = 0;
        int all = 0;
        int sum = 0;

        while (marks > number) {
            String name = scan.nextLine();
            if (name.equals("Enough")) {
                System.out.printf("Average score: %.2f%n", average);
                System.out.printf("Number of problems: %d%n", all);
                System.out.printf("Last problem: %s", last);
                break;
            }
            last = name;
            int mark = Integer.parseInt(scan.nextLine());
            if (mark <= 4)
                number++;
            sum += mark;
            all++;
            average = sum * 1.0 / all;
        }
        if (marks <= number)
            System.out.printf("You need a break, %d poor grades.", number);
    }
}
