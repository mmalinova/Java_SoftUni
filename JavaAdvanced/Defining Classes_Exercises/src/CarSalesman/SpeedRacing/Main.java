package SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Car> mapOfCars = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCost = Double.parseDouble(input[2]);
            Car car = new Car(model, fuelAmount, fuelCost);
            mapOfCars.put(model, car);
        }

        String command = scan.nextLine();
        while (!"End".equals(command)) {
            String[] input = command.split("\\s+");
            if (input[0].equals("Drive")) {
                String carModel = input[1];
                double amountOfKilometers = Double.parseDouble(input[2]);
                if (!mapOfCars.get(carModel).canMoveTheDistance(amountOfKilometers)) {
                    System.out.println("Insufficient fuel for the drive");
                }
            }
            command = scan.nextLine();
        }

        mapOfCars.entrySet()
                .forEach(e -> {
                    System.out.println(e.getValue().toString());
                });
    }
}
