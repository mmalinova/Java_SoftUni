package MoreExercise;

import jdk.dynalink.linker.ConversionComparator;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Snowwhite {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Long>> dwarfs = new LinkedHashMap<>();

        String command = scan.nextLine();
        while (!"Once upon a time".equals(command)) {
            String[] input = command.split("<:>");
            String dwarfName = input[0].trim();
            String dwarfHatColor = input[1].trim();
            long dwarfPhysics = Integer.parseInt(input[2].trim());
            dwarfs.putIfAbsent(dwarfHatColor, new LinkedHashMap<>());
            dwarfs.get(dwarfHatColor).putIfAbsent(dwarfName, dwarfPhysics);
            long higherPhysics = Math.max(dwarfs.get(dwarfHatColor).get(dwarfName), dwarfPhysics);
            dwarfs.get(dwarfHatColor).put(dwarfName, higherPhysics);
            command = scan.nextLine();
        }
        Map<String, Long> print = new LinkedHashMap<>();

        for(Map.Entry<String, Map<String, Long>> entry : dwarfs.entrySet()) {
            for(Map.Entry<String, Long> subEntry : entry.getValue().entrySet()) {
                print.put(entry.getKey() + " " + subEntry.getKey() + " " + entry.getValue().size(), subEntry.getValue());
            }
        }
        print.entrySet().stream().sorted((pair2, pair1) -> {
            int sort = Long.compare(pair1.getValue(), pair2.getValue());
            if (sort == 0) {
                String[] sort1 = pair1.getKey().split(" ");
                String[] sort2 = pair2.getKey().split(" ");
                sort = sort1[2].compareTo(sort2[2]);
            }
            return sort;
        }).forEach(pair -> {
            String[] printing = pair.getKey().split(" ");
            System.out.printf("(%s) %s <-> %d\n", printing[0], printing[1], pair.getValue());
        });

    }
}
