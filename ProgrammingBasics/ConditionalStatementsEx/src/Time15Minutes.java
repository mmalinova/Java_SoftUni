import java.util.Scanner;

public class Time15Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hour = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        minutes = minutes + 15;
        if (minutes > 59) {
            hour = hour + 1;
            minutes = minutes - 60;
            if (hour > 23) {
                hour = 0;
            }
        }

        System.out.printf("%d:%02d", hour, minutes);
    }
}
