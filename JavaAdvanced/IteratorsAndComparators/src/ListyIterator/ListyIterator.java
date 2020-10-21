package ListyIterator;

import java.util.ArrayList;
import java.util.List;

public class ListyIterator {
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
        if(hasNext()) {
            index += 1;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return index < data.size() - 1;
    }

    public void Print() {
        if (data.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(data.get(index));
        }
    }
}
