package OrderByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();

        String command = scan.nextLine();
        while (!"End".equals(command)) {
            String[] input = command.split("\\s+");
            String name = input[0];
            String ID = input[1];
            int age = Integer.parseInt(input[2]);
            Person person = new Person(name, ID, age);
            personList.add(person);
            command = scan.nextLine();
        }
        personList.stream().sorted((p1, p2) -> (Integer.compare(p1.getAge(), p2.getAge())))
                .forEach(person -> System.out.println(person.toString()));
    }
}
