import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pokePower = Integer.parseInt(scan.nextLine());
        int distance = Integer.parseInt(scan.nextLine());
        int exhaustionFactor = Integer.parseInt(scan.nextLine());

        int currentPokePower = pokePower;
        int targetsCount = 0;

        while (currentPokePower >= distance)
        {
            currentPokePower -= distance;
            targetsCount++;

            if (currentPokePower == pokePower * 0.5 && exhaustionFactor != 0)
            {
                currentPokePower /= exhaustionFactor;
            }
        }

        System.out.printf("%d%n", currentPokePower);
        System.out.printf("%d", targetsCount);
    }
}
