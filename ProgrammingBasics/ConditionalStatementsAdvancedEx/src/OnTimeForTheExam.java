import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hourExam = Integer.parseInt(scan.nextLine());
        int minExam = Integer.parseInt(scan.nextLine());
        int hourArr = Integer.parseInt(scan.nextLine());
        int minArr = Integer.parseInt(scan.nextLine());

        int exam = (hourExam * 60) + minExam;
        int arr = (hourArr * 60) + minArr;

        int difference = exam - arr;

        if (difference > 0) {
            if (difference <= 30) {
                System.out.println("On time");
                System.out.printf("%d minutes before the start", difference);
            }
            else if (difference < 60){
                System.out.println("Early");
                System.out.printf("%d minutes before the start", difference);
            }
            else if (difference > 59) {
                int hours = difference / 60;
                int mins = difference % 60;
                System.out.println("Early");
                System.out.printf("%d:%02d hours before the start", hours, mins);
            }
        } else if (difference < 0) {
            int minsLate = Math.abs(difference);
            if (minsLate < 60) {
                System.out.println("Late");
                System.out.printf("%d minutes after the start", minsLate);
            }
            else if (minsLate > 59) {
                int hours = minsLate / 60;
                int mins = minsLate % 60;
                System.out.println("Late");
                System.out.printf("%d:%02d hours after the start", hours, mins);
            }
        }
        else {
            System.out.println("On time");
        }
    }
}
