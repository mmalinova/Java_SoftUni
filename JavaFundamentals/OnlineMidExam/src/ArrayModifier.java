import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        String commands = scan.nextLine();
        while (!"end".equals(commands)) {
            String[] tokens = commands.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    int temp = array[firstIndex];
                    array[firstIndex] = array[secondIndex];
                    array[secondIndex] = temp;
                    break;
                case "multiply":
                    firstIndex = Integer.parseInt(tokens[1]);
                    secondIndex = Integer.parseInt(tokens[2]);
                    int multiply = array[firstIndex] * array[secondIndex];
                    array[firstIndex] = multiply;
                    break;
                case "decrease":
                    for (int i = 0; i < array.length; i++) {
                        array[i] = array[i] - 1;
                    }
                    break;
            }
            commands = scan.nextLine();
        }
        String[] output = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            output[i] = String.valueOf(array[i]);
        }
        System.out.print(String.join(", ", output));
    }
}
