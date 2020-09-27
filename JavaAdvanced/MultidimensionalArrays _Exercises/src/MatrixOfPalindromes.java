import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();

        String[][] palindromeMatrix = fillPalindromeMatrix(rows, cols);

        printMatrix(palindromeMatrix);
    }

    private static void printMatrix(String[][] palindromeMatrix) {
        for (int row = 0; row < palindromeMatrix.length; row++) {
            for (int col = 0; col < palindromeMatrix[row].length; col++) {
                if (col == palindromeMatrix[row].length - 1) {
                    System.out.print(palindromeMatrix[row][col]);
                } else {
                    System.out.print(palindromeMatrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    private static String[][] fillPalindromeMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        char firstLetter = 'a';

        for (int row = 0; row < rows; row++) {
            char secondLetter = firstLetter;
            for (int col = 0; col < cols; col++) {
                String str = "" + firstLetter + secondLetter++ + firstLetter;
                matrix[row][col] = str;
            }
            firstLetter++;
        }
        return matrix;
    }
}
