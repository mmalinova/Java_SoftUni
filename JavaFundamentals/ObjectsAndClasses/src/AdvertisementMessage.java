import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String[] phrases = new String[] {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can’t live without this product."};
        String[] events = new String[] {"Now I feel good.", "I have succeeded with this product.", "Makes miracles.", "I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = new String[] {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = new String[] {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int randomPh = rand.nextInt(phrases.length);
            int randomEv = rand.nextInt(events.length);
            int randomAu = rand.nextInt(authors.length);
            int randomCi = rand.nextInt(cities.length);

            System.out.print(phrases[randomPh] + " " + events[randomEv] + " " + authors[randomAu] + " - " + cities[randomCi]);
            System.out.println();
        }
    }
}
