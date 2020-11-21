package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Class<?> clazz = RichSoilLand.class;

        Map<String, List<Field>> map = new LinkedHashMap<>();
        map.put("private", new ArrayList<>());
        map.put("protected", new ArrayList<>());
        map.put("public", new ArrayList<>());
        map.put("all", new ArrayList<>());

        fillMap(clazz, map);

        Map<String, String> output = new LinkedHashMap<>();
        output.put("private", formatOutput(map.get("private")));
        output.put("protected", formatOutput(map.get("protected")));
        output.put("public", formatOutput(map.get("public")));
        output.put("all", formatOutput(map.get("all")));

        String modifier = scan.nextLine();

        StringBuilder sb = new StringBuilder();
        while (!"HARVEST".equals(modifier)) {
            sb.append(output.get(modifier));
            modifier = scan.nextLine();
        }

        System.out.println(sb.toString().trim());
    }

    private static void fillMap(Class<?> clazz, Map<String, List<Field>> map) {
        for (Field field : clazz.getDeclaredFields()) {
            switch (Modifier.toString(field.getModifiers())) {
                case "private":
                    map.get("private").add(field);
                    break;
                case "protected":
                    map.get("protected").add(field);
                    break;
                case "public":
                    map.get("public").add(field);
                    break;
            }
            map.get("all").add(field);
        }
    }

    private static String formatOutput(List<Field> list) {
        return list.stream()
                .map(field -> String.format("%s %s %s%n",
                        Modifier.toString(field.getModifiers()),
                        field.getType().getSimpleName(),
                        field.getName()))
                .collect(Collectors.joining());
    }
}
