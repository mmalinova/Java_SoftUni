import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String type = scan.nextLine();

        if (type.equals("square")) {
            double size = Double.parseDouble(scan.nextLine());
            System.out.printf("%.3f", size * size);
        }
        else if(type.equals("rectangle")) {
            double size1 = Double.parseDouble(scan.nextLine());
            double size2 = Double.parseDouble(scan.nextLine());
            System.out.printf("%.3f", size1 * size2);
        }
        else if(type.equals("circle")) {
            double size = Double.parseDouble(scan.nextLine());
            System.out.printf("%.3f", (size * size) * 3.14159265359);
        }
        else if(type.equals("triangle")) {
            double size1 = Double.parseDouble(scan.nextLine());
            double size2 = Double.parseDouble(scan.nextLine());
            System.out.printf("%.3f", (size1 * size2) / 2);
        }
    }
}
