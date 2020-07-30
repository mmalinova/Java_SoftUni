import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        int bestSeq = 0, currentSeq = 1, seqIndex = 0;
        for (int i = 0; i < input.length - 1; i++) {
            String current = input[i];
            if (!current.equals(input[i + 1])) {
                currentSeq = 1;
            }
            else {
                currentSeq++;
                if (currentSeq > bestSeq) {
                    bestSeq = currentSeq;
                    seqIndex = i;
                }
            }
        }
        for (int i = 0; i < bestSeq; i++) {
            System.out.printf("%s ", input[seqIndex]);
        }
    }
}
