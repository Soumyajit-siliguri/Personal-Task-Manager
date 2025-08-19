package com.cc.taskmanager.util;

import java.util.Scanner;
import java.util.Set;

public class TaskManagerUtility {
	/**
	 * Parses a comma-separated string of tags into a Set of Strings.
	 * 
	 * @param tags A comma-separated string of tags.
	 * @return A Set containing the individual tags.
	 */
	static Scanner scanner = new Scanner(System.in);
	public static Set<String> parseTags(String tags) {
		if (tags == null || tags.isEmpty()) {
			return Set.of();
		}
		String[] tagArray = tags.split(",");
		return Set.of(tagArray);
	}
	
	/**
	 * Prompts the user for input and returns the input as a String.
	 * 
	 * @param message The message to display to the user.
	 * @return The user's input as a String.
	 */
	public static String askString(String message) {
		System.out.println(message);
		return scanner.nextLine(); 
	}
	
	/**
	 * Prompts the user for a yes or no response and returns true for yes and false for no.
	 * 
	 * @param message The message to display to the user.
	 * @return true if the user responds with "yes", false otherwise.
	 */
	public static boolean askYesNo(String message) {
		System.out.println(message + " (yes/no)");
		String response = scanner.nextLine().trim().toLowerCase();
		return response.equals("yes") || response.equals("y");
	}
	
	public static void askInt(String message) {
		System.out.println(message);
		while (!scanner.hasNextInt()) {
			System.out.println("Invalid input. Please enter a valid integer.");
			scanner.next(); // Clear the invalid input
		}
		int input = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character
		System.out.println("You entered: " + input);
	}
}
