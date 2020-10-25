package classroom;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    public int capacity;
    public List<Student> students;

    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        for (Student datum : this.students) {
            if (datum.getFirstName().equals(student.getFirstName())
                    && datum.getLastName().equals(student.getLastName())) {
                    //&& datum.getBestSubject().equals(student.getBestSubject())) {
                return "Student is already in the classroom";
            }
        }
        if (this.students.size() < this.capacity) {
            this.students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "No seats in the classroom";
        }
    }

    public String dismissStudent(Student student) {
        for (Student datum : this.students) {
            if (datum.getFirstName().equals(student.getFirstName())
                    && datum.getLastName().equals(student.getLastName())) {
                    //&& datum.getBestSubject().equals(student.getBestSubject())) {
                this.students.remove(student);
                return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
            }
        }
        return "Student not found";
    }

    public String getSubjectInfo(String subject) {
        boolean isStudent = false;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Subject: %s", subject)).append(System.lineSeparator());
        sb.append("Students:").append(System.lineSeparator());
        for (Student datum : this.students) {
            if (datum.getBestSubject().equals(subject)) {
                sb.append(datum.getFirstName()).append(" ").append(datum.getLastName())
                        .append(System.lineSeparator());
                isStudent = true;
            }
        }
        if (isStudent) {
            return sb.toString().trim();
        } else {
            return "No students enrolled for the subject";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student datum : this.students) {
            if (datum.getFirstName().equals(firstName)
                    && datum.getLastName().equals(lastName)) {
                return datum;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Classroom size: %d", this.students.size()))
                .append(System.lineSeparator());
        for (Student datum : this.students) {
            output.append("==");
            output.append(datum.string())
                    .append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
