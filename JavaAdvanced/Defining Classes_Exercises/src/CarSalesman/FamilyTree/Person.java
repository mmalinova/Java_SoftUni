package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public String data;
    private List<String> parents;
    private List<String> children;

    public Person(String data) {
        this.data = data;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setChildren(String data) {
        this.children.add(data);
    }

    public void setParents(String data) {
        this.parents.add(data);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(this.data);
        print.append("\nParents:\n");
        this.parents.forEach(e -> print.append(e).append("\n"));
        print.append("Children:\n");
        this.children.forEach(e -> print.append(e).append("\n"));
        return print.toString();
    }
}

