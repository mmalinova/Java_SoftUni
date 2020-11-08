package pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            String[] pizzas = scan.nextLine().split("\\s+");
            Pizza pizza = new Pizza(pizzas[1], Integer.parseInt(pizzas[2]));

            String[] doughOfPizza = scan.nextLine().split("\\s+");
            Dough dough = new Dough(doughOfPizza[1], doughOfPizza[2], Double.parseDouble(doughOfPizza[3]));
            pizza.setDough(dough);

            String command = scan.nextLine();
            while (!"END".equals(command)) {
                String[] toppingOfPizza = command.split("\\s+");
                Topping topping = new Topping(toppingOfPizza[1], Double.parseDouble(toppingOfPizza[2]));
                pizza.addTopping(topping);
                command = scan.nextLine();
            }
            System.out.println(pizza.toString());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
