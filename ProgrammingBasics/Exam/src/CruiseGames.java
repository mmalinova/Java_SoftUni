import java.util.Scanner;

public class CruiseGames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        int num = Integer.parseInt(scan.nextLine());

        double vPoints = 0;
        int countV = 0;
        double tPoints = 0;
        int countT = 0;
        double bPoints = 0;
        int countB = 0;
        double allPoints = 0;

        for (int i = 0; i < num; i++) {
            String type = scan.nextLine();
            int points = Integer.parseInt(scan.nextLine());
            switch (type) {
                case "volleyball":
                    countV++;
                    vPoints += points + points * 0.07;
                    break;
                case "tennis":
                    countT++;
                    tPoints += points + points * 0.05;
                    break;
                case "badminton":
                    countB++;
                    bPoints += points + points * 0.02;
                    break;
            }
        }
            allPoints = Math.floor(vPoints + tPoints + bPoints);
            double vAvg = vPoints / countV;
            double tAvg = tPoints / countT;
            double bAvg = bPoints / countB;

            if (vAvg >= 75 && tAvg >= 75 && bAvg >= 75) {
                System.out.printf("Congratulations, %s! You won the cruise games with %.0f points.", name, allPoints);
            } else {
                System.out.printf("Sorry, %s, you lost. Your points are only %.0f.", name, allPoints);
            }
    }
}
