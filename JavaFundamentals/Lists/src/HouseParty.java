import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> names = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            if (tokens[2].equals("going!")) {
                if (!names.contains(tokens[0])) {
                    names.add(tokens[0]);
                } else {
                    System.out.printf("%s is already in the list!%n", tokens[0]);
                }
            } else if (tokens[2].equals("not")) {
                if (names.contains(tokens[0])) {
                    names.remove(tokens[0]);
                } else {
                    System.out.printf("%s is not in the list!%n", tokens[0]);
                }
            }
        }
        for (String element: names) {
            System.out.printf("%s%n", element);
        }
    }
}
