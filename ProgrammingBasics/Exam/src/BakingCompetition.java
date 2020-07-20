import java.util.Scanner;

public class BakingCompetition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int all = 0;
        double allSum = 0;

        for (int i = 0; i < n; i++) {
            double price = 0;
            int countCookies = 0;
            int countCakes = 0;
            int countWaffles = 0;
            String name = scan.nextLine();
            String type = scan.nextLine();
            while (!type.equals("Stop baking!")) {
                int count = Integer.parseInt(scan.nextLine());
                switch (type) {
                    case "cookies":
                        countCookies += count;
                        price = count * 1.50;
                        break;
                    case "cakes":
                        countCakes += count;
                        price = count * 7.80;
                        break;
                    case "waffles":
                        countWaffles += count;
                        price = count * 2.30;
                        break;
                }
                all += count;
                allSum += price;
                type = scan.nextLine();
            }
            System.out.printf("%s baked %d cookies, %d cakes and %d waffles.%n", name, countCookies, countCakes, countWaffles);
        }
        System.out.printf("All bakery sold: %d%n", all);
        System.out.printf("Total sum for charity: %.2f lv.%n", allSum);
    }
}
