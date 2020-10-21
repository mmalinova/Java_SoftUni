package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ListyIterator implements Iterable{
    private List<String> data = new ArrayList<>();
    private int index = 0;

    public ListyIterator(List<String> list) {
        if (!list.isEmpty()) {
            this.data.addAll(list);
        }
    }
//•	Move - should move an internal index position to the next index in the list, the method should return true if it successfully moved and false if there is no next index.
//•	HasNext - should return true if there is a next index and false if the index is already at the last element of the list.
//•	Print - should print the element at the current internal index, calling Print on a collection without elements should throw an appropriate exception with the message "Invalid Operation!".

    public boolean Move() {
        if(iterator().hasNext()) {
            index += 1;
            return true;
        }
        return false;
    }

    public void PrintAll() {
        if (data.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String datum : data) {
                sb.append(datum).append(" ");
            }
            System.out.println(sb.substring(0, sb.length()));
        }
    }

    public void Print() {
        if (data.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(data.get(index));
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return index < data.size() - 1;
            }

            @Override
            public Object next() {
                if (hasNext()) {
                    index += 1;
                    return true;
                }
                return false;
            }
        };
    }
}
