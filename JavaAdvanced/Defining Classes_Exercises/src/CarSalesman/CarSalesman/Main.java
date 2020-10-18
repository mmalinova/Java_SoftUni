package CarSalesman;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Enginee> engines = new LinkedHashMap<>();
        LinkedList<Carr> carrs = new LinkedList<>();

        int n = Integer.parseInt(scan.nextLine());

        Enginee enginee;
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            //"<Model> <Power> <Displacement> <Efficiency>"
            String engineModel = input[0];
            int power = Integer.parseInt(input[1]);
            if (input.length == 4) {
                int displacement = Integer.parseInt(input[2]);
                String efficiency = input[3];
                enginee = new Enginee(engineModel, power, displacement, efficiency);
            } else if (input.length == 3) {
                try {
                    int displacement = Integer.parseInt(input[2]);
                    enginee = new Enginee(engineModel, power, displacement);
                } catch (Exception e) {
                    String efficiency = input[2];
                    enginee = new Enginee(engineModel, power, efficiency);
                }
            } else {
                enginee = new Enginee(engineModel, power);
            }
            engines.putIfAbsent(engineModel, enginee);
        }

        int m = Integer.parseInt(scan.nextLine());

        Carr carr;
        for (int i = 0; i < m; i++) {
            String[] input = scan.nextLine().split("\\s+");
            //"<Model> <Engine> <Weight> <Color>",
            String carModel = input[0];
            String engineModel = input[1];
            if (input.length == 4) {
                int weight = Integer.parseInt(input[2]);
                String color = input[3];
                carr = new Carr(carModel, engines.get(engineModel), weight, color);
            } else if (input.length == 3) {
                try {
                    int weight = Integer.parseInt(input[2]);
                    carr = new Carr(carModel, engines.get(engineModel), weight);
                } catch (Exception e) {
                    String color = input[2];
                    carr = new Carr(carModel, engines.get(engineModel), color);
                }
            } else {
                carr = new Carr(carModel, engines.get(engineModel));
            }
            carrs.add(carr);
        }

        carrs.forEach(e -> System.out.println(e.toString()));
    }
}
