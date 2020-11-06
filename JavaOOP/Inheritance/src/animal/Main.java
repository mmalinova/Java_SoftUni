package animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!input.equals("Beast!")) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Animal animal;
            try {
                if (input.equals("Dog")) {
                    animal = new Dog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                } else if (input.equals("Cat")) {
                    animal = new Cat(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                } else if (input.equals("Frog")) {
                    animal = new Frog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                } else if (input.equals("Kittens")) {
                    animal = new Kitten(tokens[0], Integer.parseInt(tokens[1]));
                } else {
                    animal = new Tomcat(tokens[0], Integer.parseInt(tokens[1]));
                }
                animals.add(animal);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
