import java.util.Scanner;

public class Spaceship1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double width = Double.parseDouble(scan.nextLine());
        double length = Double.parseDouble(scan.nextLine());
        double height = Double.parseDouble(scan.nextLine());
        double heightAstr = Double.parseDouble(scan.nextLine());

        double volume = width * length * height;
        double area = 2 * 2 * (heightAstr + 0.40);
        double number = Math.floor(volume / area);

        if (number >= 3 && number <= 10) {
            System.out.printf("The spacecraft holds %.0f astronauts.", number);
        } else if (number < 3) {
            System.out.printf("The spacecraft is too small.");
        } else {
            System.out.printf("The spacecraft is too big.");
        }
    }
}
