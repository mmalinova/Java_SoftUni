import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");
        String title = input[0];
        String content = input[1];
        String author = input[2];

        Articles art = new Articles(title, content, author);

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] manipulation = scan.nextLine().split(": ");
            String command = manipulation[0];
            String newContent = manipulation[1];

            switch (command) {
                case "Edit":
                        art.edit(newContent);
                    break;
                    case "ChangeAuthor":
                        art.changeAuthor(newContent);
                    break;
                    case "Rename":
                        art.rename(newContent);
                    break;
            }
        }
        System.out.println(art.toString());
    }
}
