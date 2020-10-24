import java.util.*;
import java.util.stream.Collectors;

public class SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Stack<Integer> materials = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(Stack::new));

        ArrayDeque<Integer> magic = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        TreeMap<String, Integer> crafted = new TreeMap<>();

        while(!materials.isEmpty() && !magic.isEmpty()) {
            int multiplication = materials.peek() * magic.peek();
            if (multiplication == 150) {
                if (crafted.containsKey("Doll")) {
                    crafted.put("Doll", crafted.get("Doll") + 1);
                } else {
                    crafted.put("Doll", 1);
                }
                materials.pop();
                magic.poll();
            } else if (multiplication == 250) {
                if (crafted.containsKey("Wooden train")) {
                    crafted.put("Wooden train", crafted.get("Wooden train") + 1);
                } else {
                    crafted.put("Wooden train", 1);
                }
                materials.pop();
                magic.poll();
            } else if (multiplication == 300) {
                if (crafted.containsKey("Teddy bear")) {
                    crafted.put("Teddy bear", crafted.get("Teddy bear") + 1);
                } else {
                    crafted.put("Teddy bear", 1);
                }
                materials.pop();
                magic.poll();
            } else if (multiplication == 400) {
                if (crafted.containsKey("Bicycle")) {
                    crafted.put("Bicycle", crafted.get("Bicycle") + 1);
                } else {
                    crafted.put("Bicycle", 1);
                }
                materials.pop();
                magic.poll();
            } else if (multiplication < 0) {
                    int sum = materials.pop() + magic.poll();
                    materials.push(sum);
            } else if (multiplication > 0) {
                    magic.poll();
                    materials.push(materials.pop() + 15);
            } else {
                if (materials.peek() == 0) {
                    materials.pop();
                }
                if (magic.peek() == 0) {
                    magic.poll();
                }
            }
        }

        if ((crafted.containsKey("Doll") && crafted.containsKey("Train"))
                || (crafted.containsKey("Teddy bear") && crafted.containsKey("Bicycle"))) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materials.isEmpty()) {
            System.out.print("Materials left: ");
            StringBuilder sb = new StringBuilder();
            while (!materials.isEmpty()) {
                sb.append(materials.pop()).append(", ");
            }
            System.out.println(sb.substring(0, sb.length() - 2));
        }
        if (!magic.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(magic.toString().replaceAll("[\\[\\]]", ""));
        }

        crafted.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
