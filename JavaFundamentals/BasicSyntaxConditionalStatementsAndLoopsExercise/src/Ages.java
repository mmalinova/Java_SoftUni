import java.util.Scanner;

public class Ages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int age = Integer.parseInt(scan.nextLine());
        String output = "";

        if (age <= 2)
            output = "baby";
        else if (age <= 13)
            output = "child";
        else if (age <= 19)
            output = "teenager";
        else if (age <= 65)
            output = "adult";
        else if (age >= 66)
            output = "elder";

        System.out.println(output);
    }
}
