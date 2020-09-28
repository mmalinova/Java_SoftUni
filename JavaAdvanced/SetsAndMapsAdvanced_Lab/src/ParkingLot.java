import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<String> cars = new LinkedHashSet<>();

        String command = scan.nextLine();

        while (!"END".equals(command)) {
            String direction = command.substring(0, command.indexOf(","));
            String carNumber = command.substring(command.indexOf(" ") + 1);

            if (direction.equals("IN")) {
                cars.add(carNumber);
            } else if (direction.equals("OUT")) {
                cars.remove(carNumber);
            }
            command = scan.nextLine();
        }
        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}
