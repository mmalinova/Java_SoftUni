import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> companies = new TreeMap<>();

        String command = scan.nextLine();
        while(!"End".equals(command)) {
            String[] input = command.split(" -> ");
            String companyName = input[0];
            String id = input[1];
            companies.putIfAbsent(companyName, new ArrayList<>());
            if (!companies.get(companyName).contains(id)) {
                companies.get(companyName).add(id);
            }
            command = scan.nextLine();
        }

        companies.entrySet()
                //.stream()
                //.sorted((k1, k2) -> k1.getKey().compareTo(k2.getKey()))
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue()
                            .forEach(v -> System.out.println(String.format("-- %s", v)));
                });
    }
}
