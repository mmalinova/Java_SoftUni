import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[n][];

        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scan.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[] positions = Arrays.stream(scan.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int wrongValueRow = positions[0];
        int wrongValueCol = positions[1];

        int wrongValue = matrix[wrongValueRow][wrongValueCol];

        List<String> wrongPositionsLog = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (isWrongValue(matrix[row][col], wrongValue)) {
                    wrongPositionsLog.add(row + " " + col);
                }
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (hasHistory(wrongPositionsLog, row, col)) {
                    int newValue = 0;
                    if (isInWithinTheMatrix(n, (row - 1))
                            && !hasHistory(wrongPositionsLog, row - 1, col)) {
                        newValue = newValue + matrix[row - 1][col];
                    }
                    if (isInWithinTheMatrix(n, (row + 1))
                            && !hasHistory(wrongPositionsLog, row + 1, col)) {
                        newValue = newValue + matrix[row + 1][col];
                    }
                    if (isInWithinTheMatrix(matrix[row].length, (col - 1))
                            && !hasHistory(wrongPositionsLog, row, (col - 1))) {
                        newValue = newValue + matrix[row][col - 1];
                    }
                    if (isInWithinTheMatrix(matrix[row].length, (col + 1))
                            && !hasHistory(wrongPositionsLog, row, col + 1)) {
                        newValue = newValue + matrix[row][col + 1];
                    }
                    matrix[row][col] = newValue;
                }
            }
        }
        printMatrix(matrix);
    }

    private static boolean hasHistory(List<String> history, int row, int col) {
        return history.contains((row) + " " + (col));
    }

    private static boolean isWrongValue(int currentValue, int wrongValue) {
        return currentValue == wrongValue;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.println();
        }
    }

    private static boolean isInWithinTheMatrix(int n, int wrongValue) {
        return wrongValue >= 0 && wrongValue < n;
    }
}
