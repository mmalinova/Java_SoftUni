package VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //{typeOfVehicle} {model} {color} {horsepower}
        String command = scan.nextLine();
        List<Vehicle> vehicleList = new ArrayList<>();

        int countOfCars = 0;
        int countOfTrucks = 0;
        int horsepowerOfCars = 0;
        int horsepowerOfTrucks = 0;

        while(!"End".equals(command)) {
            String[] input = command.split("\\s+");
            String typeOfVehicle = input[0];
            String model = input[1];
            String color = input[2];
            int horsepower = Integer.parseInt(input[3]);
            switch (typeOfVehicle) {
                case "car":
                    countOfCars++;
                    horsepowerOfCars += horsepower;
                    break;
                case "truck":
                    countOfTrucks++;
                    horsepowerOfTrucks += horsepower;
                    break;
            }
            Vehicle vehicle = new Vehicle(typeOfVehicle, model, color, horsepower);
            vehicleList.add(vehicle);
            command = scan.nextLine();
        }
        //Type: {typeOfVehicle}
        //Model: {modelOfVehicle}
        //Color: {colorOfVehicle}
        //Horsepower: {horsepowerOfVehicle}
        String commandNext = scan.nextLine();

        while(!"Close the Catalogue".equals(commandNext)) {
            String modelOfVehicle = commandNext;
            vehicleList.stream().filter(v -> v.getModel().equals(modelOfVehicle)).forEach(v ->
                    System.out.printf("Type: %s%nModel: %s%nColor: %s%nHorsepower: %s%n",
                            v.getType().substring(0, 1).toUpperCase() + v.getType().substring(1),
                            v.getModel(), v.getColor(), v.getHorsepower()));

            commandNext = scan.nextLine();
        }
        double averageHorsepowerOfCars = 0;
        if (countOfCars != 0) {
            averageHorsepowerOfCars = horsepowerOfCars * 1.0 / countOfCars;
        }
        double averageHorsepowerOfTrucks = 0;
        if (countOfTrucks != 0) {
            averageHorsepowerOfTrucks = horsepowerOfTrucks * 1.0 / countOfTrucks;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", averageHorsepowerOfCars);
        System.out.printf("Trucks have average horsepower of: %.2f.", averageHorsepowerOfTrucks);
    }
}
