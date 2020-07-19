import java.util.Scanner;

public class GreaterNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());

        if(firstNum > secondNum)
        {
            System.out.println(firstNum);
        }
        else
            System.out.println(secondNum);
    }
}
