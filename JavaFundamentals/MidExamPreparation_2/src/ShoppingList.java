import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\!");
        List<String> items = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            items.add(input[i]);
        }

        String commands = scan.nextLine();
        while(!"Go Shopping!".equals(commands)) {
            String[] tokens = commands.split("\\s+");
            String command = tokens[0];
            switch ((command)) {
                case "Urgent":
                    String item = tokens[1];
                    if (!items.contains(item)) {
                        items.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    item = tokens[1];
                    if (items.contains(item)) {
                        items.remove(item);
                    }
                    break;
                case "Correct":
                    String oldItem = tokens[1];
                    String newItem = tokens[2];
                    if (items.contains(oldItem)) {
                        items.set(items.indexOf(oldItem), newItem);
                    }
                    break;
                case "Rearrange":
                    item = tokens[1];
                    if (items.contains(item)) {
                        int index = items.indexOf(item);
                        items.add(items.remove(index));
                    }
                    break;
            }
            commands = scan.nextLine();
        }
        System.out.println(String.join(", ", items));
    }
}
