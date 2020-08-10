package MoreExercises;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String regex = "@(?<name>[A-Za-z]+)[^@\\-!:>]*!(?<behaviour>[G|N])!";

        String message = scan.nextLine();

        List<String> names = new LinkedList<>();

        while (!"end".equals(message)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                sb.append((char)(message.charAt(i) - n));
            }
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(sb.toString());
            if (matcher.find()) {
                if (matcher.group("behaviour").equals("G")) {
                    names.add(matcher.group("name"));
                }
            }
            message = scan.nextLine();
        }

        names
                .forEach(element -> System.out.println(element));
    }
}
