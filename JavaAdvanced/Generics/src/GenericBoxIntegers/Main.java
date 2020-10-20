package GenericBoxIntegers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        GenericBox<Integer> box = new GenericBox<Integer>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            box.add(Integer.parseInt(input));
        }

        System.out.println(box);
    }
}
