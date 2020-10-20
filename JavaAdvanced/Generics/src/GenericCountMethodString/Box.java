package GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> data;
    private T element;

    public Box() {
        data = new ArrayList<>();
    }

    public void add (T data) {
        this.data.add(data);
    }

    public void setElement(T element) {
        this.element = element;
    }

    public long count() {
        return this.data.stream().filter(e -> e.compareTo(this.element) > 0).count();
    }
}
