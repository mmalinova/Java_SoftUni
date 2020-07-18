import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String type = scan.nextLine();
        int rows = Integer.parseInt(scan.nextLine());
        int columns = Integer.parseInt(scan.nextLine());

        double price = 0;
        int area = rows * columns;

        if (type.equals("Premiere")){
            price = area * 12;
        } else if (type.equals("Normal")){
            price = area * 7.5;
        } else if (type.equals("Discount")){
            price = area * 5;
        }
        System.out.printf("%.2f", price);
    }
}
