package wildFarm.animal;

import wildFarm.food.Food;
import wildFarm.food.Vegetable;

public class Mouse extends Mammal{

    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eatFood(Food food) {
        if (food instanceof Vegetable) {
            super.eatFood(food);
        } else {
            System.out.println("Mice are not eating that type of food!");
        }
    }
}
