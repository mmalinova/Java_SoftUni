import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] listInput = scan.nextLine().split("\\s+");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < listInput.length; i++) {
            list.add(Integer.parseInt(listInput[i]));
        }
        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            //Add {number} - add number at the end
            //Insert {number} {index} - insert number at given index
            //Remove {index} - remove that index
            //Shift left {count} - first number becomes last &#39;count&#39; times
            //Shift right {count} - last number becomes first &#39;count&#39; times
            switch(command) {
                case "Add":
                    int number = Integer.parseInt(tokens[1]);
                    list.add(number);
                    break;
                case "Insert":
                    number = Integer.parseInt(tokens[1]);
                    int index = Integer.parseInt(tokens[2]);
                    if (index < 0 || index >= list.size()) {
                        System.out.println("Invalid index");
                    } else {
                        list.add(index, number);
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(tokens[1]);
                    if (index < 0 || index >= list.size()) {
                        System.out.println("Invalid index");
                    } else {
                        list.remove(index);
                    }
                    break;
                case "Shift":
                    String leftOrRight = tokens[1];
                    int count = Integer.parseInt(tokens[2]);
                    if (leftOrRight.equals("left")) {
                        for (int i = 0; i < count; i++) {
                            list.add(list.remove(0));
                        }
                    } else if (leftOrRight.equals("right")){
                        for (int i = 0; i < count; i++) {
                            list.add(0, list.remove(list.size() - 1));
                        }
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
