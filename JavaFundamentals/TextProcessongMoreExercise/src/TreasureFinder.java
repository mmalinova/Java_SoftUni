import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] keySequence = scan.nextLine().split("\\s+");
        int[] key = new int[keySequence.length];
        for (int i = 0; i < keySequence.length; i++) {
            key[i] = Integer.parseInt(keySequence[i]);
        }

        String command = scan.nextLine();
        while(!"find".equals(command)) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            for (int i = 0; i < command.length(); i++) {
                char currentChar = command.charAt(i);
                currentChar = (char) (command.charAt(i) - key[j]);
                sb.append(currentChar);
                j++;
                if (j == key.length) {
                    j = 0;
                }
            }
            int startTreasureIndex = 0;
            int endTreasureIndex = 0;
            int startCoordinatesIndex = 0;
            int endCoordinatesIndex = 0;
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '&') {
                    if (startTreasureIndex == 0) {
                        startTreasureIndex = i + 1;
                    } else {
                        endTreasureIndex = i;
                    }
                }
                if (sb.charAt(i) == '<') {
                    startCoordinatesIndex = i + 1;
                }
                if (sb.charAt(i) == '>') {
                    endCoordinatesIndex = i;
                }
            }
            String treasure = sb.substring(startTreasureIndex, endTreasureIndex);
            String coordinates = sb.substring(startCoordinatesIndex, endCoordinatesIndex);
            System.out.println(String.format("Found %s at %s", treasure, coordinates));
            command = scan.nextLine();
        }
    }
}
