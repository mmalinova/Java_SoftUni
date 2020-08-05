import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\@");
        int[] neighborhood = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            neighborhood[i] = Integer.parseInt(input[i]);
        }

        int length = 0;
        int current = 0;
        String commands = scan.nextLine();
        while(!"Love!".equals(commands)) {
            String[] tokens = commands.split("\\s+");
            length = Integer.parseInt(tokens[1]);
            current += length;
            if (current < 0 || current >= neighborhood.length) {
                current = 0;
            }
            if (neighborhood[current] <= 0) {
                System.out.printf("Place %d already had Valentine's day.%n", current);
            }
            neighborhood[current] -= 2;
            if (neighborhood[current] == 0) {
                System.out.printf("Place %d has Valentine's day.%n", current);
            }
            commands = scan.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", current);
        int count = 0;
        for (int i = 0; i < neighborhood.length; i++) {
            if (neighborhood[i] > 0) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", count);
        }
    }
}
