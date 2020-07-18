import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int degrees = Integer.parseInt(scan.nextLine());
        String time = scan.nextLine();

        switch (time) {
            case "Morning":
                if (degrees >= 10 && degrees <= 18)
                    System.out.printf("It's %d degrees, get your Sweatshirt and Sneakers.", degrees);
                else  if (degrees > 18 && degrees <= 24)
                    System.out.printf("It's %d degrees, get your Shirt and Moccasins.", degrees);
                else  if (degrees >= 25)
                    System.out.printf("It's %d degrees, get your T-Shirt and Sandals.", degrees);
                break;
            case "Afternoon":
                if (degrees >= 10 && degrees <= 18)
                    System.out.printf("It's %d degrees, get your Shirt and Moccasins.", degrees);
                else  if (degrees > 18 && degrees <= 24)
                    System.out.printf("It's %d degrees, get your T-Shirt and Sandals.", degrees);
                else  if (degrees >= 25)
                    System.out.printf("It's %d degrees, get your Swim Suit and Barefoot.", degrees);
                break;
            case "Evening":
                if (degrees >= 10 && degrees <= 18)
                    System.out.printf("It's %d degrees, get your Shirt and Moccasins.", degrees);
                else  if (degrees > 18 && degrees <= 24)
                    System.out.printf("It's %d degrees, get your Shirt and Moccasins.", degrees);
                else  if (degrees >= 25)
                    System.out.printf("It's %d degrees, get your Shirt and Moccasins.", degrees);
                break;
        }
    }
}
