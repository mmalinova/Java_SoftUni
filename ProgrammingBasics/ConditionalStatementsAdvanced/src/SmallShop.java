import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String product = scan.nextLine();
        String city = scan.nextLine();
        double amount = Double.parseDouble(scan.nextLine());

        double price = 0;

        switch (product){
            case "coffee":
                switch(city){
                    case "Sofia":
                        price = 0.5 * amount;
                        System.out.println(price);
                        break;
                    case "Plovdiv":
                        price = 0.4 * amount;
                        System.out.println(price);
                        break;
                    case "Varna":
                        price = 0.45 * amount;
                        System.out.println(price);
                        break;
                }
                break;
            case "water":
                switch(city){
                    case "Sofia":
                        price = 0.8 * amount;
                        System.out.println(price);
                        break;
                    case "Plovdiv":
                        price = 0.7 * amount;
                        System.out.println(price);
                        break;
                    case "Varna":
                        price = 0.7 * amount;
                        System.out.println(price);
                        break;
                }
                break;
            case "beer":
                switch(city) {
                    case "Sofia":
                        price = 1.2 * amount;
                        System.out.println(price);
                        break;
                    case "Plovdiv":
                        price = 1.15 * amount;
                        System.out.println(price);
                        break;
                    case "Varna":
                        price = 1.1 * amount;
                        System.out.println(price);
                        break;
                }
                break;
            case "sweets":
                switch(city) {
                    case "Sofia":
                        price = 1.45 * amount;
                        System.out.println(price);
                        break;
                    case "Plovdiv":
                        price = 1.3 * amount;
                        System.out.println(price);
                        break;
                    case "Varna":
                        price = 1.35 * amount;
                        System.out.println(price);
                        break;
                }
                break;
            case "peanuts":
                switch(city) {
                    case "Sofia":
                        price = 1.6 * amount;
                        System.out.println(price);
                        break;
                    case "Plovdiv":
                        price = 1.5 * amount;
                        System.out.println(price);
                        break;
                    case "Varna":
                        price = 1.55 * amount;
                        System.out.println(price);
                        break;
                }
                break;
        }
    }
}
