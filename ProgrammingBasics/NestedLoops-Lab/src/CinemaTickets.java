import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String filmName = scan.nextLine();

        int ticketsForOneMovie = 0;
        int allTickets = 0;
        int studentTickets = 0;
        int standardTickets = 0;
        int kidTickets = 0;

        while (!filmName.equals("Finish")) {
            int free = Integer.parseInt(scan.nextLine());
            int leaveSpace = free;
            while (free > 0) {
                String type = scan.nextLine();
                if (type.equals("End")) {
                    break;
                } else if (type.equals("student")) {
                    studentTickets++;
                } else if (type.equals("standard")) {
                    standardTickets++;
                } else if (type.equals("kid")) {
                    kidTickets++;
                }
                free--;
                allTickets++;
                ticketsForOneMovie++;
            }
            System.out.printf("%s - %.2f%% full.%n", filmName, (ticketsForOneMovie * 1.0 / leaveSpace) * 100);
            filmName = scan.nextLine();
            ticketsForOneMovie = 0;
        }
        System.out.printf("Total tickets: %d%n", allTickets);
        System.out.printf("%.2f%% student tickets.%n", (studentTickets * 1.0 / allTickets) * 100);
        System.out.printf("%.2f%% standard tickets.%n", (standardTickets * 1.0 / allTickets) * 100);
        System.out.printf("%.2f%% kids tickets.%n", (kidTickets * 1.0 / allTickets) * 100);
    }
}
