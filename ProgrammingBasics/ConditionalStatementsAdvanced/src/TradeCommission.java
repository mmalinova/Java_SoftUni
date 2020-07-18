import java.util.Scanner;

public class TradeCommission {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String city = scan.nextLine();
        double s = Double.parseDouble(scan.nextLine());

        double comission = 0;

        switch(city) {
            case "Sofia":
                if (s >= 0 && s <= 500){
                    comission = s * 0.05;
                    System.out.printf("%.2f", comission);
                } else if (s > 500 && s <= 1000){
                    comission = s * 0.07;
                    System.out.printf("%.2f", comission);
                } else if (s > 1000 && s <= 10000){
                    comission = s * 0.08;
                    System.out.printf("%.2f", comission);
                } else if (s > 10000){
                comission = s * 0.12;
                System.out.printf("%.2f", comission);
                } else
                    System.out.println("error");
                break;
            case "Plovdiv":
                if (s >= 0 && s <= 500){
                    comission = s * 0.055;
                    System.out.printf("%.2f", comission);
                } else if (s > 500 && s <= 1000){
                    comission = s * 0.08;
                    System.out.printf("%.2f", comission);
                } else if (s > 1000 && s <= 10000){
                    comission = s * 0.12;
                    System.out.printf("%.2f", comission);
                } else if (s > 10000){
                    comission = s * 0.145;
                    System.out.printf("%.2f", comission);
                } else
                    System.out.println("error");
                break;
            case "Varna":
                if (s >= 0 && s <= 500){
                    comission = s * 0.045;
                    System.out.printf("%.2f", comission);
                } else if (s > 500 && s <= 1000){
                    comission = s * 0.075;
                    System.out.printf("%.2f", comission);
                } else if (s > 1000 && s <= 10000){
                    comission = s * 0.1;
                    System.out.printf("%.2f", comission);
                } else if (s > 10000){
                    comission = s * 0.13;
                    System.out.printf("%.2f", comission);
                } else
                    System.out.println("error");
                break;
            default:
                System.out.println("error");
        }
    }
}
