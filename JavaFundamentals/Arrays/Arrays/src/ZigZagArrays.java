import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        String[] firstArray = new String [n];
        String[] secondArray = new String [n];

        for (int i = 0; i < n; i++) {
            String[] first = scan.nextLine().split("\\s+");
            if (i % 2 == 0) {
                firstArray[i] = first[0];
                secondArray[i] = first[1];
            }
            else {
                firstArray[i] = first[1];
                secondArray[i] = first[0];
            }
        }
        for (int i = 0; i < firstArray.length; i++) {
            System.out.printf("%s ", firstArray[i]);
        }
            System.out.println();
        for (int i = 0; i < secondArray.length; i++) {
            System.out.printf("%s ", secondArray[i]);
        }
    }
}
