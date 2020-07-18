import java.util.Scanner;

public class PersonalTitles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double age = Double.parseDouble(scan.nextLine());
        char sex = scan.nextLine(). charAt(0);

        if(sex == 'm'){
            if (age >= 16)
                System.out.println("Mr.");
            else
                System.out.println("Master");
        }
        else if(sex == 'f'){
            if (age >= 16)
                System.out.println("Ms.");
            else
                System.out.println("Miss");
        }
    }
}
