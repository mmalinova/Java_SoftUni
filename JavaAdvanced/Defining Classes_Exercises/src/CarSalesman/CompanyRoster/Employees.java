package CompanyRoster;

//name, salary, position, department, email and age.
// The name, salary, position and department are mandatory while the rest are optional.
public class Employees {
    //mandatory
    private String name;
    private double salary;
    private String position;
    private String department;
    //optional
    private String email;
    private int age;


    public Employees(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employees() {
        this.name = null;
        this.salary = 0.0;
        this.position = null;
        this.department = null;
        this.email = null;
        this.age = 0;
    }

    public Employees(String name, double salary, String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }

    public Employees(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department, "n/a", age);
    }

    public Employees(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department, email, -1);
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d%n", this.name,
                this.salary, this.email, this.age);
    }

}
