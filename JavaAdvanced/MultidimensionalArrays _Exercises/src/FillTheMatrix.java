import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] squareMatrix = new int [size][size];

        if (pattern.equals("A")) {
            squareMatrix = fillByPatternA(squareMatrix, size);
        } else if (pattern.equals("B")) {
            squareMatrix = fillByPatternB(squareMatrix, size);
        }
        printMatrix(squareMatrix, size);
    }

    private static void printMatrix(int[][] squareMatrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (col == size - 1) {
                    System.out.print(squareMatrix[row][col]);
                } else {
                    System.out.print(squareMatrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    private static int[][] fillByPatternB(int[][] squareMatrix, int size) {
        int count = 1;

        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    squareMatrix[row][col] = count++;
                }
            } else {
                for (int row = size - 1; row >= 0 ; row--) {
                    squareMatrix[row][col] = count++;
                }
            }
        }
        return squareMatrix;
    }

    private static int[][] fillByPatternA(int[][] squareMatrix, int size) {
        int count = 1;

        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                squareMatrix[row][col] = count++;
            }
        }
        return squareMatrix;
    }
}
