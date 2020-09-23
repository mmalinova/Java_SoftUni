import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> robots = new LinkedHashMap<>();

        String[] robotInput = robotInput(scan, robots);

        String[] startTime = scan.nextLine().split(":");
        int hours = Integer.parseInt(startTime[0]);
        int minutes = Integer.parseInt(startTime[1]);
        int seconds = Integer.parseInt(startTime[2]);

        long timeAtSeconds = (hours * 3600) + (minutes * 60) + seconds;

        ArrayDeque<String> products = new ArrayDeque<>();

        int [] workingTime = new int[robots.size()];

        String product = scan.nextLine();
        while (!product.equals("End")) {
            products.offer(product);
            product = scan.nextLine();
        }

        while(!products.isEmpty()){
            String currentProduct = products.poll();
            timeAtSeconds++;
            boolean isProcess = false;
            //намаляме работното време с 1 секунда
            for (int robot = 0; robot < workingTime.length; robot++) {
                if(workingTime[robot] > 0) {
                    --workingTime[robot];
                }
            }
            //обхождане на работното време
            for (int i = 0; i < workingTime.length; i++) {
                if(workingTime[i] == 0) {
                    //свободен -> кой е робота -> времето
                    int count = 0;
                    for (Map.Entry<String, Integer> robot : robots.entrySet()){
                        if (count == i) {
                            workingTime[i] = robot.getValue();
                            long takenHour =  timeAtSeconds / 3600 % 24;
                            long takenMinute = timeAtSeconds % 3600 / 60;
                            long takenSeconds = timeAtSeconds % 60;
                            System.out.printf("%s - %s [%02d:%02d:%02d]%n", robot.getKey(), currentProduct, takenHour, takenMinute, takenSeconds);
                            isProcess =  true;
                            break;
                        }
                        count++;
                    }
                    break;
                }
            }

            if(!isProcess) {
                products.offer(currentProduct);
            }
        }
    }

    private static String[] robotInput(Scanner scan, Map<String, Integer> robots) {
        String[] robotInput = scan.nextLine().split(";");
        for (int i = 0; i < robotInput.length; i++) {
            String[] nameAndTime = robotInput[i].split("-");
            String robotName = nameAndTime[0];
            int robotTime = Integer.parseInt(nameAndTime[1]);
            robots.putIfAbsent(robotName, robotTime);
        }
        return robotInput;
    }
}
