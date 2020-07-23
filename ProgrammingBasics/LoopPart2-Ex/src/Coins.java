import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //възможно най - малко монети
        //приема се ресто, което трябва да се върне
        //изчислява с колко монети най - малко може да се върне рестото

        double money = Double.parseDouble(scan.nextLine());
        double rest = Math.round(money * 100);
        int count = 0;

        while (rest > 0) {
            if (rest >= 200) {
                rest -= 200;
                count++;
            } else if (rest >= 100) {
                rest -= 100;
                count++;
            } else if (rest >= 50) {
                rest -= 50;
                count++;
            } else if (rest >= 20) {
                rest -= 20;
                count++;
            } else if (rest >= 10) {
                rest -= 10;
                count++;
            } else if (rest >= 5) {
                rest -= 5;
                count++;
            } else if (rest >= 2) {
                rest -= 2;
                count++;
            } else if (rest >= 1) {
                rest -= 1;
                count++;
            }
        }
        System.out.println(count);
    }
}
