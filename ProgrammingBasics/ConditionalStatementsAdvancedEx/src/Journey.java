import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String sezon = scan.nextLine();

        String type = "s";
        String destination = "s";

        switch (sezon){
            case "summer":
                type = "Camp";
                break;
            case "winter":
                type = "Hotel";
                break;
        }
        if (budget <= 100) {
            destination = "Bulgaria";
            if (sezon.equals("summer"))
                budget *= 0.30;
            else if (sezon.equals("winter"))
                budget *= 0.70;
        }
        else if (budget <= 1000) {
            destination = "Balkans";
            if (sezon.equals("summer"))
                budget *= 0.40;
            else if (sezon.equals("winter"))
                budget *= 0.80;
        }
        else if (budget > 1000) {
            destination = "Europe";
            budget *= 0.90;
        }
        if (destination.equals("Europe"))
            type = "Hotel";

        System.out.printf("Somewhere in %s", destination);
        System.out.printf("%n%s - %.2f", type, budget);
    }
}
