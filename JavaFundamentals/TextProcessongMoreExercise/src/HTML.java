import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String title = scan.nextLine();
        String content = scan.nextLine();

        String comment = scan.nextLine();
        List<String> commentsList = new ArrayList<>();
        while(!"end of comments".equals(comment)) {
            commentsList.add(comment);
            comment = scan.nextLine();
        }

        StringBuilder sb = new StringBuilder();

        String firstOutput = String.format("<h1>%n    %s%n</h1>%n<article>%n    %s%n</article>%n", title, content);
        sb.append(firstOutput);
        for (int i = 0; i < commentsList.size(); i++) {
            String secondOutput = String.format("<div>%n    %s%n</div>%n", commentsList.get(i));
            sb.append(secondOutput);
        }
        System.out.println(sb);
    }
}
