import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondPlayer = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        int round = 0;
        while (round < 50) {
            round++;
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }
            int cardOfFirstPlayer = firstPlayer.iterator().next();
            firstPlayer.remove(cardOfFirstPlayer);
            int cardOfSecondPlayer = secondPlayer.iterator().next();
            secondPlayer.remove(cardOfSecondPlayer);
            if (cardOfFirstPlayer > cardOfSecondPlayer) {
                firstPlayer.add(cardOfFirstPlayer);
                firstPlayer.add(cardOfSecondPlayer);
            } else if (cardOfSecondPlayer > cardOfFirstPlayer){
                secondPlayer.add(cardOfFirstPlayer);
                secondPlayer.add(cardOfSecondPlayer);
            }
        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()){
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
