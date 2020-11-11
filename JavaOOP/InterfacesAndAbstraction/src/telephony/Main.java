package telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] phoneNumbers = scan.nextLine().split(" ");
        String[] sites = scan.nextLine().split(" ");

        List<String> urls = Arrays.asList(sites.clone());
        List<String> phones = Arrays.asList(phoneNumbers.clone());


        Smartphone smartphone = new Smartphone(phones, urls);
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
