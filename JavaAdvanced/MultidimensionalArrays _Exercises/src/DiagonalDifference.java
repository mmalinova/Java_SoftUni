import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[][] matrix = fillMatrix(scan);

        int sumOfFirstDiagonal = 0;
        int sumOfSecondDiagonal = 0;

        for (int i = 0; i < matrix.length; i++) {
            sumOfFirstDiagonal += matrix[i][i];
            sumOfSecondDiagonal += matrix[i][matrix.length - 1 - i];
        }
        //int sumOfFirstDiagonal = findFirstDiagonal(matrix);
        //int sumOfSecondDiagonal = findSecondDiagonal(matrix);

        System.out.println(Math.abs(sumOfFirstDiagonal - sumOfSecondDiagonal));
    }

    private static int findSecondDiagonal(int[][] matrix) {
        int sum = 0;

        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix[row].length - 1; col >= 0; col--) {
                if (row + col == matrix[row].length - 1) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static int findFirstDiagonal(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static int[][] fillMatrix(Scanner scan) {
        int n = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = scan.nextInt();
            }
        }
        return matrix;
    }
}
