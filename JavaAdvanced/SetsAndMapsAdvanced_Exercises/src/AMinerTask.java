import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Integer>  resources = new LinkedHashMap<>();

        int count = 0;
        String command = scan.nextLine();

        String item = "";
        while(!"stop".equals(command)) {
            count++;
            if (count % 2 == 0) {
                int quantity = Integer.parseInt(command);
                resources.put(item, resources.get(item) + quantity);
            } else {
                resources.putIfAbsent(command, 0);
                item = command;
            }
            command = scan.nextLine();
        }

        resources.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " -> " + e.getValue());
        });
    }
}
