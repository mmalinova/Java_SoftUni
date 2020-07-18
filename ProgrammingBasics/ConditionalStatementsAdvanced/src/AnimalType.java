import java.util.Scanner;

public class AnimalType {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String animal = scan.nextLine();

        if (animal.equals("dog"))
            System.out.println("mammal");
        else if (animal.equals("crocodile") || animal.equals("tortoise") || animal.equals("snake"))
            System.out.println("reptile");
        else
            System.out.println("unknown");
    }
}
