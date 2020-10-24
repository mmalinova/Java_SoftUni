package christmas;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Bag {
    private List<Present> data;
    private String color;
    private int capacity;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new LinkedList<>();
    }

    public String getColor() {
        return this.color;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size() < capacity) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        for (Present datum : data) {
            if (datum.getName().equals(name)) {
                this.data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent() {
        return this.data.stream().max(Comparator.comparing(Present::getWeight)).orElseThrow();
    }

    public Present getPresent(String name) {
        for (Present datum : data) {
            if (datum.getName().equals(name)) {
                return datum;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.color).append(" bag contains:");
        sb.append(System.lineSeparator());
        for (Present datum : data) {
            sb.append(datum.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
