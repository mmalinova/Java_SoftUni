import java.util.Scanner;

public class ProjectCreations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int number = Integer.parseInt(scan.nextLine());
        int hours = number * 3;
        System.out.printf("The architect %s will need %d hours to complete %d project/s.", name, hours, number);
    }
}
