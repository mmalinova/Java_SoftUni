import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int prime = 0;
        int nonPrime = 0;

        while (true) {
            String input = scan.nextLine();
            if (input.equals("stop")) {
                break;
            }
            int num = Integer.parseInt(input);
            if (num < 0) {
                System.out.println("Number is negative.");
            } else {
                boolean isPrime = true;
                for (int i = 2; i < Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    prime += num;
                } else {
                    nonPrime += num;
                }
            }
        }
        System.out.printf("Sum of all prime numbers is: %d%n", prime);
        System.out.printf("Sum of all non prime numbers is: %d", nonPrime);
    }
}
