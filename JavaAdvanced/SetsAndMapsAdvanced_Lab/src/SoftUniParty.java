import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<String> VIPs = new LinkedHashSet<>();
        LinkedHashSet<String> regular = new LinkedHashSet<>();

        String command = scan.nextLine();
        while(!"PARTY".equals(command)) {
            if (Character.isDigit(command.charAt(0))) {
                VIPs.add(command);
            } else {
                regular.add(command);
            }
            command = scan.nextLine();
        }

        TreeSet<String> allGuests = new TreeSet<>(VIPs);
        allGuests.addAll(regular);

        String input = scan.nextLine();
        while(!"END".equals(input)) {
            allGuests.remove(input);
            input = scan.nextLine();
        }

        System.out.println(allGuests.size());
        System.out.println(String.join(System.lineSeparator(), allGuests));
        /*
        for (String allGuest : allGuests) {
            System.out.println(allGuest);
        } */
    }
}
