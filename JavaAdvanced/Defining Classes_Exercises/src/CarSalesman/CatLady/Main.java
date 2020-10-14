package CatLady;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Cats> cats = new ArrayList<>();

        String input = scan.nextLine();
        while(!"End".equals(input)) {
            //•	"Siamese <name> <earSize>"
            //•	"Cymric <name> <furLength>"
            //•	"StreetExtraordinaire <name> <decibelsOfMeows"
            String[] tokens = input.split("\\s+");
            String breeds = tokens[0];
            String catName = tokens[1];
            double specific = Double.parseDouble(tokens[2]);
            switch (breeds) {
                case "Siamese":
                    Siamese siamese = new Siamese(catName, specific);
                    cats.add(siamese);
                    break;
                case "Cymric":
                    Cymric cymric = new Cymric(catName, specific);
                    cats.add(cymric);
                    break;
                case "StreetExtraordinaire":
                    StreetExtraordinaire extraordinaire = new StreetExtraordinaire(catName, specific);
                    cats.add(extraordinaire);
                     break;
            }
            input = scan.nextLine();
        }

        String nameOfCat = scan.nextLine();
        for (Cats cat : cats) {
            if (cat.getName().equals(nameOfCat)) {
                System.out.println(cat);
            }
        }
    }
}
