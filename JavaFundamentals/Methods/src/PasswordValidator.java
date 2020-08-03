import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean isValid = true;

        String password = scan.nextLine();
        if(!isEnoughCharacters(password)) {
            System.out.println("Password must be between 6 and 10 characters");
            isValid = false;
        }
        if(!onlyLettersAndDigits(password)) {
            System.out.println("Password must consist only of letters and digits");
            isValid = false;
        }
        if(!haveAtLeastTwoDigits(password)) {
            System.out.println("Password must have at least 2 digits");
            isValid = false;
        }
        if(isValid) {
            System.out.println("Password is valid");
        }
    }

    private static boolean haveAtLeastTwoDigits(String password) {
        int count = 0;
        for (char i = 0; i < password.length(); i++) {
            char m = password.charAt(i);
            if (m >= '0' && m <= '9') {
                count++;
            }
        }
        if (count >= 2) {
            return  true;
        } else {
            return false;
        }
    }

    private static boolean onlyLettersAndDigits(String password) {
        for (char i = 0; i < password.length(); i++) {
            char m = password.charAt(i);
            if (!(m >= 'A' && m <= 'Z' || m >= 'a' && m <= 'z' || m >= '0' && m <= '9')) {
                return false;
            }
        }
        return true;
    }

    private static boolean isEnoughCharacters(String password) {
        if (password.length() < 6 || password.length() > 10) {
            return false;
        }
        return  true;
    }
}
