package wildFarm.animal;

import wildFarm.food.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    protected String animalName;
    protected String animalType;
    protected Double animalWeight;
    protected String livingRegion;
    protected Integer foodEaten;

    public Animal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.livingRegion = livingRegion;
        this.foodEaten = 0;
    }

    public abstract void makeSound();

    public void eatFood(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        //Tiger[Tom, 167.7, Asia, 0]
        return String.format("%s[%s, %s, %s, %d]", animalType, animalName, decimalFormat.format(animalWeight),
                livingRegion, foodEaten);
    }
}
