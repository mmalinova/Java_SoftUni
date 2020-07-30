import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int[] trainArray = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int numberOfPeople = Integer.parseInt(scan.nextLine());
            trainArray[i] = numberOfPeople;
            sum += numberOfPeople;
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", trainArray[i]);
        }
        System.out.printf("%n%d", sum);
    }
}
