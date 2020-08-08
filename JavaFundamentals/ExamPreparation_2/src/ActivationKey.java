import java.util.Scanner;

public class ActivationKey {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String string = scan.nextLine();
        String activationKey = string;

        String command = scan.nextLine();
        while (!"Generate".equals(command)) {
            String[] tokens = command.split(">>>");
            switch (tokens[0]) {
                case "Contains":
                    String substring = tokens[1];
                    if (activationKey.contains(substring)) {
                        System.out.println(activationKey + " contains " + substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperOrLower = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    activationKey = change(activationKey, upperOrLower, startIndex, endIndex);
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);
                    activationKey = delete(activationKey, startIndex, endIndex);
                    System.out.println(activationKey);
                    break;
            }
            command = scan.nextLine();
        }
        System.out.println("Your activation key is: " + activationKey);
    }

    private static String delete(String activationKey, int startIndex, int endIndex) {
        String substring = activationKey.substring(startIndex, endIndex);
        activationKey = activationKey.replaceFirst(substring, "");
        return  activationKey;
    }

    private static String change(String activationKey, String upperOrLower, int startIndex, int endIndex) {
        String oldSubstring = activationKey.substring(startIndex, endIndex);
        String newSubstring = "";
        if (upperOrLower.equals("Upper")) {
            newSubstring = oldSubstring.toUpperCase();
        } else {
            newSubstring = oldSubstring.toLowerCase();
        }
        return activationKey.replaceFirst(oldSubstring, newSubstring);
    }
}



