package com.cc.taskmanager.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.Set;

import com.cc.taskmanager.enums.Priority;
import com.cc.taskmanager.enums.Status;

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
	
	public static int askInt (String message) {
		System.out.println(message);
		while (!scanner.hasNextInt()) {
			System.out.println("Invalid input. Please enter a valid integer.");
			scanner.next(); // Clear the invalid input
		}
		int input = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character
		//System.out.println("You entered: " + input);
		return input;
	}
	
	public static LocalDate askDate(String message) {
		System.out.println(message);
		while (true) {
			String input = scanner.nextLine();
			try {
				return LocalDate.parse(input);
			} catch (DateTimeParseException e) {
				System.out.println("Invalid date format. Please enter a valid date.");
			}
		}
	}
	
	public static Status askStatus() {
		while (true) {
			int option = askInt("Please enter the status (1 for TODO, 2 for IN_PROGRESS, 3 for DONE):");
			switch (option) {
				case 1:
					return Status.TODO;
				case 2:
					return Status.IN_PROGRESS;
				case 3:
					return Status.DONE;
				default:
					System.out.println("Invalid option. Please try again.");
			}
		}
	}
	
	public static Priority askPriority() {
		while (true) {
			int option = askInt("Please enter the priority (1 for LOW, 2 for MEDIUM, 3 for HIGH):");
			switch (option) {
				case 1:
					return Priority.LOW;
				case 2:
					return Priority.MEDIUM;
				case 3:
					return Priority.HIGH;
				default:
					System.out.println("Invalid option. Please try again.");
			}
		}
	}
	
}
