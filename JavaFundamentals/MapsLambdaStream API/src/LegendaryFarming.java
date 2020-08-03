import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new LinkedHashMap<>();
        Map<String, Integer> junk = new LinkedHashMap<>();


        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        boolean isObtained = false;

        while (!isObtained) {
            String[] input = scan.nextLine().split("\\s+");
            for (int i = 1; i < input.length; i += 2) {
                String element = input[i].toLowerCase();
                int quantity = Integer.parseInt(input[i - 1]);
                switch (element) {
                    case "shards":
                        int oldValue = keyMaterials.get("shards");
                        int newValue = oldValue + quantity;
                        isObtained = isObtained(newValue);
                        if (isObtained) {
                            System.out.println("Shadowmourne obtained!");
                            newValue -= 250;
                            i = input.length;
                        }
                        keyMaterials.replace("shards", newValue);
                        break;
                    case "fragments":
                        oldValue = keyMaterials.get("fragments");
                        newValue = oldValue + quantity;
                        isObtained = isObtained(newValue);
                        if (isObtained) {
                            System.out.println("Valanyr obtained!");
                            newValue -= 250;
                            i = input.length;
                        }
                        keyMaterials.replace("fragments", newValue);
                        break;
                    case "motes":
                        oldValue = keyMaterials.get("motes");
                        newValue = oldValue + quantity;
                        isObtained = isObtained(newValue);
                        if (isObtained) {
                            System.out.println("Dragonwrath obtained!");
                            newValue -= 250;
                            i = input.length;
                        }
                        keyMaterials.replace("motes", newValue);
                        break;
                    default:
                        if (junk.containsKey(element)) {
                            oldValue = junk.get(element);
                            newValue = oldValue + quantity;
                            junk.replace(element, newValue);
                        } else {
                            junk.put(element, quantity);
                        }
                }
            }
        }
        keyMaterials.entrySet()
                .stream()
                .sorted((v1, v2) -> {
                    int res = v2.getValue().compareTo(v1.getValue());
                    if (res == 0) {
                        res = v1.getKey().compareTo(v2.getKey());
                    }
                    return res;
                })
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
        junk.entrySet()
                .stream()
                .sorted((k1, k2) -> k1.getKey().compareTo(k2.getKey()))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
    }

    private static boolean isObtained(int value) {
        return value >= 250;
    }
}
