import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //цел - 10 000 стъпки всеки ден
        //понякога не постига целта си
        //чете се по колко стъпки изминава всеки път, когато излиза през деня
        //СТОП - когато постигне целта си
        //когато иска да се прибере преди това - "Going home"
        //ще въведе стъпките, които е извървяла докато се прибира
        //ако не е постигнала целта си - "{разликата между стъпките} more steps to reach goal."

        int steps = 0;
        int allSteps = 0;

        while (allSteps < 10000) {
            String isGoing = scan.nextLine();
            if (isGoing.equals("Going home")) {
                steps = Integer.parseInt(scan.nextLine());
                allSteps += steps;
                if (allSteps < 10000)
                    System.out.printf("%d more steps to reach goal.", 10000 - allSteps);
                break;
            } else {
                steps = Integer.parseInt(isGoing);
            }
            allSteps += steps;
        }
        if (allSteps >= 10000)
        System.out.println("Goal reached! Good job!");
    }
}
