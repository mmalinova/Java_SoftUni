import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int studentsForFirst = Integer.parseInt(scan.nextLine());
        int studentsForSecond = Integer.parseInt(scan.nextLine());
        int studentsForThird = Integer.parseInt(scan.nextLine());
        int studentsCount = Integer.parseInt(scan.nextLine());

        int perHour = studentsForFirst + studentsForSecond + studentsForThird;
        int timeNeeded = 0;
        int leftPeople = studentsCount;
        if (studentsCount > 0) {
            timeNeeded = 1;
            leftPeople -= perHour;
            while (leftPeople > 0) {
                leftPeople -= perHour;
                timeNeeded++;
                if (timeNeeded % 4 == 0) {
                    timeNeeded++;
                }
            }
        }
        System.out.printf("Time needed: %dh.", timeNeeded);
    }
}
