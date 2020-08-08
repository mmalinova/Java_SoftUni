import java.util.Scanner;
import java.util.regex.Pattern;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] path = scan.nextLine().split("\\.");

        //String separator = "\\";
        //String[] filePath = path[0].replaceAll(Pattern.quote(separator), "\\\\").split("\\\\");
        String[] filePath = path[0].split("\\\\");
        String fileName = filePath[filePath.length - 1];
        String extension = path[1];

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);
    }
}
