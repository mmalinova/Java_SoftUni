import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque <String> tokensStack = new ArrayDeque<>();
        ArrayDeque <String> tokensQueue = new ArrayDeque<>();

        String[] expression = scan.nextLine().split("\\s+");

        for (int i = 0; i < expression.length; i++) {
            String currentChar = expression[i];
            if (currentChar.equals("+") || currentChar.equals("-")
                    ||  currentChar.equals("*") || currentChar.equals("/") || currentChar.equals("(")) {
                if (!tokensStack.isEmpty()) {
                    String atTheTop = tokensStack.peek();
                    if (atTheTop.equals("*") || atTheTop.equals("/")) {
                        if (!currentChar.equals("(")) {
                            tokensQueue.offer(tokensStack.pop());
                        }
                    } else if ((atTheTop.equals("+") && currentChar.equals("-"))
                            || (atTheTop.equals("-") && currentChar.equals("+")) || atTheTop.equals(currentChar)) {
                        tokensQueue.offer(tokensStack.pop());
                    }
                }
                tokensStack.push(currentChar);
            } else if (currentChar.equals(")")) {
                if (tokensStack.contains("(")) {
                    while (true) {
                        assert tokensStack.peek() != null;
                        if (tokensStack.peek().equals("(")) break;
                        tokensQueue.offer(tokensStack.pop());
                    }
                    tokensStack.pop();
                } else {
                    System.out.println("Mismatched parentheses");
                }
            } else {
                tokensQueue.offer(currentChar);
            }
        }
        while (!tokensStack.isEmpty()) {
            if (tokensStack.peek().equals("(") || tokensStack.peek().equals(")")) {
                System.out.println("Mismatched parentheses");
            }
            tokensQueue.offer(tokensStack.pop());
        }

        StringBuilder toPrint = new StringBuilder();
        while (!tokensQueue.isEmpty()) {
            toPrint.append(tokensQueue.poll());
            toPrint.append(" ");
        }
        System.out.println(toPrint.toString().substring(0, toPrint.length() - 1));
    }
}
