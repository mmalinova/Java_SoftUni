import java.util.Scanner;

public class ReadText {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        while (!text.equals("Stop")) {
            text = scan.nextLine();
        }
    }
}
