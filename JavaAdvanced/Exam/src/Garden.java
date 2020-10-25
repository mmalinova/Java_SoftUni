import java.util.LinkedList;
import java.util.Scanner;

public class Garden {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] dimension = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = 0;
            }
        }

        LinkedList<Integer> flowers = new LinkedList<>();

        String command = scan.nextLine();
        while(!"Bloom Bloom Plow".equals(command)) {
            String[] positions = command.split("\\s+");
            int flowerRow = Integer.parseInt(positions[0]);
            int flowerCol = Integer.parseInt(positions[1]);
            if (isOutOfBounds(flowerRow, flowerCol, matrix)) {
                System.out.println("Invalid coordinates.");
            } else {
                flowers.add(flowerRow);
                flowers.add(flowerCol);
            }

            command = scan.nextLine();
        }

        matrix = fillMatrix(flowers, rows, cols, matrix);

        for (int i = 0; i < flowers.size() - 1; i++) {
            int row = flowers.get(i);
            int col = flowers.get(i + 1);
            i++;
            matrix = bloomFlowers(matrix, rows, cols, row, col);
        }

        printMatrix(matrix, rows);
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

    private static int[][] bloomFlowers(int[][] matrix, int rows, int cols, int row, int col) {
        for (int i = 0; i < cols; i++) {
            if (matrix[row][i] >= 1 && i != col) {
                matrix[row][i] += 1;
            } else {
                matrix[row][i] = 1;
            }
        }
        for (int i = 0; i < rows; i++) {
            if (matrix[i][col] >= 1 && i != row) {
                matrix[i][col] += 1;
            } else {
                matrix[i][col] = 1;
            }
        }
        return matrix;
    }

    private static int[][] fillMatrix(LinkedList<Integer> flowers, int rows, int cols, int[][] matrix) {
        int[][] garden = new int[rows][cols];
        for (int i = 0; i < flowers.size() - 1; i++) {
            int row = flowers.get(i);
            int col = flowers.get(i + 1);
            i++;
            garden[row][col] = 1;
        }
        return garden;
    }

    private static boolean isOutOfBounds(int row, int col, int[][] matrix) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
