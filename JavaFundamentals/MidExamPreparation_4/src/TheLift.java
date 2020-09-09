import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int peopleWait = Integer.parseInt(scan.nextLine());
        String[] currentState = scan.nextLine().split(" ");

        int[] wagons = new int[currentState.length];

        for (int i = 0; i < currentState.length; i++) {
            wagons[i] = Integer.parseInt(currentState[i]);
        }

        for (int i = 0; i < wagons.length; i++) {
            if (peopleWait > 0) {
                while (wagons[i] < 4) {
                    if (peopleWait <= 0) {
                        break;
                    }
                    wagons[i]++;
                    peopleWait--;
                }
            }
        }
        if (peopleWait <= 0 && wagons[wagons.length - 1] < 4) {
            System.out.println("The lift has empty spots!");
        } else if (peopleWait > 0 && wagons[wagons.length - 1] >= 4) {
            System.out.println(String.format("There isn't enough space! %d people in a queue!", peopleWait));
        }
        System.out.println(Arrays.toString(wagons).replaceAll("[\\[\\],]", ""));
    }
}
