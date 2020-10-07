import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ALLCAPITALS {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\malin\\Desktop\\Elly\\Java\\JavaAdvanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        PrintWriter writer = new PrintWriter("output.txt");

//        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
//            int symbol = reader.read();
//            while (symbol != -1) {
//                String str = String.valueOf((char) symbol).toUpperCase();
//                writer.print(str);
//                symbol = reader.read();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Files.readAllLines(Path.of(path))
                .forEach(str -> {
                    writer.println(str.toUpperCase());
                });

        writer.close();
    }
}
