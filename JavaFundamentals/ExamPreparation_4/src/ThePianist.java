import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, TreeMap<String, String>> pieces = new TreeMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\|");
            String piece = input[0];
            String composer = input[1];
            String key = input[2];
            pieces.putIfAbsent(piece, new TreeMap<>());
            pieces.get(piece).put(composer, key);
        }
        String command = scan.nextLine();
        while (!"Stop".equals(command)) {
            String[] tokens = command.split("\\|");
            String piece = tokens[1];
            switch(tokens[0]) {
                case "Add":
                    String composer = tokens[2];
                    String key = tokens[3];
                    if  (pieces.containsKey(piece)) {
                        System.out.println(piece +" is already in the collection!");
                    } else {
                        pieces.put(piece, new TreeMap<>());
                        pieces.get(piece).put(composer, key);
                        System.out.println(piece + " by " + composer + " in " + key + " added to the collection!");
                    }
                    break;
                case "Remove":
                    if (pieces.containsKey(piece)) {
                        pieces.remove(piece);
                        System.out.println("Successfully removed " + piece + "!");
                    } else {
                        System.out.println("Invalid operation! " + piece + " does not exist in the collection.");
                    }
                    break;
                case "ChangeKey":
                    String newKey = tokens[2];
                    if (pieces.containsKey(piece)) {
                        composer = pieces.get(piece).firstKey();
                        pieces.get(piece).put(composer, newKey);
                        System.out.println("Changed the key of " + piece + " to " + newKey + "!");
                    } else {
                        System.out.println("Invalid operation! " + piece + " does not exist in the collection.");
                    }
                    break;
            }
            command = scan.nextLine();
        }
        pieces.entrySet()
                .forEach(element -> {
                    //"{Piece} -> Composer: {composer}, Key: {key}"
                    System.out.printf("%s -> ", element.getKey());
                            element.getValue().entrySet().forEach(e -> {
                                System.out.println(String.format("Composer: %s, Key: %s", e.getKey(), e.getValue()));
                            });
                });
    }
}
