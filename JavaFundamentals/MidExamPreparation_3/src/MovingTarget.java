import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            sequence.add(Integer.parseInt(input[i]));
        }

        int countShoot = 0;
        String commands = scan.nextLine();
        while(!"End".equals(commands)) {
            String[] tokens = commands.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Shoot":
                    int index = Integer.parseInt(tokens[1]);
                    int power = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < sequence.size()) {
                        int value = sequence.get(index) - power;
                        if (value <= 0) {
                            sequence.remove(index);
                        } else {
                            sequence.set(index, value);
                        }
                    }
                    break;
                case "Add":
                    index = Integer.parseInt(tokens[1]);
                    int value = Integer.parseInt(tokens[2]);
                    if (index < 0 || index >= sequence.size()) {
                        System.out.println("Invalid placement!");
                    } else {
                        sequence.add(index, value);
                    }
                    break;
                case "Strike":
                    index = Integer.parseInt(tokens[1]);
                    int radius = Integer.parseInt(tokens[2]);
                    if (index < 0 || index >= sequence.size() || index - radius < 0 || index + radius >= sequence.size()) {
                        System.out.println("Strike missed!");
                    } else {
                        int left = Math.max(0, index - radius);
                        int right = Math.min(sequence.size() - 1, index + radius);

                        for (int i = right; i >= left; i--) {
                            sequence.remove(i);
                        }
                    }
                    break;
            }
            commands = scan.nextLine();
        }
        List<String> output = new ArrayList<>();
        for (int i = 0; i < sequence.size(); i++) {
            output.add(sequence.get(i).toString());
        }
        System.out.printf(String.join("|", output));
    }
}
