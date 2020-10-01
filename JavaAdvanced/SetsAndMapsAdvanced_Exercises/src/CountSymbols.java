import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String string = scan.nextLine();
        TreeMap<Character, Integer> letters = new TreeMap<>();

        for (int i = 0; i < string.length(); i++) {
            letters.putIfAbsent(string.charAt(i), 0);
            letters.put(string.charAt(i), letters.get(string.charAt(i)) + 1);
        }
        letters.entrySet().forEach(e -> {
            System.out.println(e.getKey() + ": " + e.getValue() + " time/s");
        });
    }
}
