import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        Map<Character, Integer> characters = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                if (characters.containsKey(input[i].charAt(j))) {
                    int oldValue = characters.get(input[i].charAt(j));
                    int newValue = oldValue + 1;
                    characters.put(input[i].charAt(j), newValue);
                } else {
                    characters.put(input[i].charAt(j), 1);
                }
            }
        }
        for(Map.Entry<Character, Integer> entry : characters.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());

        }
    }
}