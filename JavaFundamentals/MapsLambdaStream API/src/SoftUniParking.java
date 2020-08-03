import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> users = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String command = input[0];
            switch (command) {
                case "register":
                    String username = input[1];
                    String licensePlateNumber = input[2];
                    if (users.containsKey(username)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", licensePlateNumber);
                    } else {
                        users.put(username, licensePlateNumber);
                        System.out.printf("%s registered %s successfully%n", username, licensePlateNumber);
                    }
                    break;
                case "unregister":
                    username = input[1];
                    if (users.containsKey(username)) {
                        users.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    } else {
                        System.out.printf("ERROR: user %s not found%n", username);
                    }
                    break;
            }
        }
        for(Map.Entry<String, String> entry : users.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
