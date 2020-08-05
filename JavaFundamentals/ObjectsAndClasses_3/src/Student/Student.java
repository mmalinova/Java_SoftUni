package Student;

public class Student {
    private String firsName;
    private String lastName;
    private double grade;

    public Student(String firsName, String lastName, double grade) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public double getGrade() {
        return this.grade;
    }

    @Override
    public String toString() { return String.format("%s %s: %.2f", this.firsName, this.lastName, this.grade);
    }
}
