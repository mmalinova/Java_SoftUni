package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        DataList<String> dataList = new DataList<>();

        String command = scan.nextLine();
        while(!"END".equals(command)) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Add":
                    String element = tokens[1];
                    dataList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(tokens[1]);
                    dataList.remove(index);
                    break;
                case "Contains":
                    element = tokens[1];
                    System.out.println(dataList.contains(element));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    dataList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    element = tokens[1];
                    System.out.println(dataList.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(dataList.getMax());
                    break;
                case "Min":
                    System.out.println(dataList.getMin());
                    break;
                case "Print":
                    for (int i = 0; i < dataList.getSize(); i++) {
                        System.out.println(dataList.getElement(i));
                    }
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
            command = scan.nextLine();
        }
    }
}
