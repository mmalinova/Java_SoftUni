import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        /*Class[] citizenInterfaces = Citizen.class.getInterfaces();

        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
            Method[] methods = Birthable.class.getDeclaredMethods();
            methods = Identifiable.class.getDeclaredMethods();
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            String id = scanner.nextLine();
            String birthDate = scanner.nextLine();
            Identifiable identifiable = new Citizen(name,age,id,birthDate);
            Birthable birthable = new Citizen(name,age,id,birthDate);
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
        }
         */

        /*List<Birthable> birthableList = new ArrayList<>();

        String command = scanner.nextLine();
        while(!"End".equals(command)) {
            String[] tokens = command.split("\\s+");
            //formats "Citizen <name> <age> <id> <birthdate>" for citizens,
            //"Robot <model> <id>" for robots or "Pet <name> <birthdate>"
            switch (tokens[0]) {
                case "Citizen":
                    Birthable citizen = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3]
                            , tokens[4]);
                    birthableList.add(citizen);
                    break;
                case "Robot":
                    Robot robot = new Robot(tokens[1], tokens[2]);
                    break;
                case "Pet":
                    Birthable pet = new Pet(tokens[1], tokens[2]);
                    birthableList.add(pet);
                    break;
            }
            command = scanner.nextLine();
        }
        String year = scanner.nextLine();
        for (Birthable birthable : birthableList) {
            String[] date = birthable.getBirthDate().split("/");
            if(date[2].equals(year)) {
                System.out.println(birthable.getBirthDate());
            }
        }
         */
        Map<String, Buyer> people = new HashMap<>();

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        int totalFood = 0;
        //"<name> <age> <id> <birthdate>" for a Citizen or
        //"<name> <age><group>" for a Rebel
        for (int i = 0; i < numberOfPeople; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            if (data.length == 4) {
                Citizen citizen = new Citizen(data[0], Integer.parseInt(data[1]), data[2], data[3]);
                citizen.buyFood();
                people.putIfAbsent(data[0], citizen);
            } else if (data.length == 3) {
                Rebel rebel = new Rebel(data[0], Integer.parseInt(data[1]), data[2]);
                rebel.buyFood();
                people.putIfAbsent(data[0], rebel);
            }
        }
        String name = scanner.nextLine();
        while (!"End".equals(name)) {
            if (people.containsKey(name)) {
                if (people.get(name) instanceof Citizen) {
                    totalFood += people.get(name).getFood();
                } else if (people.get(name) instanceof Rebel) {
                    totalFood += people.get(name).getFood();
                }
            }
            name = scanner.nextLine();
        }
        System.out.println(totalFood);
    }
}
