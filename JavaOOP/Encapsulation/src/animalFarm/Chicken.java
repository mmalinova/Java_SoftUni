package animalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if(isNameNotEmpty(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    private void setAge(int age) {
        if(isAgeBetween0And15(age)) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

    public double productPerDay () {
        return calculateProductPerDay();
    }

    @Override
    public String toString() {
        return "Chicken " + name + " (age " + age + ") can produce " + calculateProductPerDay() +
                " eggs per day.";
    }

    private double calculateProductPerDay() {
        //•	First 6 years it produces 2 eggs per day [0 - 5]
        //•	Next 6 years it produces 1 egg per day [6 - 11]
        //•	And after that it produces 0.75 eggs per day
        if (age >= 0 && age <= 5) {
            return 2;
        } else if (age >= 6 && age <= 11) {
            return 1;
        } else {
            return 0.75;
        }
    }

    private boolean isAgeBetween0And15 (int age) {
        return age >= 0 && age <= 15;
    }

    private boolean isNameNotEmpty (String name) {
        return name != null && !name.trim().isEmpty();
    }
}
