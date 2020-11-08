package shoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(";");
        List<Person> people = fillPeopleList(input);

        input = scan.nextLine().split(";");
        List<Product> products = fillProductList(input);

        String command = scan.nextLine();
        while (!"END".equals(command)) {
            String[] tokens = command.split(" ");
            String person = tokens[0];
            String product = tokens[1];
            Person per = people.stream()
                    .filter(e -> e.getName().equals(person))
                    .findFirst()
                    .orElseThrow(Exception::new);
            try {
                Product productBuy = products.stream()
                        .filter(p -> p.getName().equals(product))
                        .findFirst()
                        .orElseThrow(Exception::new);
                per.buyProduct(productBuy);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            command = scan.nextLine();
        }
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }

    private static List<Product> fillProductList(String[] input) {
        List<Product> products = new LinkedList<>();
        for (String str : input) {
            String[] tokens = str.split("=");
            try {
                Product product = new Product(tokens[0], Double.parseDouble(tokens[1]));
                products.add(product);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return products;
    }

    private static List<Person> fillPeopleList(String[] input) {
        List<Person> people = new LinkedList<>();
        for (String str : input) {
            String[] tokens = str.split("=");
            try {
                Person person = new Person(tokens[0], Double.parseDouble(tokens[1]));
                people.add(person);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return people;
    }
}
