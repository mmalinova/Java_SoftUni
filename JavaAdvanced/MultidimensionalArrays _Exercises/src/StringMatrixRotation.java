import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] rotate = scan.nextLine().split("[\\(\\)]");
        int degrees = Integer.parseInt(rotate[1]) % 360;

        StringBuilder sb = new StringBuilder();

        String command = scan.nextLine();
        int length = 0;
        int rows = 0;

        while (!"END".equals(command)) {
            rows++;
            if (command.length() > length) {
                length = command.length();
            }
            sb.append(command);
            sb.append("*");
            command = scan.nextLine();
        }

        int cols = length;
        char[][] matrix = fillMatrix(sb, rows, cols);

        switch (degrees) {
            case 90:
                printRotateMatrixAt90(matrix, rows, cols);
                break;
            case 180:
                printRotateMatrixAt180(matrix, rows, cols);
                break;
            case 270:
                printRotateMatrixAt270(matrix, rows, cols);
                break;
            default:
                printMatrix(matrix);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printRotateMatrixAt270(char[][] matrix, int rows, int cols) {
        for (int col = cols - 1; col >= 0; col--) {
            for (int row = 0; row < rows; row++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printRotateMatrixAt180(char[][] matrix, int rows, int cols) {
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printRotateMatrixAt90(char[][] matrix, int rows, int cols) {
        for (int col = 0; col < cols; col++) {
            for (int row = rows - 1; row >= 0; row--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static char[][] fillMatrix(StringBuilder substring, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        int count = 0;
        for (int row = 0; row < matrix.length; row++, count++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (substring.charAt(count) != '*') {
                    matrix[row][col] = substring.charAt(count++);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        return matrix;
    }
}
