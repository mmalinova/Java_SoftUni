import java.util.Scanner;

public class SushiTime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String type = scan.nextLine();
        String name = scan.nextLine();
        int num = Integer.parseInt(scan.nextLine());
        char order = scan.next().charAt(0);
        double sum = 0;
        boolean isValid = true;

        switch (name) {
            case "Sushi Zone":
                if (type.equals("sashimi")) {
                    sum = 4.99 * num;
                } else if (type.equals("maki")) {
                    sum = 5.29 * num;
                } else if (type.equals("uramaki")) {
                    sum = 5.99 * num;
                } else {
                    sum = 4.29 * num;
                }
                break;
            case "Sushi Time":
                if (type.equals("sashimi")) {
                    sum = 5.49 * num;
                } else if (type.equals("maki")) {
                    sum = 4.69 * num;
                } else if (type.equals("uramaki")) {
                    sum = 4.49 * num;
                } else {
                    sum = 5.19 * num;
                }
                break;
            case "Sushi Bar":
                if (type.equals("sashimi")) {
                    sum = 5.25 * num;
                } else if (type.equals("maki")) {
                    sum = 5.55 * num;
                } else if (type.equals("uramaki")) {
                    sum = 6.25 * num;
                } else {
                    sum = 4.75 * num;
                }
                break;
            case "Asian Pub":
                if (type.equals("sashimi")) {
                    sum = 4.50 * num;
                } else if (type.equals("maki")) {
                    sum = 4.80 * num;
                } else if (type.equals("uramaki")) {
                    sum = 5.50 * num;
                } else {
                    sum = 5.50 * num;
                }
                break;
            default:
                System.out.printf("%s is invalid restaurant!", name);
                isValid = false;
        }
        if (order == 'Y') {
            sum = sum + (sum * 0.20);
        } if (isValid)
            System.out.printf("Total price: %.0f lv.", Math.ceil(sum));
    }
}
