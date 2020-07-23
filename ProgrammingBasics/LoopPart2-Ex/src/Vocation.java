import java.util.Scanner;

public class Vocation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double money = Double.parseDouble(scan.nextLine());
        double available = Double.parseDouble(scan.nextLine());
        int daysSpend = 0;
        int days = 0;

        while(available < money) {
            String what = scan.nextLine();
            double spend = Double.parseDouble(scan.nextLine());
            days++;
            if (what.equals("spend")) {
                available -= spend;
                daysSpend++;
                if (available < 0)
                    available = 0;
            } else if (what.equals("save")){
                available += spend;
                daysSpend = 0;
            }
            if (daysSpend == 5) {
                System.out.println("You can't save the money.");
                System.out.println(days);
                break;
            }
        }
        if (available >= money) {
            System.out.printf("You saved the money for %d days.", days);
        }
    }
}
