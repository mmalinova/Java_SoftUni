import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int startNameIndex = 0;
        int endNameIndex = 0;
        int startAgeIndex = 0;
        int endAgeIndex = 0;
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '@') {
                    startNameIndex = j + 1;
                }
                if (input.charAt(j) == '|') {
                    endNameIndex = j;
                }
                if (input.charAt(j) == '#') {
                    startAgeIndex = j + 1;
                }
                if (input.charAt(j) == '*') {
                    endAgeIndex = j;
                }
            }
            String name = input.substring(startNameIndex, endNameIndex);
            String age = input.substring(startAgeIndex, endAgeIndex);
            System.out.println(String.format("%s is %s years old.", name, age));
        }
    }
}
