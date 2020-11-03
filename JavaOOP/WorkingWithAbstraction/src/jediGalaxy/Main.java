package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimension[0];
        int cols = dimension[1];

        int[][] matrix = fillMatrix(rows, cols);

        String command = scanner.nextLine();
        long sumOfValues = 0;

        while (!command.equals("Let the Force be with you")) {
            int[] playerCoordinates = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            int playerRow = playerCoordinates[0];
            int playerCol = playerCoordinates[1];
            Player player = new Player(playerRow, playerCol);

            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];
            Evil evil = new Evil(evilRow, evilCol);

            while (evil.getX() >= 0 && evil.getY() >= 0) {
                if (isInBounds(matrix, evil.getX(), evil.getY())) {
                    matrix[evil.getX()][evil.getY()] = 0;
                }
                evil.setX(evil.getX() - 1);
                evil.setY(evil.getY() - 1);
            }

            while (player.getX() >= 0 && player.getY() < matrix[1].length) {
                if (isInBounds(matrix, player.getX(), player.getY())) {
                    sumOfValues += matrix[player.getX()][player.getY()];
                }
                player.setX(player.getX() - 1);
                player.setY(player.getY() + 1);
            }
            command = scanner.nextLine();
        }
        System.out.println(sumOfValues);
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col  < matrix[0].length;
    }

    private static int[][] fillMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = count++;
            }
        }
        return matrix;
    }
}
