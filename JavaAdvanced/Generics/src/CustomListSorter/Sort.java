package CustomListSorter;

public class Sort<T extends Comparable<T>> {

    public static void sort(DataList dataList) {
        for (int i = 0; i < dataList.getSize(); i++) {
            String  element = (String) dataList.getElement(i);
            for (int j = i + 1; j < dataList.getSize(); j++) {
                String elementToSwap = (String) dataList.getElement(j);
                if (element.compareTo(elementToSwap) > 0) {
                    dataList.swap(i, j);
                }
            }
        }
    }
}
