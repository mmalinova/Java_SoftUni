import java.io.*;

public class SumBytes {
    public static void main(String[] args) {

        String path = "C:\\Users\\malin\\Desktop\\Elly\\Java\\JavaAdvanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        File file = new File(path);

        long sum = 0;

//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String line = reader.readLine();
//            while (line != null) {
//                for (char c: line.toCharArray()) {
//                    sum += c;
//                }
//                line = reader.readLine();
//            }
//            System.out.println(sum);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            byte oneByte = (byte) reader.read();
            while (oneByte != -1) {
                if (oneByte != 10 && oneByte != 13) {
                    sum += oneByte;
                }
                oneByte = (byte) reader.read();
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
