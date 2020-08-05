import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scan.nextLine());

        int count = 0;
        int myEnergy = initialEnergy;
        String command = scan.nextLine();
        while (!"End of battle".equals(command)) {
            int distance = Integer.parseInt(command);
            int needEnergy = distance;
            if (myEnergy < needEnergy) {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", count, myEnergy);
                return;
            } else {
                count++;
                if (count % 3 == 0) {
                    myEnergy += count;
                }
            }
            myEnergy -= needEnergy;
            if (initialEnergy <= 0) {
                break;
            }
            command = scan.nextLine();
        }
        if ("End of battle".equals(command)) {
            System.out.printf("Won battles: %d. Energy left: %d", count, myEnergy);
        }
    }
}
