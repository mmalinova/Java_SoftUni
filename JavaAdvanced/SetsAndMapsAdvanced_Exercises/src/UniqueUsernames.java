import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        LinkedHashSet<String> usernames = new LinkedHashSet<>(number);

        for (int i = 0; i < number; i++) {
            usernames.add(scan.nextLine());
        }
        usernames.forEach(element -> System.out.println(element));
    }
}
