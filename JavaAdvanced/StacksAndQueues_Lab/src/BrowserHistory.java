import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> stackBack = new ArrayDeque<>();
        ArrayDeque<String> stackForward = new ArrayDeque<>();

        String instruction = scan.nextLine();
        String current = "";

        while (!"Home".equals(instruction)) {
            if (instruction.equals("back")) {
                if (stackBack.size() > 1) {
                    stackForward.push(stackBack.pop());
                    System.out.println(stackBack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if (instruction.equals("forward")) {
                if (!stackForward.isEmpty()) {
                    String pop = stackForward.pop();
                    stackBack.push(pop);
                    System.out.println(pop);
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                stackForward.clear();
                current = instruction;
                System.out.println(current);
                stackBack.push(current);
            }
            instruction = scan.nextLine();
        }
    }
}
