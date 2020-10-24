import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        int countOfCommands = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        int playerRow = 0;
        int playerCol = 0;

        for (int row = 0; row < size; row++) {
            String line = scan.nextLine();
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'f') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        for (int i = 0; i < countOfCommands; i++) {
            String command = scan.nextLine();
            switch(command) {
                case "up":
                    matrix[playerRow][playerCol] = '-';
                    playerRow--;
                    if (OutOfBounds(playerRow, playerCol, matrix)) {
                        playerRow = size - 1;
                        if (isFinish(playerRow, playerCol, matrix)) {
                            printMatrix(size, matrix);
                            return;
                        } else {
                            matrix[playerRow][playerCol] = 'f';
                        }
                    } else if (isBonus(playerRow, playerCol, matrix)) {
                        playerRow--;
                        if (OutOfBounds(playerRow, playerCol, matrix)) {
                            playerRow = size - 1;
                        }
                        if (isFinish(playerRow, playerCol, matrix)) {
                            printMatrix(size, matrix);
                            return;
                        } else {
                            matrix[playerRow][playerCol] = 'f';
                        }
                    } else if (isTrap(playerRow, playerCol, matrix)) {
                        playerRow++;
                        matrix[playerRow][playerCol] = 'f';
                    } else if (isFinish(playerRow, playerCol, matrix)) {
                        printMatrix(size, matrix);
                        return;
                    } else {
                        matrix[playerRow][playerCol] = 'f';
                    }
                    break;
                case "down":
                    matrix[playerRow][playerCol] = '-';
                    playerRow++;
                    if (OutOfBounds(playerRow, playerCol, matrix)) {
                        playerRow = 0;
                        if (isFinish(playerRow, playerCol, matrix)) {
                            printMatrix(size, matrix);
                            return;
                        } else {
                            matrix[playerRow][playerCol] = 'f';
                        }
                    } else if (isBonus(playerRow, playerCol, matrix)) {
                        playerRow++;
                        if (OutOfBounds(playerRow, playerCol, matrix)) {
                            playerRow = 0;
                        }
                        if (isFinish(playerRow, playerCol, matrix)) {
                            printMatrix(size, matrix);
                            return;
                        } else {
                            matrix[playerRow][playerCol] = 'f';
                        }
                    } else if (isTrap(playerRow, playerCol, matrix)) {
                        playerRow--;
                        matrix[playerRow][playerCol] = 'f';
                    } else if (isFinish(playerRow, playerCol, matrix)) {
                        printMatrix(size, matrix);
                        return;
                    } else {
                        matrix[playerRow][playerCol] = 'f';
                    }
                    break;
                case "left":
                    matrix[playerRow][playerCol] = '-';
                    playerCol--;
                    if (OutOfBounds(playerRow, playerCol, matrix)) {
                        playerCol = size - 1;
                        if (isFinish(playerRow, playerCol, matrix)) {
                            printMatrix(size, matrix);
                            return;
                        } else {
                            matrix[playerRow][playerCol] = 'f';
                        }
                    } else if (isBonus(playerRow, playerCol, matrix)) {
                        playerCol--;
                        if (OutOfBounds(playerRow, playerCol, matrix)) {
                            playerCol = size - 1;
                        }
                        if (isFinish(playerRow, playerCol, matrix)) {
                            printMatrix(size, matrix);
                            return;
                        } else {
                            matrix[playerRow][playerCol] = 'f';
                        }
                    } else if (isTrap(playerRow, playerCol, matrix)) {
                        playerCol++;
                        matrix[playerRow][playerCol] = 'f';
                    } else if (isFinish(playerRow, playerCol, matrix)) {
                        printMatrix(size, matrix);
                        return;
                    } else {
                        matrix[playerRow][playerCol] = 'f';
                    }
                    break;
                case "right":
                    matrix[playerRow][playerCol] = '-';
                    playerCol++;
                    if (OutOfBounds(playerRow, playerCol, matrix)) {
                        playerCol = 0;
                        if (isFinish(playerRow, playerCol, matrix)) {
                            printMatrix(size, matrix);
                            return;
                        } else {
                            matrix[playerRow][playerCol] = 'f';
                        }
                    } else if (isBonus(playerRow, playerCol, matrix)) {
                        playerCol++;
                        if (OutOfBounds(playerRow, playerCol, matrix)) {
                            playerCol = 0;
                        }
                        if (isFinish(playerRow, playerCol, matrix)) {
                            printMatrix(size, matrix);
                            return;
                        } else {
                            matrix[playerRow][playerCol] = 'f';
                        }
                    } else if (isTrap(playerRow, playerCol, matrix)) {
                        playerCol--;
                        matrix[playerRow][playerCol] = 'f';
                    } else if (isFinish(playerRow, playerCol, matrix)) {
                        printMatrix(size, matrix);
                        return;
                    } else {
                        matrix[playerRow][playerCol] = 'f';
                    }
                    break;
            }
        }
        System.out.println("Player lost!");
        printMatrix(size, matrix);
    }

    private static void printMatrix(int size, char[][] matrix) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isFinish(int row, int col, char[][] matrix) {
        if (matrix[row][col] == 'F') {
            matrix[row][col] = 'f';
            System.out.println("Player won!");
            return true;
        }
        return false;
    }

    private static boolean isTrap(int row, int col, char[][] matrix) {
        return matrix[row][col] == 'T';
    }

    private static boolean isBonus(int row, int col, char[][] matrix) {
        return matrix[row][col] == 'B';
    }

    private static boolean OutOfBounds(int row, int col, char[][] matrix) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
