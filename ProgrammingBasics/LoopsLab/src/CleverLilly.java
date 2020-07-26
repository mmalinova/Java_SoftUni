import java.util.Scanner;

public class CleverLilly {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int age = Integer.parseInt(scan.nextLine());
        double machine = Double.parseDouble(scan.nextLine());
        int price = Integer.parseInt(scan.nextLine());

        int money = 0;
        int count = 0;

        for (int i = 1; i <= age; i++){
            if (i % 2 == 0) {
                for (int n = 0; n < i / 2; n++) {
                    money += 10;
                }
                money--;
            } else {
                count++;
            }
        }
        money += count * price;
        if (money >= machine) {
            System.out.printf("Yes! %.2f", money - machine);
        } else {
            System.out.printf("No! %.2f", machine - money);
        }
    }
}
