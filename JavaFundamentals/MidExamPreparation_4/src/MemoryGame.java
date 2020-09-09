import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> seq = new ArrayList<>();

        String[] sequence = scan.nextLine().split("\\s+");
        for (int i = 0; i < sequence.length; i++) {
            seq.add(sequence[i]);
        }

        int num = 0;
        String command = scan.nextLine();
        while (!"end".equals(command)) {
            String[] integers = command.split("\\s+");
            num++;
            int firstIndex = Math.min(Integer.parseInt(integers[0]), Integer.parseInt(integers[1]));
            int secondIndex = Math.max(Integer.parseInt(integers[0]), Integer.parseInt(integers[1]));
            if (firstIndex == secondIndex || firstIndex < 0 || secondIndex >= seq.size()) {
                String element = "-" + num + "a";
                int middle = seq.size() / 2;
                seq.add(middle, element);
                seq.add(middle + 1, element);
                System.out.println("Invalid input! Adding additional elements to the board");
            } else {
                if (seq.get(firstIndex).equals(seq.get(secondIndex))) {
                    seq.remove(firstIndex);
                    System.out.println(String.format("Congrats! You have found matching elements - %s!",
                            seq.remove(secondIndex - 1)));
                } else {
                    System.out.println("Try again!");
                }
                if (seq.isEmpty()) {
                    System.out.println(String.format("You have won in %d turns!", num));
                    break;
                }
            }
                command = scan.nextLine();
        }
        if (!seq.isEmpty()) {
            System.out.println("Sorry you lose :(");
            System.out.println(seq.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
