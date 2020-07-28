import java.util.Scanner;

public class BachelorParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int moneyForGhost = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();
        int moneyForOne = 0;
        int money = 0;
        int allMoney = 0;
        int count = 0;

        while (!command.equals("The restaurant is full")) {
            int number = Integer.parseInt(command);
            count += number;
            if (number < 5) {
                moneyForOne = 100;
                money = moneyForOne * number;
                allMoney += money;
            } else {
                moneyForOne = 70;
                money = moneyForOne * number;
                allMoney += money;
            }
            command = scan.nextLine();
        }
        if (moneyForGhost <= allMoney) {
            System.out.printf("You have %d guests and %d leva left.", count, allMoney - moneyForGhost);
        } else {
            System.out.printf("You have %d guests and %d leva income, but no singer.", count, allMoney);
        }
    }
}
