import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] matrix = fillMatrix(scan);

        int sumSubMatrix2x2 = findSumSubMatrix2x2(matrix);
        System.out.println(sumSubMatrix2x2);
    }

    private static int findSumSubMatrix2x2 (int[][] matrix) {
        int[][] subMatrix = new int[matrix.length][];

        int maxSum = Integer.MIN_VALUE;
        int rowStartIndex = 0;
        int colStartIndex = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row + 1][col]
                        + matrix[row][col + 1] + matrix[row + 1][col + 1];
                if (maxSum < sum) {
                    maxSum = sum;
                    rowStartIndex = row;
                    colStartIndex = col;
                }
            }
        }
        for (int row = rowStartIndex; row <= rowStartIndex + 1; row++) {
            for (int col = colStartIndex; col <= colStartIndex + 1; col++) {
                if (col == colStartIndex + 1) {
                    System.out.print(matrix[row][col]);
                } else {
                    System.out.print(matrix[row][col] + " ");
                }
            }
            System.out.println();
        }

        return maxSum;
    }

    private static int[][] fillMatrix(Scanner scan) {
        String[] dimension = scan.nextLine().split(", ");
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scan.nextLine().split(", ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
        return matrix;
    }
}
