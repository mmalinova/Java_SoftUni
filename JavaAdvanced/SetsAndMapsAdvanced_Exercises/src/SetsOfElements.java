import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] count = scan.nextLine().split("\\s+");
        int firstSetSize = Integer.parseInt(count[0]);
        int secondSetSize = Integer.parseInt(count[1]);

        LinkedHashSet<Integer> firstNumbers = new LinkedHashSet<>(firstSetSize);
        LinkedHashSet<Integer> secondNumbers = new LinkedHashSet<>(secondSetSize);

        for (int i = 0; i < firstSetSize; i++) {
            firstNumbers.add(Integer.parseInt(scan.nextLine()));
        }
        for (int i = 0; i < secondSetSize; i++) {
            secondNumbers.add(Integer.parseInt(scan.nextLine()));
        }

        firstNumbers.retainAll(secondNumbers);
        System.out.println(firstNumbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
