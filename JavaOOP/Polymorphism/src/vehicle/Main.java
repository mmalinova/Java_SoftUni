package vehicle;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new HashMap<>();

        String[] carInfo = scan.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        vehicles.putIfAbsent("Car", car);
        String[] truckInfo = scan.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));
        vehicles.putIfAbsent("Truck", truck);

        int numberOfCommands = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scan.nextLine().split("\\s+");
            if (command[0].equals("Drive")) {
                String drive = vehicles.get(command[1]).drive(Double.parseDouble(command[2]));
                System.out.println(drive);
            } else if (command[0].equals("Refuel")) {
                vehicles.get(command[1]).refuel(Double.parseDouble(command[2]));
            }
        }

        System.out.println(vehicles.get("Car").toString());
        System.out.println(vehicles.get("Truck").toString());
    }
}
