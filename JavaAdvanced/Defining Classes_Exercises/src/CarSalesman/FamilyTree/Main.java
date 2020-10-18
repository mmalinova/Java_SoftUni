package FamilyTree;
import java.util.*;
public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String input = scan.nextLine();

        List<String> personList = new ArrayList<>();
        ArrayDeque<String> lines = new ArrayDeque<>();

        Person inputPerson = new Person(input);
        String command = scan.nextLine();
        while (!"End".equals(command)) {
            if (command.contains("-")) {
                lines.offer(command);
            } else {
                if (command.contains(input)) {
                    input = command;
                    inputPerson = new Person(command);
                }
                personList.add(command);
            }
            command = scan.nextLine();
        }

        while (!lines.isEmpty()) {
            setParentAndChild(lines.pop(), inputPerson,input, personList);
        }

        System.out.println(inputPerson);
    }

    private static void setParentAndChild(String command, Person inputPerson, String input, List<String> personList) {
        String parent = command.split(" - ")[0];
        String child = command.split(" - ")[1];
        for (String s : personList) {
            if (s.contains(parent)) {
                parent = s;
                continue;
            }
            if (s.contains(child)) {
                child = s;
            }
        }
        if (input.contains(parent)) {
            inputPerson.setChildren(child);
        }
        if (input.contains(child)) {
            inputPerson.setParents(parent);
        }
    }
}
