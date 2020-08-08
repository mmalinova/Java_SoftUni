import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String barcodeRegex = "(@#+)(?<barcode>[A-Z][A-Za-z\\d]{4,}[A-Z])(@#+)";
        Pattern barcodePattern = Pattern.compile(barcodeRegex);

        String digitsRegex = "\\d";
        Pattern digitsPattern = Pattern.compile(digitsRegex);

        for (int i = 0; i < n; i++) {
            String string = scan.nextLine();
            Matcher barcodeMatcher = barcodePattern.matcher(string);
            if (barcodeMatcher.find()) {
                String barcode = barcodeMatcher.group("barcode");
                Matcher digitsMatcher = digitsPattern.matcher(barcode);
                StringBuilder sb = new StringBuilder();
                while (digitsMatcher.find()) {
                    sb.append(digitsMatcher.group());
                }
                if (sb.length() == 0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println(String.format("Product group: %s", sb));
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
