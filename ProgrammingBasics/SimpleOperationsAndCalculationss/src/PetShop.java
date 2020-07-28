import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        int others = Integer.parseInt(scan.nextLine());
        double sum = number * 2.50 + others * 4;
        System.out.printf("%.2f lv.", sum);
    }
}
