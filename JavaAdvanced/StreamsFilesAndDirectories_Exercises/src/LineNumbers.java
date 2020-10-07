import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class LineNumbers {
    public static int count = 1;

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\malin\\Desktop\\Elly\\Java\\JavaAdvanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        PrintWriter writer = new PrintWriter("output.txt");

        Files.readAllLines(Path.of(path))
                .forEach(line -> {
                    writer.println(String.format("%d. %s", count++, line));
                });

        writer.close();
    }
}
