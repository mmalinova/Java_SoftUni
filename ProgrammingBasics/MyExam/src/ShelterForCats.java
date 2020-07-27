import java.util.Scanner;

public class ShelterForCats {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int buyFood = Integer.parseInt(scan.nextLine()) * 1000;

        String command = scan.nextLine();
        int all = 0;

        while (!command.equals("Adopted")) {
            int grams = Integer.parseInt(command);
            all += grams;
            command = scan.nextLine();
        }
        if (buyFood >= all) {
            System.out.printf("Food is enough! Leftovers: %d grams.", buyFood - all);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", all - buyFood);
        }
    }
}
