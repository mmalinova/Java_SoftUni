import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SumLines {
    public static void main(String[] args) {

        String path = "C:\\Users\\malin\\Desktop\\Elly\\Java\\JavaAdvanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        File file = new File(path);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            List<String> lines = reader.lines().collect(Collectors.toList());
            for (String line : lines) {
                int sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                System.out.println(sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String line = reader.readLine();
//            while (line != null) {
//                long sum = 0;
//                for (char c: line.toCharArray()) {
//                    sum += c;
//                }
//                System.out.println(sum);
//                line = reader.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
