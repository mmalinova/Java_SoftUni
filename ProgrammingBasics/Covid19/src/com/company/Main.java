package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	char output = '*';
	int total = 0;

	    System.out.printf("Day 1: ");
	    int numForDay1 = Integer.parseInt(scan.nextLine());
		System.out.printf("Day 2: ");
		int numForDay2 = Integer.parseInt(scan.nextLine());
		System.out.printf("Day 3: ");
		int numForDay3 = Integer.parseInt(scan.nextLine());
		System.out.printf("Day 4: ");
		int numForDay4 = Integer.parseInt(scan.nextLine());
		System.out.printf("Day 5: ");
		int numForDay5 = Integer.parseInt(scan.nextLine());
		System.out.printf("Day 6: ");
		int numForDay6 = Integer.parseInt(scan.nextLine());
		System.out.printf("Day 7: ");
		int numForDay7 = Integer.parseInt(scan.nextLine());

		total = numForDay1 + numForDay2 + numForDay3 + numForDay4 + numForDay5 + numForDay6 + numForDay7;

			System.out.printf("%nDay 1: ");
			for (int i = 1; i <= numForDay1; i++) {
				System.out.printf("%c", output);
			}
			System.out.printf("%nDay 2: ");
			for (int i = 1; i <= numForDay2; i++) {
				System.out.printf("%c", output);
			}
			System.out.printf("%nDay 3: ");
			for (int i = 1; i <= numForDay3; i++) {
				System.out.printf("%c", output);
			}
			System.out.printf("%nDay 4: ");
			for (int i = 1; i <= numForDay4; i++) {
				System.out.printf("%c", output);
			}
			System.out.printf("%nDay 5: ");
			for (int i = 1; i <= numForDay5; i++) {
				System.out.printf("%c", output);
			}
			System.out.printf("%nDay 6: ");
			for (int i = 1; i <= numForDay6; i++) {
				System.out.printf("%c", output);
			}
			System.out.printf("%nDay 7: ");
			for (int i = 1; i <= numForDay7; i++) {
				System.out.printf("%c", output);
			}

		System.out.printf("%nTotal sick people: %d%n", total);
		System.out.printf("Total increasing from day 1 to 7: %.2f%%.%n", (total * 1.0/ numForDay1) * 100);
    }
}
