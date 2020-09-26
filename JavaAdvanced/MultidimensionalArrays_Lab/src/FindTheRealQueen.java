import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = 8;
        char[][] squareMatrix = fillSquareMatrix(scan, size);

        List<Integer> queensRow = new LinkedList<>();
        List<Integer> queensCol = new LinkedList<>();

        int number = 0;
        int queenR = 0;
        int queenC = 0;

        for (int row = 0; row < squareMatrix.length; row++) {
            for (int col = 0; col < squareMatrix[row].length; col++) {
                if (squareMatrix[row][col] == 'q') {
                    queenR = row;
                    queenC = col;
                    if (queensCol.contains(queenC)) {
                        queensRow.remove(queensCol.indexOf(queenC));
                        queensCol.remove(queensCol.indexOf(queenC));
                        break;
                    }
                    number++;
                    if (number > 1) {
                        break;
                    }
                }
            }
            if (number == 1) {
                queensRow.add(queenR);
                queensCol.add(queenC);
            }
            number = 0;
        }

        //up
        for (int i = queensRow.size() - 1; i >= 0; i--) {
            for (int row = queensRow.get(i) - 1, col = queensCol.get(i) + 1;
                 row >= 0 && col < size; row--, col++) {
                if (squareMatrix[row][col] == 'q') {
                    queensRow.remove(i);
                    queensCol.remove(i);
                    break;
                }
            }
        }
        //down
        for (int i = queensRow.size() - 1; i >= 0; i--) {
            for (int row = queensRow.get(i) + 1, col = queensCol.get(i) - 1;
                 row < size && col >= 0; row++, col--) {
                if (squareMatrix[row][col] == 'q') {
                    queensRow.remove(i);
                    queensCol.remove(i);
                    break;
                }
            }
        }

        if (!queensRow.isEmpty() && !queensCol.isEmpty()) {
            System.out.println(queensRow.get(0) + " " + queensCol.get(0));
        }
    }

    private static char[][] fillSquareMatrix(Scanner scan, int size) {
        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line[col].charAt(0);
            }
        }
        return matrix;
    }
}
