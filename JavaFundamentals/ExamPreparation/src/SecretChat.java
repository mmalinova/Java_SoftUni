import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();

        String command = scan.nextLine();
        StringBuilder sb = new StringBuilder(message);

        while(!"Reveal".equals(command)) {
            String[] input = command.split(":\\|:");
            switch (input[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(input[1]);
                    sb.insert(index, " ");
                    System.out.println(sb);
                    break;
                case "Reverse":
                    String substring = input[1];
                    int indexOfStr = sb.indexOf(substring);
                    if (indexOfStr >= 0) {
                        sb.delete(indexOfStr, indexOfStr + substring.length());
                        String reversed = new StringBuilder(substring).reverse().toString();
                        sb.append(reversed);
                        System.out.println(sb);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    substring = input[1];
                    String replacement = input[2];
                    message = message.replace(substring, replacement);
                    sb.replace(0, sb.length(), message);
                    System.out.println(sb);
                    break;
            }
            command = scan.nextLine();
        }
        System.out.println(String.format("You have a new text message: %s", sb));
    }
}