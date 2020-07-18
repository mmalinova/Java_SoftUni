import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double income = Double.parseDouble(scan.nextLine());
        double marks = Double.parseDouble(scan.nextLine());
        double salary = Double.parseDouble(scan.nextLine());
        double socialS = Math.floor(0.35 * salary);
        double excellentS = Math.floor(marks * 25);

        if (income < salary && marks > 4.5 && marks < 5.5) {
                System.out.printf("You get a Social scholarship %.0f BGN", socialS);
        } else if (marks >= 5.5 && income < salary) {
            if (socialS <= excellentS) {
                System.out.printf("You get a scholarship for excellent results %.0f BGN", excellentS);
            } else if (socialS > excellentS) {
                System.out.printf("You get a Social scholarship %.0f BGN", socialS);
            }
        } else if (marks >= 5.5) {
            System.out.printf("You get a scholarship for excellent results %.0f BGN", excellentS);
        } else {
            System.out.println("You cannot get a scholarship!");
        }
    }
}
