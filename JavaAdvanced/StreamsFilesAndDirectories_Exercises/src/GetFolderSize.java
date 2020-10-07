import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\malin\\Desktop\\Elly\\Java\\JavaAdvanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        File[] files = file.listFiles();

        long size = 0;
        for (File file1 : files) {
            size += file1.length();
        }
        System.out.println("Folder size: " + size);
    }
}
