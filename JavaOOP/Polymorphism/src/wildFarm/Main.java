package wildFarm;

import wildFarm.animal.*;
import wildFarm.food.Food;
import wildFarm.food.Meat;
import wildFarm.food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String command = scan.nextLine();
        while(!"End".equals(command)) {
            String[] animalInfo = command.split("\\s+");
            Animal animal = createAnimal(animalInfo);
            animal.makeSound();
            String[] foodInfo = scan.nextLine().split("\\s+");
            Food food = createFood(foodInfo);
            animal.eatFood(food);
            animals.add(animal);
            command = scan.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

    private static Food createFood(String[] foodInfo) {
        switch(foodInfo[0]) {
            case "Meat":
                return new Meat(Integer.parseInt(foodInfo[1]));
            case "Vegetable":
                return new Vegetable(Integer.parseInt(foodInfo[1]));
            default:
                throw new IllegalStateException("Unknown Food type for " + foodInfo[0]);
        }
    }

    private static Animal createAnimal(String[] animalInfo) {
        switch(animalInfo[0]) {
            case "Mouse":
                return new Mouse(animalInfo[1], animalInfo[0], Double.parseDouble(animalInfo[2]), animalInfo[3]);
            case "Zebra":
                return new Zebra(animalInfo[1], animalInfo[0], Double.parseDouble(animalInfo[2]), animalInfo[3]);
            case "Cat":
                return new Cat(animalInfo[1], animalInfo[0], Double.parseDouble(animalInfo[2]), animalInfo[3],
                        animalInfo[4]);
            case "Tiger":
                return new Tiger(animalInfo[1], animalInfo[0], Double.parseDouble(animalInfo[2]), animalInfo[3]);
            default:
                throw new IllegalStateException("Unknown Animal type for " + animalInfo[0]);
        }
    }
}
