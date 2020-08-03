import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            stringList.add(input[i]);
        }

        String commands = scan.nextLine();
        while(!"Craft!".equals(commands)) {
            String[] tokens = commands.split("\\ - ");
            String command = tokens[0];
            switch (command) {
                case "Collect":
                    String item = tokens[1];
                    if (!stringList.contains(item)) {
                        stringList.add(item);
                    }
                    break;
                case "Drop":
                    item = tokens[1];
                    if (stringList.contains(item)) {
                        stringList.remove(item);
                    }
                    break;
                case "Combine Items":
                    String[] items = tokens[1].split("\\:");
                    String oldItem = items[0];
                    String newItem = items[1];
                    if (stringList.contains(oldItem)) {
                        int index = (stringList.indexOf(oldItem));
                        stringList.add(index + 1, newItem);
                    }
                    break;
                case "Renew":
                    item = tokens[1];
                    if (stringList.contains(item)) {
                        stringList.add(stringList.remove(stringList.indexOf(item)));
                    }
                    break;
            }
            commands = scan.nextLine();
        }
        System.out.printf(String.join(", ", stringList));
    }
}
