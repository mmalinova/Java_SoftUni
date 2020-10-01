import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<String, String> phonebook = new HashMap<>();

        String command = scan.nextLine();
        while(!"search".equals(command)) {
            String[] input = command.split("-");
            String name = input[0];
            String phoneNumber = input[1];

            phonebook.put(name, phoneNumber);
            command = scan.nextLine();
        }

        command = scan.nextLine();
        while(!"stop".equals(command)) {
            String nameToSearch = command;
            if (phonebook.containsKey(nameToSearch)) {
                System.out.println(nameToSearch + " -> " + phonebook.get(nameToSearch));
            } else {
                System.out.println("Contact " + nameToSearch + " does not exist.");
            }
            command = scan.nextLine();
        }
    }
}
