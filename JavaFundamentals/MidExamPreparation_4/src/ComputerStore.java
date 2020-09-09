import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        double totalPrice = 0.0;
        double taxes = 0.0;
        double totalPriceWithTaxes = 0.0;

        while(!("special".equals(command) || "regular".equals(command))) {
            double price = Double.parseDouble(command);
            if (price < 0) {
                System.out.println("Invalid price!" );
            } else {
                totalPrice += price;
            }
            command = scan.nextLine();
        }
        if (totalPrice == 0) {
            System.out.println("Invalid order!" );
        } else {
            taxes = totalPrice * 0.2;
            totalPriceWithTaxes = totalPrice + taxes;
            if (command.equals("special")) {
                totalPriceWithTaxes *= 0.9;
            }
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.println(String.format("Price without taxes: %.2f$", totalPrice));
            System.out.println(String.format("Taxes: %.2f$", taxes));
            System.out.println("-----------");
            System.out.println(String.format("Total price: %.2f$", totalPriceWithTaxes));
        }
    }
}
