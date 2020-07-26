import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int width = Integer.parseInt(scan.nextLine());
        int length = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());

        int free = width * length * height;

        String input = scan.nextLine();
        int boxes = 0;

        while (!input.equals("Done")) {
            int parse = Integer.parseInt(input);
            boxes += parse;
            if (free < boxes) {
                System.out.printf("No more free space! You need %d Cubic meters more.", boxes - free);
                break;
            }
            input = scan.nextLine();
        }
        if (free >= boxes)
            System.out.printf("%d Cubic meters left.", free - boxes);
    }
}
