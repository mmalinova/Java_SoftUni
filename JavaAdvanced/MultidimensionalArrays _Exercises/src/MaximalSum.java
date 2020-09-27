import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] rectangularMatrix = fillMatrix(scan);

        findSumSubMatrix3x3(rectangularMatrix);
    }

    private static void findSumSubMatrix3x3(int[][] matrix) {
        int[][] subMatrix = new int[matrix.length][];

        int maxSum = Integer.MIN_VALUE;
        int rowStartIndex = 0;
        int colStartIndex = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = matrix[row][col] + matrix[row + 1][col] + matrix[row + 2][col]
                        + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (maxSum < sum) {
                    maxSum = sum;
                    rowStartIndex = row;
                    colStartIndex = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);

        for (int row = rowStartIndex; row <= rowStartIndex + 2; row++) {
            for (int col = colStartIndex; col <= colStartIndex + 2; col++) {
                if (col == colStartIndex + 2) {
                    System.out.print(matrix[row][col]);
                } else {
                    System.out.print(matrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrix(Scanner scan) {
        int rows = scan.nextInt();
        int cols = scan.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scan.nextInt();
            }
        }
        return matrix;
    }
}
