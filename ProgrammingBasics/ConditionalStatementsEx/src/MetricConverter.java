import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double num = Double.parseDouble(scan.nextLine());
        String metricIn = scan.nextLine();
        String metricOut = scan.nextLine();
        double res;

        if (metricIn.equals("mm")){
            if (metricOut.equals("m")) {
                res = num / 1000;
                System.out.printf("%.3f", res);
            }
            else if (metricOut.equals("cm")) {
                res = num / 10;
                System.out.printf("%.3f", res);
            }
        } else if (metricIn.equals("cm")){
            if (metricOut.equals("m")) {
                res = num / 100;
                System.out.printf("%.3f", res);
            }
            else if (metricOut.equals("mm")) {
                res = num * 10;
                System.out.printf("%.3f", res);
            }
        } else if (metricIn.equals("m")){
            if (metricOut.equals("mm")) {
                res = num * 1000;
                System.out.printf("%.3f", res);
            }
            else if (metricOut.equals("cm")) {
                res = num * 100;
                System.out.printf("%.3f", res);
            }
        }
    }
}
