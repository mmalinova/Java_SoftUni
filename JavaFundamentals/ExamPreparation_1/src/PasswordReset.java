import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String string = scan.nextLine();

        String command = scan.nextLine();

        StringBuilder sb = new StringBuilder();
        String password = string;

        while(!"Done".equals(command)) {
            String[] tokens = command.split(" ");
            switch (tokens[0]) {
                case "TakeOdd":
                    for (int i = 0; i < password.length(); i++) {
                        if (i % 2 != 0) {
                            sb.append(password.charAt(i));
                        }
                    }
                    password = sb.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    String sub = password.substring(index, index + length);
                    password = password.replaceFirst(sub, "");
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];
                    if (password.contains(substring)) {
                        password = password.replaceAll(substring, substitute);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            command = scan.nextLine();
        }
        System.out.println(String.format("Your password is: %s", password));
    }
}
