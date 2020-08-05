import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int[] sequence = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            sequence[i] = Integer.parseInt(input[i]);
        }

        int countShoot = 0;
        String command = scan.nextLine();
        while(!"End".equals(command)) {
            int index = Integer.parseInt(command);
            int value = 0;
            if (index >= 0 && index < sequence.length) {
                if (sequence[index] != -1) {
                    value = sequence[index];
                    sequence[index] = -1;
                    countShoot++;
                    for (int i = 0; i < index; i++) {
                        if (sequence[i] != -1) {
                            if (sequence[i] > value) {
                                sequence[i] -= value;
                            } else {
                                sequence[i] += value;
                            }
                        }
                    }
                    for (int i = index + 1; i < sequence.length; i++) {
                        if (sequence[i] != -1) {
                            if (sequence[i] > value) {
                                sequence[i] -= value;
                            } else {
                                sequence[i] += value;
                            }
                        }
                    }
                }
            }
            command = scan.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", countShoot);
        for (int i = 0; i < sequence.length; i++) {
            System.out.printf("%d ", sequence[i]);
        }
    }
}
