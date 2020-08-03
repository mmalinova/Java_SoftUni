import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] listInput = scan.nextLine().split("\\s+");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < listInput.length; i++) {
            list.add(Integer.parseInt(listInput[i]));
        }

        String input = scan.nextLine();
        while(!"end".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Delete":
                    int element = Integer.parseInt(tokens[1]);
                    while (list.contains(element)) {
                        list.remove(Integer.valueOf(element));
                    }
                    break;
                case "Insert":
                    element = Integer.parseInt(tokens[1]);
                    int index = Integer.parseInt(tokens[2]);
                    if (index < list.size()) {
                        list.add(index, element);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        for (int elements: list) {
            System.out.printf("%d ", elements);
        }
    }
}
