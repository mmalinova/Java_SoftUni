import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double damageToHeigan = Double.parseDouble(scan.nextLine());

        int playerPoint = 18500;
        double heiganPoint = 3000000;

        String currentSpell = "";

        int rows = 15;
        int cols = 15;
        int currentPlayerRow = 7;
        int currentPlayerCol = 7;

        while(true) {
            if (playerPoint >= 0) {
                heiganPoint -= damageToHeigan;
            }
            if (currentSpell.equals("Cloud")) {
                playerPoint -= 3500;
            }
            if (heiganPoint <= 0  || playerPoint <= 0) {
                break;
            }
            String[] input = scan.nextLine().split("\\s+");
            String spell = input[0];
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);

            if (spell.equals("Cloud") || spell.equals("Eruption")) {
                if (isDamage(row, col, currentPlayerRow, currentPlayerCol)) {
                    if (!isDamage(row, col, currentPlayerRow - 1, currentPlayerCol) &&
                            !isWall(currentPlayerRow - 1, rows)) {
                        currentPlayerRow--;
                        currentSpell = "";
                    } else if (!isDamage(row, col, currentPlayerRow, currentPlayerCol + 1) &&
                            !isWall(currentPlayerCol + 1, cols)) {
                        currentPlayerCol++;
                        currentSpell = "";
                    } else if (!isDamage(row, col, currentPlayerRow + 1, currentPlayerCol) &&
                            !isWall(currentPlayerRow + 1, rows)) {
                        currentPlayerRow++;
                        currentSpell = "";
                    } else if (!isDamage(row, col, currentPlayerRow, currentPlayerCol - 1) &&
                            !isWall(currentPlayerCol - 1, cols)) {
                        currentPlayerCol--;
                        currentSpell = "";
                    } else {
                        if (spell.equals("Cloud")) {
                            playerPoint -= 3500;
                            currentSpell = "Cloud";
                        } else {
                            playerPoint -= 6000;
                            currentSpell = "Eruption";
                        }
                    }
                }
            }
        }

        if (heiganPoint <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganPoint);
        }
        if (playerPoint <= 0) {
            System.out.printf("Player: Killed by %s%n", currentSpell.equals("Cloud") ? "Plague Cloud" : "Eruption");
        } else {
            System.out.printf("Player: %d%n", playerPoint);
        }
        System.out.printf("Final position: %d, %d%n", currentPlayerRow, currentPlayerCol);
    }

    private static boolean isDamage(int row, int col, int currentPlayerRow, int currentPlayerCol) {
        return ((row - 1 <= currentPlayerRow && currentPlayerRow <= row + 1)
                && (col - 1 <= currentPlayerCol && currentPlayerCol <= col + 1));
    }

    private static boolean isWall(int moveCell, int endOfMatrix) {
        return moveCell < 0 || moveCell >= endOfMatrix;
    }
}
