package Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static <T> void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Element.Pokemon pokemon;
        Element.Company company;
        Element.Car car;
        Element.Children children;
        Element.Parent parent;

        HashMap<String, HashMap<String, ArrayList<T>>> info = new HashMap<>();

        String input = scan.nextLine();
        while(!"End".equals(input)) {
            //•	"<Name> company <companyName> <department> <salary>"
            //•	"<Name> pokemon <pokemonName> <pokemonType>"
            //•	"<Name> parents <parentName> <parentBirthday>"
            //•	"<Name> children <childName> <childBirthday>"
            //•	"<Name> car <carModel> <carSpeed>"
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            String typeOfElement = tokens[1];
            info.putIfAbsent(personName, new HashMap<>());
            info.get(personName).putIfAbsent(typeOfElement, new ArrayList<>());
            switch (typeOfElement) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    company = new Element.Company(companyName, department, salary);
                    if (info.get(personName).get(typeOfElement).size() > 0) {
                        info.get(personName).get(typeOfElement).remove(0);
                    }
                    info.get(personName).get(typeOfElement).add((T) company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    pokemon = new Element.Pokemon(pokemonName, pokemonType);
                    info.get(personName).get(typeOfElement).add((T) pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    parent = new Element.Parent(parentName, parentBirthday);
                    info.get(personName).get(typeOfElement).add((T) parent);
                    break;
                case "children":
                    String childrenName = tokens[2];
                    String childrenBirthday = tokens[3];
                    children = new Element.Children(childrenName, childrenBirthday);
                    info.get(personName).get(typeOfElement).add((T) children);
                    break;
                case "car":
                    String carModel = tokens[2];
                    int speed = Integer.parseInt(tokens[3]);
                    car = new Element.Car(carModel, speed);
                    if (info.get(personName).get(typeOfElement).size() > 0) {
                        info.get(personName).get(typeOfElement).remove(0);
                    }
                    info.get(personName).get(typeOfElement).add((T) car);
                    break;
            }
            input = scan.nextLine();
        }

        String name = scan.nextLine();

        info.entrySet()
                .forEach(e -> {
                    if (e.getKey().equals(name)) {
                        System.out.println(e.getKey());
                        System.out.println("Company:");
                        e.getValue().entrySet().forEach(el -> {
                            if (el.getKey().equals("company")) {
                                toPrint(el);
                            }
                        });
                        System.out.println("Car:");
                        e.getValue().entrySet().forEach(el -> {
                            if (el.getKey().equals("car")) {
                                toPrint(el);
                            }
                        });
                        System.out.println("Pokemon:");
                        e.getValue().entrySet().forEach(el -> {
                            if (el.getKey().equals("pokemon")) {
                                toPrint(el);
                            }
                        });
                        System.out.println("Parents:");
                        e.getValue().entrySet().forEach(el -> {
                            if (el.getKey().equals("parents")) {
                                toPrint(el);
                            }
                        });
                        System.out.println("Children:");
                        e.getValue().entrySet().forEach(el -> {
                            if (el.getKey().equals("children")) {
                                toPrint(el);
                            }
                        });
                    }
                });
    }

    private static <T> void toPrint(Map.Entry<String, ArrayList<T>> el) {
        String output = el.getValue().toString().replaceAll("[\\[\\]]", "");
        System.out.println(output.replaceAll(", ", System.lineSeparator()));
    }
}
