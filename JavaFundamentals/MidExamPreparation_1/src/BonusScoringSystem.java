import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countStudents = Integer.parseInt(scan.nextLine());
        int countLectures = Integer.parseInt(scan.nextLine());
        int additionBonus = Integer.parseInt(scan.nextLine());

        //{total bonus} = {student attendances} / {course lectures} * (5 + {additional bonus})
        double maxBonus = 0.0;
        int hisAttendance = 0;
        double totalBonus = 0.0;
        for (int i = 0; i < countStudents; i++) {
            int attendance = Integer.parseInt(scan.nextLine());
            if (countLectures != 0) {
                totalBonus = ((1.0 * attendance / countLectures) * (5 + additionBonus));
            }
            if (totalBonus >= maxBonus) {
                maxBonus = totalBonus;
                hisAttendance = attendance;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.", hisAttendance);
    }
}
