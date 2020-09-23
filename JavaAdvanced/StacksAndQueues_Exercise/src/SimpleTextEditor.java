import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque <String> textStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int numberOfOperations = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < numberOfOperations; i++) {
            String input = scan.nextLine();
            String command = input.split("\\s+")[0];
            String eraseElements = "";
            switch(command) {
                case "1":
                    String string = input.split("\\s+")[1];
                    sb.append(string);
                    textStack.push(string);
                    textStack.push("1");
                    break;
                case "2":
                    int count = Integer.parseInt(input.split("\\s+")[1]);
                    eraseElements = sb.substring(sb.length() - count, sb.length());
                    sb.replace(sb.length() - count, sb.length(), "");
                    textStack.push(eraseElements);
                    textStack.push("2");
                    break;
                case "3":
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    System.out.println(sb.charAt(index - 1));
                    break;
                case "4":
                    if (!textStack.isEmpty()) {
                        String undo = textStack.pop();
                        String str = textStack.pop();
                        switch (undo) {
                            case "1":
                                sb.replace(sb.length() - str.length(), sb.length(), "");
                                break;
                            case "2":
                                sb.append(str);
                                break;
                        }
                    }
                    break;
            }
        }
    }
}
