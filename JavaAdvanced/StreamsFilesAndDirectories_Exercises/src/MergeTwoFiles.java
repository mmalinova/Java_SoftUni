import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String firstFile = "C:\\Users\\malin\\Desktop\\Elly\\Java\\JavaAdvanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String secondFile = "C:\\Users\\malin\\Desktop\\Elly\\Java\\JavaAdvanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

        PrintWriter writer = new PrintWriter("output.txt");

        List<String> firstStrings = Files.readAllLines(Path.of(firstFile));
        for (String firstString : firstStrings) {
            writer.println(firstString);
        }

        List<String> secondStrings = Files.readAllLines(Path.of(secondFile));
        for (String secondString : secondStrings) {
            writer.println(secondString);
        }

        writer.close();
    }
}
