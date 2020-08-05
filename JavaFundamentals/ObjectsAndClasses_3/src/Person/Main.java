package Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        String nameInit = "";
        int ageInit = 0;

        Person person = new Person(nameInit, ageInit);
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            nameInit = input[0];
            ageInit = Integer.parseInt(input[1]);
            person = new Person(nameInit, ageInit);
            personList.add(person);
        }
        //personList.stream().sorted((p1, p2) -> (Integer.compare(p1.getAge(), p2.getAge())));

        personList.stream().filter((p -> p.getAge() > 30)).sorted((p1, p2) -> (p1.getName().compareTo(p2.getName()))).
                forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));
    }
}
