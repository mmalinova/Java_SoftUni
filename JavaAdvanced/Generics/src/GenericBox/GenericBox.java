package GenericBox;

import java.util.ArrayList;
import java.util.List;

public class GenericBox<T> {
    private List<T> box;

    public GenericBox() {
        this.box = new ArrayList<>();

    }

    public void add(T element) {
        this.box.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T t : box) {
            sb.append(String.format("%s: %s", t.getClass(), t)).append(System.lineSeparator());

        }

        return sb.toString().replaceAll("class ", "");
    }
}
