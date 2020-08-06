import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        double averageValue = sum * 1.0 / array.length;
        int top5Numbers = 0;

        int[] greater = new int[array.length];  // -1
        int count = 0;
        int[] output = new int[5];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > averageValue) {
                greater[count] = array[i];
                count++;
            }
        }
        for (int i = 0; i < greater.length; ++i)
        {
            for (int j = i + 1; j < greater.length; ++j)
            {
                if (greater[i] < greater[j])
                {
                    int a = greater[i];
                    greater[i] = greater[j];
                    greater[j] = a;
                }
            }
        }
        for (int i = 0; i < greater.length; i++) {
            if (greater[i] != 0) {
                output[i] = greater[i];
                top5Numbers++;
                if (top5Numbers >= 5) {
                    break;
                }
            }
        }
        if (top5Numbers < 1) {
            System.out.println("No");
        } else {
            for (int i = 0; i < top5Numbers; i++) {
                System.out.printf("%d ", output[i]);
            }
        }
    }
}
