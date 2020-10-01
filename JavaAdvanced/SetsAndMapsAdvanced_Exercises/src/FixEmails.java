import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        while(true) {
            String name = scan.nextLine();
            if ("stop".equals(name)) {
                break;
            }
            String email = scan.nextLine();
            if (email.contains(".")) {
                String endOfEmail = email.substring(email.indexOf(".") + 1);
                if (endOfEmail.equals("uk") || endOfEmail.equals("us") || endOfEmail.equals("com")) {
                    continue;
                }
                emails.put(name, email);
            }
        }
        emails.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " -> " + e.getValue());
        });
    }
}
