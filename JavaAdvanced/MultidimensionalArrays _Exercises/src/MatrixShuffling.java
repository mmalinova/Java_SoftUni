import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = fillMatrix(scan, rows, cols);

        String command = scan.nextLine();
        while(!"END".equals(command)) {
            String[] tokens = command.split("\\s+");
            String keyword = tokens[0];

            if (tokens.length == 5 && keyword.equals("swap")) {
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);
                if (row1 >= 0 && row1 < rows && row2 >= 0 && row2 < rows
                        && col1 >= 0 && col1 < cols && col2 >= 0 && col2 < cols) {
                    swapElements(matrix, row1, col1, row2, col2);
                    printMatrix(matrix, rows, cols);
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            command = scan.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col == cols - 1) {
                    System.out.print(matrix[row][col]);
                } else {
                    System.out.print(matrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void swapElements(String[][] matrix, int row1, int col1, int row2, int col2) {
        String temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }

    private static String[][] fillMatrix(Scanner scan, int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = line[col];
            }
        }
        return matrix;
    }
}
