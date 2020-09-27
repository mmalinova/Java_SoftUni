import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] dimension = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        boolean[][] matrix = new boolean[rows][cols];
        int[] busyCells = new int[rows];

        String command = scan.nextLine();
        while(!"stop".equals(command)) {
            int distance = 1;
            String[] tokens = command.split("\\s+");
            int entryRow = Integer.parseInt(tokens[0]);
            int desiredRow = Integer.parseInt(tokens[1]);
            int desiredCol = Integer.parseInt(tokens[2]);

            if (isFree(matrix, desiredRow, desiredCol)) {
                matrix[desiredRow][desiredCol] = true;
                busyCells[desiredRow]++;
                distance = Math.abs((desiredRow - entryRow)) + desiredCol + 1;
            } else {
                distance = findClosestSpot(matrix, busyCells, entryRow, desiredRow, desiredCol, cols);
            }
            if (distance > 1) {
                System.out.println(distance);
            }
            command = scan.nextLine();
        }
    }

    private static int findClosestSpot(boolean[][] matrix, int[] busyCells, int entryRow, int desiredRow, int desiredCol,
                                       int cols) {
        int count = 1;
        while (busyCells[desiredRow] < cols - 1) {
            desiredCol -= count;
            if (isInRange(desiredCol, cols)) {
                if (isFree(matrix, desiredRow, desiredCol)) {
                    matrix[desiredRow][desiredCol] = true;
                    busyCells[desiredRow]++;
                    return Math.abs((desiredRow - entryRow)) + desiredCol + 1;
                } else {
                    desiredCol += count;
                }
            } else {
                desiredCol += count;
            }
            desiredCol += count;
            if (isInRange(desiredCol, cols)) {
                if (isFree(matrix, desiredRow, desiredCol)) {
                    matrix[desiredRow][desiredCol] = true;
                    busyCells[desiredRow]++;
                    return Math.abs((desiredRow - entryRow)) + desiredCol + 1;
                } else {
                    desiredCol -= count;
                    count++;
                }
            } else {
                desiredCol -= count;
                count++;
            }
        }

        System.out.println("Row " + desiredRow + " full");
        return 1;
    }

    private static boolean isInRange(int desiredCol, int cols) {
        return desiredCol >= 1 && desiredCol < cols;
    }

    private static boolean isFree(boolean[][] matrix, int desiredRow, int desiredCol) {
        return !matrix[desiredRow][desiredCol];
    }
}
