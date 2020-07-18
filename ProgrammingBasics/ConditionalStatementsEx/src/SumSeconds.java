import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int sec1 = Integer.parseInt(scan.nextLine());
        int sec2 = Integer.parseInt(scan.nextLine());
        int sec3 = Integer.parseInt(scan.nextLine());

        int secTogether = sec1 + sec2 + sec3;
        int minutes = secTogether / 60;
        int seconds =  secTogether % 60;
        System.out.printf("%d:%02d", minutes, seconds);
    }
}
