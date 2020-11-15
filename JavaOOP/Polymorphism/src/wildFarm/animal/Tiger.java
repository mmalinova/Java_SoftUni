package wildFarm.animal;

import wildFarm.food.Food;
import wildFarm.food.Meat;

public class Tiger extends Felime{

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eatFood(Food food) {
        if (food instanceof Meat) {
            super.eatFood(food);
        } else {
            System.out.println("Tigers are not eating that type of food!");
        }
    }
}
