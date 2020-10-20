package CustomListSorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DataList<T extends Comparable<T>> {
    private List<T> data;

    public DataList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T remove(int index) {
        if (index < 0 || index > this.data.size()) {
            throw new IndexOutOfBoundsException("Index was out of bounds.");
        }

        return this.data.remove(index);
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        if (firstIndex < 0 || firstIndex > this.data.size()) {
            throw new IndexOutOfBoundsException("Index was out of bounds.");
        }

        if (secondIndex < 0 || secondIndex > this.data.size()) {
            throw new IndexOutOfBoundsException("Index was out of bounds.");
        }

        if (!this.data.isEmpty()) {
            T temp = this.data.get(firstIndex);
            this.data.add(firstIndex, this.data.get(secondIndex));
            this.data.remove(++firstIndex);
            this.data.add(secondIndex, temp);
            this.data.remove(++secondIndex);
        }
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    public T getMax() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("List is empty.");
        }

        this.data.sort(Comparator.reverseOrder());
        return this.data.get(0);
    }

    public T getMin() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("List is empty.");
        }

        this.data.sort(Comparable::compareTo);
        return this.data.get(0);
    }

    public int getSize() {
        return this.data.size();
    }

    public T getElement (int index) {
        return this.data.get(index);
    }
    
}
