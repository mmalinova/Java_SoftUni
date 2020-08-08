import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String[] ticket = input.split("[, ]+");

        for (int i = 0; i < ticket.length; i++) {

            if (ticket[i].length() == 20) {
                String tickets = ticket[i];
                String left = tickets.substring(0,10);
                String right = tickets.substring(10,20);
                String leftMach ="a";
                String righttMach="s";

                Pattern patern = Pattern.compile("[\\\\@]{6,}|[\\\\$]{6,}|[\\\\#]{6,}|[\\\\^]{6,}");
                Matcher lm = patern.matcher(left);
                Matcher rm = patern.matcher(right);
                if (lm.find()){
                    leftMach = lm.group();
                }
                if (rm.find()){
                    righttMach = rm.group();
                }

                if (leftMach.substring(0,1).equals(righttMach.substring(0,1))){
                    int matchCount = Math.min(leftMach.length(),righttMach.length());

                    if (matchCount == 10){
                        System.out.printf("ticket \"%s\" - %d%s Jackpot!%n",tickets,matchCount,leftMach.substring(0,1));
                    }else {
                        System.out.printf("ticket \"%s\" - %d%s%n",tickets,matchCount,leftMach.substring(0,1));

                    }
                }else {
                    System.out.printf("ticket \"%s\" - no match%n",tickets);
                }

            }else {
                System.out.println("invalid ticket");
            }
        }
    }
}
