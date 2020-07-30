import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lostGames = Integer.parseInt(scan.nextLine());
        double headsetPrice = Double.parseDouble(scan.nextLine());
        double mousePrice = Double.parseDouble(scan.nextLine());
        double keyboardPrice = Double.parseDouble(scan.nextLine());
        double displayPrice = Double.parseDouble(scan.nextLine());

        double expenses = 0.0;

        int headsetTrash = lostGames / 2;
        int mouseTrash = lostGames / 3;
        int keyboardTrash = lostGames / 6;
        int displayTrash = keyboardTrash / 2;

        expenses = (headsetPrice * (headsetTrash * 1.0)) + (mousePrice * (mouseTrash * 1.0)) + (keyboardPrice * (keyboardTrash * 1.0)) + (displayPrice * (displayTrash * 1.0));

        System.out.printf("Rage expenses: %.2f lv.", expenses);
    }
}
