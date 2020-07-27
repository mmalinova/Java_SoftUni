import java.util.Scanner;

public class Suitcases {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double capacity = Double.parseDouble(scan.nextLine());

        int number = 0;
        double leaveSpace = capacity;

        while (true) {
            String command = scan.nextLine();
            if (command.equals("End")) {
                System.out.println("Congratulations! All suitcases are loaded!");
                break;
            }
            double volume = Double.parseDouble(command);

            if (volume > leaveSpace) {
                System.out.println("No more space!");
                break;
            }
            number++;

            if (number % 3 == 0) {
                volume += volume * 0.10;
            }

            leaveSpace -= volume;

            if (leaveSpace <= 0) {
                System.out.println("No more space!");
                number--;
                break;
            }
        }
        System.out.printf("Statistic: %d suitcases loaded.", number);
    }
}
