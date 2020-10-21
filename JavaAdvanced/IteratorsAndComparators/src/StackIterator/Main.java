package StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        Stack<Integer> stack = new Stack<>();

        while (!command.equals("END")) {

            String[] tokens = command.split("([, ]+)");

            if (tokens[0].equals("Push")) {
                for (int i = 1; i < tokens.length; i++) {
                    stack.push(Integer.parseInt(tokens[i]));
                }
            } else {
                try {
                    stack.pop();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            command = scan.nextLine();
        }
        for (int i = 0; i < 2; i++) {
            for (Integer integer : stack) {
                System.out.println(integer);
            }
        }
    }
}
