import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        List<Integer> wagons = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            wagons.add(Integer.parseInt(input[i]));
        }
        int capacity = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();
        while(!"end".equals(command)) {
            String[] tokens = command.split("\\s+");
            if (tokens[0].equals("Add")) {
                wagons.add(Integer.parseInt(tokens[1]));
            } else {
                for (int i = 0; i < wagons.size(); i++) {
                    if (Integer.parseInt(tokens[0]) + wagons.get(i) <= capacity) {
                        wagons.set(i, Integer.parseInt(tokens[0]) + wagons.get(i));
                        break;
                    }
                }
            }
            command = scan.nextLine();
        }
        for (int i: wagons) {
            System.out.printf("%d ", i);
        }
    }
}
