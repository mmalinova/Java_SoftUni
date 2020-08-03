import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String command = scan.nextLine();
        while(!"END".equals(command)) {
            System.out.println(isPalindrome(command));
            command = scan.nextLine();
        }
    }

    private static boolean isPalindrome(String command) {
        int middle = 0;
        if (command.length() % 2 == 0) {
            middle = command.length() - 1;
        }
        else {
            middle = command.length() / 2;
        }
        if (command.length() == 1) {
            return  true;
        }
        for (int i = 0; i < middle; i++) {
            char m = command.charAt(i);
            if (m != command.charAt(command.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
    /*public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String command = scan.nextLine();
        while(!"END".equals(command)) {
            int[] n = new int[command.length()];
            for (int i = 0; i < n.length; i++) {
                n[i] = Integer.parseInt(String.valueOf(command.charAt(i)));
            }
            boolean isPalindrome = isPalindrome(n);
            if (isPalindrome) {
                System.out.println("true");
            }
            else {
                System.out.println("false");
            }
            command = scan.nextLine();
        }
    }

    private static boolean isPalindrome(int[] n) {
        int middle = 0;
        if (n.length % 2 == 0) {
            middle = n.length - 1;
        }
        else {
            middle = n.length / 2;
        }
        if (n.length == 1) {
            return  true;
        }
        for (int i = 0; i < middle; i++) {
            if (n[i] != n[n.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}*/