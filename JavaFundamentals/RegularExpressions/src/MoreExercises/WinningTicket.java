package MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(",\\s+");

        String regex = "([@]{6,9}|[#]{6,9}|[$]{6,9}|[\\^]{6,9})";
        String jackpotRegex = "([@]{20}|[#]{20}|[$]{20}|[\\^]{20})";

        Pattern patternRegex = Pattern.compile(regex);
        Pattern patternJackpot = Pattern.compile(jackpotRegex);

        for (String s : input) {
            s = s.trim();
            if (s.length() == 20) {
                String firstHalf = s.substring(0, 10);
                String secondHalf = s.substring(10);
                Matcher matcherRegex = patternRegex.matcher(firstHalf);
                Matcher matcherRegexx = patternRegex.matcher(secondHalf);
                Matcher matcherJackpot = patternJackpot.matcher(s);
                if (matcherJackpot.find()) {
                    System.out.println(String.format("ticket \"%s\" - %d%s Jackpot!",
                            s, matcherJackpot.group().length() / 2, matcherJackpot.group().charAt(0)));
                } else if (matcherRegex.find() && matcherRegexx.find()) {
                    System.out.println(String.format("ticket \"%s\" - %d%s",
                            s, Math.min(matcherRegex.group().length(), matcherRegexx.group().length()),
                            matcherRegex.group().charAt(0)));
                } else {
                    System.out.println(String.format("ticket \"%s\" - no match", s));
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }
}
