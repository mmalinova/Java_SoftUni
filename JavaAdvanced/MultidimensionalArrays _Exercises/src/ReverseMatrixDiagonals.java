import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> diagonals = new LinkedList<>();

        int[] dimension = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimension[0];
        int cols = dimension[1];

        int[][] matrix = fillMatrix(scan, rows, cols);

        int row = rows - 1;
        for (int col = cols - 1; col >= 0; col--) {
            findDiagonals(diagonals, cols, matrix, row, col);
        }

        int col = 0;
        for (row--; row >= 0; row--) {
            findDiagonals(diagonals, cols, matrix, row, col);
        }
        diagonals.forEach(element -> System.out.println(element));
    }

    private static void findDiagonals(List<String> diagonals, int cols, int[][] matrix, int row, int col) {
        StringBuilder diagonal = new StringBuilder();
        int r = row;
        int c = col;
        int count = 0;
        while (r >= 0 && c < cols) {
            count++;
            if (count > 1) {
                diagonal.append(" ");
            }
            diagonal.append(matrix[r--][c++]);
        }
        diagonals.add(diagonal.toString());
    }

    private static int[][] fillMatrix(Scanner scan, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
        return matrix;
    }
}
