import java.util.Scanner;

public class GraduationPart2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        int n = 1;
        double marks = 0;
        double sum = 0;
        int excluded = 0;

        while (n <= 12) {
            double mark = Double.parseDouble(scan.nextLine());
            if (mark >= 4) {
                n++;
                sum += mark;
            } else {
                excluded++;
                if (excluded >= 2) {
                    System.out.printf("%s has been excluded at %d grade", name, n);
                    break;
                }
            }
        }
        if (excluded < 2) {
            marks = sum / 12;
            System.out.printf("%s graduated. Average grade: %.2f", name, marks);
        }
    }
}
