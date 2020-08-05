package Person;

public class Person {
    private String name;
    private  int age;

    public Person(String nameInit, int ageInit) {
        this.name = nameInit;
         this.age = ageInit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }
}
