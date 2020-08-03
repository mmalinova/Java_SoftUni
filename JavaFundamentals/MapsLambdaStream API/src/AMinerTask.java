import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> elements = new LinkedHashMap<>();
        String command = scan.nextLine();
        int i = 1, quantity = 0;
        String element = "";
        while(!"stop".equals(command)) {
            if (i % 2 == 0) {
                quantity = Integer.parseInt(command);
            } else {
                element = command;
            }
            elements.putIfAbsent(element, 0);
            int oldValue = elements.get(element);
            int newValue = oldValue + quantity;
            elements.put(element, newValue);
            i++;
            quantity = 0;
            command = scan.nextLine();
        }
        for(Map.Entry<String, Integer> entry : elements.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
