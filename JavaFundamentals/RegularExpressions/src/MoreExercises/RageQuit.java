package MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String regex = "(?<char>[^\\d]+)(?<digit>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();

//        String regexOneChar = "(?<char>[^\\d])";
//        Pattern patternOneChar = Pattern.compile(regexOneChar);
//
//        Matcher matcherOneChar = patternOneChar.matcher(input);
//        List<String> unique = new ArrayList<>();
//        while (matcherOneChar.find()) {
//            String match = matcherOneChar.group().toUpperCase();
//            if (!unique.contains(match)) {
//                unique.add(match);
//            }
//        }

        while (matcher.find()) {
            String chars = matcher.group("char");
            int digit = Integer.parseInt(matcher.group("digit"));

            if (digit != 0) {
                for (int i = 0; i < digit; i++) {
                    sb.append(chars.toUpperCase());
                }
            }
        }
        System.out.println(String.format("Unique symbols used: %d", /*unique.size()));*/sb.chars().distinct().count()));
        System.out.println(sb);
    }
}
