import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        int[][] matrix = fillMatrix(scan, size);

        StringBuilder first = findFirstDiagonals(matrix, size);
        StringBuilder second = findSecondDiagonals(matrix, size);

        System.out.println(first.substring(0, first.length() - 1));
        System.out.println(second.substring(0, second.length() - 1));
    }

    private static void printMainDiagonal (int [][] matrix, int size) {
        for (int index = 0; index < size; index++) {
            if (index == size - 1) {
                System.out.print(matrix[index][index]);
            } else {
                System.out.print(matrix[index][index] + " ");
            }
        }
        System.out.println();
    }

    private static StringBuilder findFirstDiagonals(int[][] matrix, int size) {
        StringBuilder firstDiagonal = new StringBuilder();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col) {
                    firstDiagonal.append(matrix[row][col]);
                    firstDiagonal.append(" ");
                }
            }
        }
        return firstDiagonal;
    }

    private static StringBuilder findSecondDiagonals(int[][] matrix, int size) {
        StringBuilder secondDiagonal = new StringBuilder();

        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix[row].length - 1; col >= 0; col--) {
                if (row + col == size - 1) {
                    secondDiagonal.append(matrix[row][col]);
                    secondDiagonal.append(" ");
                }
            }
        }
        return secondDiagonal;
    }

    private static int[][] fillMatrix(Scanner scan, int size) {
        int[][] matrix = new int[size][];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
