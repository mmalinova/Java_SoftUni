package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Department listOfEmployees = new Department();
        Map<String, ArrayList<Employees>> map = new HashMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            Employees employee;
            String[] input = scan.nextLine().split("\\s+");
            //name, salary, position, department, email and age.
            // The name, salary, position and department are mandatory while the rest are optional.
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            map.putIfAbsent(department, new ArrayList<>());
            if (input.length == 6) {
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employees(name, salary, position, department, email, age);
            } else if (input.length == 5) {
                try {
                    int age = Integer.parseInt(input[4]);
                    employee = new Employees(name, salary, position, department, age);
                } catch (IllegalArgumentException e){
                    String email = input[4];
                    employee = new Employees(name, salary, position, department, email);
                }
            } else {
                employee = new Employees(name, salary, position, department);
            }
            listOfEmployees.employees.add(employee);
            map.get(department).add(employee);
        }

        double average = Double.MIN_VALUE;
        String depName = "";
        for(Map.Entry<String, ArrayList<Employees>> element : map.entrySet()) {
            double sum = 0;
            for (int i = 0; i < element.getValue().size(); i++) {
                sum += element.getValue().get(i).getSalary();
            }
            double currentAverage = sum / element.getValue().size();
            if (currentAverage > average) {
                average  = currentAverage;
                depName = element.getKey();
            }
        }

        System.out.printf("Highest Average Salary: %s%n", depName);
        String finalDepName = depName;
        map.entrySet()
                .stream()
                .forEach(e -> {
                    if (e.getKey().equals(finalDepName)) {
                        e.getValue().sort(Comparator.comparingDouble(Employees::getSalary).reversed());
                        e.getValue().forEach(element -> System.out.print(element.toString()));
                        };
                });

    }
}
