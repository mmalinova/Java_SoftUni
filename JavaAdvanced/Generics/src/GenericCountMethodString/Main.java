package GenericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Box box = new Box();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String item = scan.nextLine();
            box.add(item);
        }

        String element = scan.nextLine();
        box.setElement(element);

        System.out.println(box.count());
    }
}
