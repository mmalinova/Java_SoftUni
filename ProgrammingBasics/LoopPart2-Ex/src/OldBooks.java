import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String book = scan.nextLine();
        int capacity = Integer.parseInt(scan.nextLine());

        int number = 0;
        boolean found = false;

        String input = scan.nextLine();
        while (!input.equals(book) && capacity > number) {
            input = scan.nextLine();
            if (input.equals(book)) {
                found = true;
            } else
                number++;
        }
        if (found)
            System.out.printf("You checked %d books and found it.", number);
        else {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", number);
        }
    }
}
