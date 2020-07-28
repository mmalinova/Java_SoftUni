import java.util.Scanner;

public class Spaceship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int points = Integer.parseInt(scan.nextLine());
        int count = 0;

        while (points != 0) {
            String sector = scan.nextLine();
            if (sector.equals("bullseye")) {
                count++;
                System.out.printf("Congratulations! You won the game with a bullseye in %d moves!", count);
                break;
            }
            int numPoints = Integer.parseInt(scan.nextLine());
            switch (sector) {
                case "number section":
                    points -= numPoints;
                    count++;
                    break;
                case "double ring":
                    numPoints *= 2;
                    points -= numPoints;
                    count++;
                    break;
                case "triple ring":
                    numPoints *= 3;
                    points -= numPoints;
                    count++;
                    break;
            }
            if (points < 0) {
                System.out.printf("Sorry, you lost. Score difference: %d.", Math.abs(points));
                break;
            }
        } if (points == 0) {
            System.out.printf("Congratulations! You won the game in %d moves!", count);
        }
    }
}
