import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        String[][] firstMatrix = fillMatrix(scan, rows, cols);
        String[][] secondMatrix = fillMatrix(scan, rows, cols);

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col].equals(secondMatrix[row][col])) {
                    System.out.print(firstMatrix[row][col] + " ");
                } else {
                    System.out.print("*" + " ");
                }
            }
            System.out.println();
        }
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
