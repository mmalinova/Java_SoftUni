import java.util.*;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Integer>> possession = new TreeMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\|");
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);
            possession.putIfAbsent(input[0], new ArrayList<>());
            possession.get(input[0]).add(0, mileage);
            possession.get(input[0]).add(1, fuel);
        }
        String command = scan.nextLine();
        while(!"Stop".equals(command)) {
            String[] tokens = command.split(" : ");
            String car = tokens[1];
            switch(tokens[0]) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuelToDrive = Integer.parseInt(tokens[3]);
                    if (possession.get(car).get(1) < fuelToDrive) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        possession.get(car).add(0, possession.get(car).remove(0) + distance);
                        possession.get(car).add(1, possession.get(car).remove(1) - fuelToDrive);
                        System.out.println(String.format("%s driven for %d kilometers. %d liters of fuel consumed.",
                                car, distance, fuelToDrive));
                        if (possession.get(car).get(0) >= 100000) {
                            possession.remove(car);
                            System.out.println(String.format("Time to sell the %s!", car));
                        }
                    }
                    break;
                case "Refuel":
                    int fuelToRefuel = Integer.parseInt(tokens[2]);
                    int oldFuel = possession.get(car).get(1);
                    if (oldFuel + fuelToRefuel > 75) {
                        possession.get(car).remove(1);
                        possession.get(car).add(1, 75);
                        System.out.println(String.format("%s refueled with %d liters", car, 75 - oldFuel));
                    } else {
                        possession.get(car).add(1, possession.get(car).remove(1) + fuelToRefuel);
                        System.out.println(String.format("%s refueled with %d liters", car, fuelToRefuel));
                    }
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(tokens[2]);
                    int revertMileage = possession.get(car).get(0) - kilometers;
                    if (revertMileage < 10000) {
                        possession.get(car).remove(0);
                        possession.get(car).add(0, 10000);
                    } else {
                        possession.get(car).remove(0);
                        possession.get(car).add(0, revertMileage);
                        System.out.println(String.format("%s mileage decreased by %d kilometers",
                                car, kilometers));
                    }
                    break;
            }
            command = scan.nextLine();
        }
        possession.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    return e2.getValue().get(0).compareTo(e1.getValue().get(0));

                })
                .forEach(element -> {
                    System.out.println(String.format("%s -> Mileage: %d kms, Fuel in the tank: %d lt.",
                            element.getKey(), element.getValue().get(0), element.getValue().get(1)));
                });
    }
}
