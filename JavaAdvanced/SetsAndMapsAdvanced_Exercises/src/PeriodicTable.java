import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        TreeSet<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            elements.addAll(Arrays.asList(input));
        }
        System.out.println(elements.toString().replaceAll("[\\[\\],]", ""));
    }
}
