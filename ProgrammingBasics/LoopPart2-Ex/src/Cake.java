import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int width = Integer.parseInt(scan.nextLine());
        int length = Integer.parseInt(scan.nextLine());
        int area = width * length;

        while (area > 0) {
            String command = scan.nextLine();
            if (command.equals("STOP")) {
                System.out.printf("%d pieces are left.", area);
                break;
            } else {
                int number = Integer.parseInt(command);;
                area -= number;
            }
        }
        if (area <= 0)
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(area));
    }
}
