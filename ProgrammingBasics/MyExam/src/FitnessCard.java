import java.util.Scanner;

public class FitnessCard {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double money = Double.parseDouble(scan.nextLine());
        char sex = scan.nextLine().charAt(0);
        int age = Integer.parseInt(scan.nextLine());
        String sport = scan.nextLine();

        double need = 0;

        switch (sport) {
            case "Gym":
                if (sex == 'm') {
                    need = 42;
                } else {
                    need = 35;
                }
                break;
            case "Boxing":
                if (sex == 'm') {
                    need = 41;
                } else {
                    need = 37;
                }
                break;
            case "Yoga":
                if (sex == 'm') {
                    need = 45;
                } else {
                    need = 42;
                }
                break;
            case "Zumba":
                if (sex == 'm') {
                    need = 34;
                } else {
                    need = 31;
                }
                break;
            case "Dances":
                if (sex == 'm') {
                    need = 51;
                } else {
                    need = 53;
                }
                break;
            case "Pilates":
                if (sex == 'm') {
                    need = 39;
                } else {
                    need = 37;
                }
                break;
        }
        if (age <= 19) {
            need -= need * 0.20;
        }
        if (money >= need) {
            System.out.printf("You purchased a 1 month pass for %s.", sport);
        } else {
            System.out.printf("You don't have enough money! You need $%.2f more.", need - money);
        }
    }
}
