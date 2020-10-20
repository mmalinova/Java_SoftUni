package GenericSwapMethodIntegers;

import java.util.ArrayList;

public class GenericList<T> {
    private ArrayList<T> data;

    public ArrayList<T> getData() {
        return data;
    }

    public GenericList() {
        this.data = new ArrayList<>();
    }

    public void swapElements(int firstIndex, int secondIndex) {
        if (!this.data.isEmpty()) {
            T temp = this.data.get(firstIndex);
            this.data.add(firstIndex, this.data.get(secondIndex));
            this.data.remove(++firstIndex);
            this.data.add(secondIndex, temp);
            this.data.remove(++secondIndex);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T datum : data) {
            sb.append(datum.getClass().getName()).append(": ").append(datum);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}

