import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Character> stack = new ArrayDeque<>();

        String parentheses = scan.nextLine();
        for (int i = 0; i < parentheses.length(); i++) {
            char current = parentheses.charAt(i);
            switch (current) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
            }
            if (current == ')' || current == ']' || current == '}') {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                } else {
                    char open = stack.pop();
                    if (open != current) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
