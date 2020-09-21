import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] childrenNames = scan.nextLine().split("\\s+");

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < childrenNames.length; i++) {
            queue.offer(childrenNames[i]);
        }

        int cycle = 1;

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            }
            else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int n)
    {
        boolean prime = true;
        if (n == 0 || n == 1) {
            prime = false;
        }
        else {
            for (int i = 2; i <= Math.sqrt(n); i++)
            {
                if (n % i == 0) {
                    prime = false;
                }
            }
        }
        return prime;
    }
}
