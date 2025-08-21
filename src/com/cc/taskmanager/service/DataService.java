package com.cc.taskmanager.service;

import java.util.List;

import com.cc.taskmanager.enums.Priority;
import com.cc.taskmanager.enums.Status;
import com.cc.taskmanager.model.Task;

public class DataService {
	
	//lets use over ride logic here
	
	public static void viewAllTask(List<Task> tasks) {
		
		if (tasks.isEmpty()) {
			System.out.println("No tasks available.");
			return;
		}
		
		// Dislays in sorted manner with respected to due date
		
		tasks.sort((task1, task2) -> task1.getDueDate().compareTo(task2.getDueDate()));
		System.out.println("All Tasks:");
		for (Task task : tasks) {
			System.out.println(task);
		}
	}
	
	public static void viewAllTask(List<Task> tasks, Priority priority) {
		/*
		 * Verifying that your CI/build uses Java 16+ (the minimum version that supports Stream.toList()), or
		 * Replacing both calls with Collectors.toList() to maintain broader Java compatibility:
		 */
		
		if (tasks.isEmpty()) {
			System.out.println("No tasks available.");
			return;
		}
		
		// Filter tasks by priority
		List<Task> filteredTasks = tasks.stream()
				.filter(task -> task.getPriority() == priority)
				.collect(java.util.stream.Collectors.toList());
		
		if (filteredTasks.isEmpty()) {
			System.out.println("No tasks found with priority: " + priority);
			return;
		}
		
		System.out.println("Tasks with priority " + priority + ":");
		for (Task task : filteredTasks) {
			System.out.println(task);
		}
	}
	
public static void viewAllTask(List<Task> tasks, Status status) {
		
		if (tasks.isEmpty()) {
			System.out.println("No tasks available.");
			return;
		}
		
		// Filter tasks by priority
		List<Task> filteredTasks = tasks.stream()
				.filter(task -> task.getStatus() == status)
				.collect(java.util.stream.Collectors.toList());
		
		if (filteredTasks.isEmpty()) {
			System.out.println("No tasks found with status: " + status);
			return;
		}
		
		System.out.println("Tasks with status " + status + ":");
		for (Task task : filteredTasks) {
			System.out.println(task);
		}
	}

}
