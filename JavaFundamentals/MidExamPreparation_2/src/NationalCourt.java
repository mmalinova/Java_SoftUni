import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int peopleForFirst = Integer.parseInt(scan.nextLine());
        int peopleForSecond = Integer.parseInt(scan.nextLine());
        int peopleForThird = Integer.parseInt(scan.nextLine());
        int totalPeople = Integer.parseInt(scan.nextLine());

        int peoplePerHour = peopleForFirst + peopleForSecond + peopleForThird;
        int leftPeople = totalPeople;
        int totalTime = 0;
        if (totalPeople > 0) {
            totalTime = 1;
            leftPeople -= peoplePerHour;
            while (leftPeople > 0) {
                leftPeople -= peoplePerHour;
                totalTime++;
                if (totalTime % 4 == 0) {
                    totalTime++;
                }
            }
        }
        System.out.printf("Time needed: %dh.", totalTime);
    }
}
