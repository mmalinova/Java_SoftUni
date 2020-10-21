package Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> input = Arrays.asList(scan.nextLine().split("\\s+"));
        ListyIterator listyIterator = new ListyIterator(input.subList(1, input.size()));

        String command = scan.nextLine();
        while(!"END".equals(command)) {
            switch(command) {
                case "Move":
                    System.out.println(listyIterator.Move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.iterator().hasNext());
                    break;
                case "Print":
                    listyIterator.Print();
                    break;
                case "PrintAll":
                    listyIterator.PrintAll();
                    break;
            }
            command = scan.nextLine();
        }
    }
}
