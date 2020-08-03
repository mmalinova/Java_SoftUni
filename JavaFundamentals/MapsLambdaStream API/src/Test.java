import java.util.Date;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Date());

        StringBuilder text = new
                StringBuilder();

        for (int i = 0; i < 1000000; i++)

            text.append("a");

        System.out.println(new Date());



        System.out.println(new Date());

        String tex = "";

        for (int i = 0; i < 1000000; i++)

            tex += "a";

        System.out.println(new Date());
    }
}
