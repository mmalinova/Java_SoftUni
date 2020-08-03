import java.util.Scanner;

public class SmallestNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //int n = Integer.parseInt(scan.nextLine());

        int[] arrayWithNumbers = new int[3];
        for (int i = 0; i < arrayWithNumbers.length; i++) {
            arrayWithNumbers[i] = Integer.parseInt(scan.nextLine());
        }
        System.out.println(smallestNumber(arrayWithNumbers));
    }

    public static int smallestNumber(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
}
