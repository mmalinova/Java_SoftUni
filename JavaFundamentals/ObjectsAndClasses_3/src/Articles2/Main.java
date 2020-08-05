package Articles2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Articles> articlesList = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(", ");
            String title = input[0];
            String content = input[1];
            String author = input[2];
            Articles articles = new Articles(title, content, author);
            articlesList.add(articles);
        }
        String criteria = scan.nextLine();
        //title, content, author.
        switch (criteria) {
            case "title":
                articlesList.sort(Comparator.comparing(Articles::getTitle));
                System.out.println(articlesList.toString().replaceAll("[\\[\\],]", ""));
                break;
            case "content":
                articlesList.stream().sorted((a1, a2) -> (a1.getContent().compareTo(a2.getContent())))
                        .forEach(articles -> System.out.println(articles.toString()));;
                break;
            case "author":
                articlesList.stream().sorted((a1, a2) -> (a1.getAuthor().compareTo(a2.getAuthor())))
                        .forEach(articles -> System.out.println(articles.toString()));;
                break;
        }
        //articlesList.forEach(articles -> System.out.println(articles.toString()));
    }
}
