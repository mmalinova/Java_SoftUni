package GenericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Box box = new Box();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            double item = Double.parseDouble(scan.nextLine());
            box.add(item);
        }

        double element = Double.parseDouble(scan.nextLine());
        box.setElement(element);

        System.out.println(box.count());
    }
}
