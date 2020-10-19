package RowData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Car> list = new LinkedList<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            //"<Model> <EngineSpeed> <EnginePower> <CargoWeight> <CargoType>
            // <Tire1Pressure> <Tire1Age> <Tire2Pressure> <Tire2Age> <Tire3Pressure> <Tire3Age> <Tire4Pressure> <Tire4Age>"
            String[] input = scan.nextLine().split("\\s+");
            String model = input[0];
            int speed = Integer.parseInt(input[1]);
            int power = Integer.parseInt(input[2]);
            int weight = Integer.parseInt(input[3]);
            String type = input[4];
            double pressure1 = Double.parseDouble(input[5]);
            int age1 = Integer.parseInt(input[6]);
            double pressure2 = Double.parseDouble(input[7]);
            int age2 = Integer.parseInt(input[8]);
            double pressure3 = Double.parseDouble(input[9]);
            int age3 = Integer.parseInt(input[10]);
            double pressure4 = Double.parseDouble(input[11]);
            int age4 = Integer.parseInt(input[12]);

            Car car = new Car(model, speed, power, weight, type,
                    pressure1, age1, pressure2, age2, pressure3, age3, pressure4, age4);
            list.add(car);
        }

        String command = scan.nextLine();
        if (command.equals("fragile")) {
                list.stream().filter(car -> car.getCargo().getType().equals("fragile"))
                        .forEach(car -> {
                            for (int j = 0; j < car.getTires().length; j++) {
                                if (car.getTires()[j][0].getPressure() < 1) {
                                    System.out.println(car.getModel());
                                    return;
                                }
                            }
                        });
        } else if (command.equals("flamable")) {
            list.stream().filter(car -> car.getCargo().getType().equals("flamable"))
                    .filter(car -> car.getEngine().getPower() > 250)
                    .forEach(car -> System.out.println(car.getModel()));
        }
    }
}
