package Google;

public class Element {
    private String name;

    public Element(String companyName, String department, double salary) {
        new Company(companyName, department, salary);
    }

    public static class Company {
        private String companyName;
        private String department;
        private double salary;

        public Company(String companyName, String department, double salary) {
            this.companyName = companyName;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("%s %s %.2f", companyName, department, salary);
        }
    }

    public static class Pokemon {
        private String pokemonName;
        private String pokemonType;

        public Pokemon(String pokemonName, String pokemonType) {
            this.pokemonName = pokemonName;
            this.pokemonType = pokemonType;
        }

        @Override
        public String toString() {
            return String.format("%s %s", pokemonName, pokemonType);
        }
    }

    public static class Parent {
        private String parentName;
        private String parentBirthday;

        public Parent(String parentName, String parentBirthday) {
            this.parentName = parentName;
            this.parentBirthday = parentBirthday;
        }

        @Override
        public String toString() {
            return String.format("%s %s", parentName, parentBirthday);
        }
    }

    public static class Children {
        private String childrenName;
        private String childrenBirthday;

        public Children(String childrenName, String childrenBirthday) {
            this.childrenName = childrenName;
            this.childrenBirthday = childrenBirthday;
        }

        @Override
        public String toString() {
            return String.format("%s %s", childrenName, childrenBirthday);
        }
    }

    public static class Car {
        private String carModel;
        private int carSpeed;

        public Car(String carModel, int carSpeed) {
            this.carModel = carModel;
            this.carSpeed = carSpeed;
        }

        @Override
        public String toString() {
            return String.format("%s %d", carModel, carSpeed);
        }
    }
}
