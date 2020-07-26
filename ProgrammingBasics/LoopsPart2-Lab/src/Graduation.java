import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        int n = 0;
        double marks = 0;
        double sum = 0;

        while (n < 12) {
            double mark = Double.parseDouble(scan.nextLine());
            if (mark >= 4) {
                n++;
                sum += mark;
            }
        }
        marks = sum / 12;
        System.out.printf("%s graduated. Average grade: %.2f", name, marks);
    }
}
