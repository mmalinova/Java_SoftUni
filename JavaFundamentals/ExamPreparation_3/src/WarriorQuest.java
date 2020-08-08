import java.util.Scanner;

public class WarriorQuest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String string = scan.nextLine();

        String command = scan.nextLine();
        while (!"For Azeroth".equals(command)) {
            String[] tokens = command.split("\\s+");
            switch(tokens[0]) {
                case "GladiatorStance":
                    string = string.toUpperCase();
                    System.out.println(string);
                    break;
                case "DefensiveStance":
                    string = string.toLowerCase();
                    System.out.println(string);
                    break;
                case "Dispel":
                    int index = Integer.parseInt(tokens[1]);
                    String letter = tokens[2];
                    if (index < 0 || index >= string.length()) {
                        System.out.println("Dispel too weak.");
                    } else {
                        string = string.replaceFirst(String.valueOf(string.charAt(index)), letter);
                        System.out.println("Success!");
                    }
                    break;
                case "Target":
                    String changeOrRemove = tokens[1];
                    String substring = tokens[2];
                    if (changeOrRemove.equals("Change")) {
                        String secondSub = tokens[3];
                        string = string.replace(substring, secondSub);
                        System.out.println(string);
                    } else if (changeOrRemove.equals("Remove")){
                        string = string.replace(substring, "");
                        System.out.println(string);
                    } else {
                        System.out.println("Command doesn't exist!");
                    }
                    break;
                default: System.out.println("Command doesn't exist!");
            }
            command = scan.nextLine();
        }
    }
}
