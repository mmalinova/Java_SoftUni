import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class WordCount {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\malin\\Desktop\\Elly\\Java\\JavaAdvanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";

        HashMap<String, Integer> wordsFrequency = new HashMap<>();

        Files.readAllLines(Path.of(path))
                .forEach(line -> {
                    String[] words = line.split("\\s+");
                    for (String word : words) {
                        wordsFrequency.putIfAbsent(word, 0);
                    }
                });

        String secondPath = "C:\\Users\\malin\\Desktop\\Elly\\Java\\JavaAdvanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

        Files.readAllLines(Path.of(secondPath))
                .forEach(line -> {
                    String[] words = line.split("\\s+");
                    for (String word : words) {
                        if (wordsFrequency.containsKey(word)) {
                            wordsFrequency.put(word, wordsFrequency.get(word) + 1);
                        }
                    }
                });


        PrintWriter writer = new PrintWriter("output.txt");

        wordsFrequency.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(element -> {
                    writer.println(element.getKey() + " - " + element.getValue());
                });

        writer.close();
    }
}
