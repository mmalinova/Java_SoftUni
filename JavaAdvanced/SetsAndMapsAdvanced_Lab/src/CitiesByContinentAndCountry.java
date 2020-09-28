import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, LinkedList<String>>> continents = new LinkedHashMap<>();

        int number = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < number; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());
            continents.get(continent).putIfAbsent(country, new LinkedList<>());
            continents.get(continent).get(country).add(city);
        }

        continents.entrySet()
                .forEach(continent -> {
                    System.out.println(continent.getKey() + ":");
                    continent.getValue().entrySet()
                            .forEach(country -> {
                                System.out.print(String.format("%s -> ", country.getKey()));
                                System.out.println(String.format("%s", country.getValue()
                                        .toString().replaceAll("[\\[\\]]", "")));
                            });
                });

    }
}
