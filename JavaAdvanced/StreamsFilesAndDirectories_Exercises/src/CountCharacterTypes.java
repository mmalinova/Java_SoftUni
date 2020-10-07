import java.io.*;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) {

        String path = "C:\\Users\\malin\\Desktop\\Elly\\Java\\JavaAdvanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        String vowels = "aeiou";
        String punctuationMarks = "!.,?";

        int vowelsCount = 0;
        int marksCount = 0;
        int consonantsCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            int oneByte = reader.read();
            while (oneByte != -1) {
                String symbol = String.valueOf((char) oneByte);
                if (vowels.contains(symbol)) {
                    vowelsCount++;
                } else if (punctuationMarks.contains(symbol)) {
                    marksCount++;
                } else if (oneByte != 10 && oneByte != 13 && oneByte != 32){
                    consonantsCount++;
                }
                oneByte = reader.read();
            }
            PrintWriter writer = new PrintWriter("output.txt");
            writer.println("Vowels: " + vowelsCount);
            writer.println("Consonants: " + consonantsCount);
            writer.println("Punctuation: " + marksCount);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
