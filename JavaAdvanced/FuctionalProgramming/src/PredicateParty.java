import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<String> peoples = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        BiPredicate<String, String> starts = String::contains;

        BiPredicate<String, String> ends = String::contains;

        BiPredicate<String, Integer> hasLength = (name, len) -> name.length() == len;

        String input = scan.nextLine();
        while(!"Party!".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String criteria = tokens[1];
            ArrayList<String> toAdd = new ArrayList<>();
            switch (command) {
                case "Remove":
                    switch(criteria) {
                        case "StartsWith":
                            String firstLetter = tokens[2];
                            peoples.removeIf(people -> starts.test(people, firstLetter));
                            break;
                        case "EndsWith":
                            String lastLetter = tokens[2];
                            peoples.removeIf(people -> ends.test(people, lastLetter));
                            break;
                        case "Length":
                            Integer length = Integer.parseInt(tokens[2]);
                            peoples.removeIf(people -> hasLength.test(people, length));
                            break;
                    }
                    break;
                case "Double":
                    switch(criteria) {
                        case "StartsWith":
                            String firstLetter = tokens[2];
                            for (String people : peoples) {
                                if (starts.test(people, firstLetter)) {
                                   toAdd.add(people);
                                }
                            }
                            peoples.addAll(toAdd);
                            break;
                        case "EndsWith":
                            String lastLetter = tokens[2];
                            for (String people : peoples) {
                                if (ends.test(people, lastLetter)) {
                                    toAdd.add(people);
                                }
                            }
                            peoples.addAll(toAdd);
                            break;
                        case "Length":
                            Integer length = Integer.parseInt(tokens[2]);
                            for (String people : peoples) {
                                if (hasLength.test(people, length)) {
                                    toAdd.add(people);
                                }
                            }
                            peoples.addAll(toAdd);
                            break;
                    }
                    break;
            }
            input = scan.nextLine();
        }

        if (peoples.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(peoples);
            System.out.println(peoples.toString().replaceAll("[\\[\\]]", "") + " are going to the party!");
        }
    }
}
