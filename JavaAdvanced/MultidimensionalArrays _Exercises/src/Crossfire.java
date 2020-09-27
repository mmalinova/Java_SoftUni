import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] dimension = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        List<List<Integer>> matrix = new ArrayList<>();

        int count = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(count++);
            }
        }

        String command = scan.nextLine();
        while(!"Nuke it from orbit".equals(command)) {
            String[] tokens = command.split("\\s+");
            int givenRow = Integer.parseInt(tokens[0]);
            int givenCol = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            for (int row = givenRow - radius; row <= givenRow + radius; row++) {
                if (isInMatrixRange(matrix, row, givenCol) && row != givenRow) {
                    matrix.get(row).remove(givenCol);
                }
            }

            for (int col = givenCol + radius; col >= givenCol - radius; col--) {
                if (isInMatrixRange(matrix, givenRow, col)) {
                    matrix.get(givenRow).remove(col);
                }
            }

            matrix.removeIf(List::isEmpty);

            command = scan.nextLine();
        }

        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                if (col == matrix.get(row).size() - 1) {
                    System.out.print(matrix.get(row).get(col));
                } else {
                    System.out.print(matrix.get(row).get(col) + " ");
                }
            }
            System.out.println();
        }
    }

    private static boolean isInMatrixRange(List<List<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }
}
