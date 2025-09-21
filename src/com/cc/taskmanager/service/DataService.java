package com.cc.taskmanager.service;

import java.util.List;

import com.cc.taskmanager.data.TempData;
import com.cc.taskmanager.enums.Priority;
import com.cc.taskmanager.enums.Status;
import com.cc.taskmanager.model.Task;

public class DataService {
	
	/**
	 * Prints all tasks sorted by due date (ascending).
	 *
	 * The provided list is sorted in-place and each task is printed to standard output.
	 *
	 * @param tasks list of tasks to display; must be non-null. If empty, a "No tasks available." message is printed.
	 */
	
	public static void viewAllTask(List<Task> tasks) {
		
		if (tasks.isEmpty()) {
			System.out.println("No tasks available.");
			return;
		}
		
		// Dis lays in sorted manner with respected to due date
		
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
		
		if (tasks.isEmpty() || tasks == null) {
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
		
		if (tasks.isEmpty() || tasks == null) {
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

	/**
	 * Deletes the task with the given ID from the temporary storage.
	 *
	 * If the provided ID is negative, the method prints "Invalid task ID." and does nothing.
	 * If no task with the given ID exists, the method prints "Task with ID {id} not found." and does nothing.
	 * On success, the task is removed from TempData and the method prints "Task deleted with ID: {id}".
	 *
	 * @param taskId the identifier of the task to delete; must be non-negative
	 */
	public static void deleteTask(int taskId) {
	// Logic to delete a task
		
		if (taskId < 0) {
			System.out.println("Invalid task ID.");
			return;
		}
		
		Task task = getTaskById(TempData.getTempData(), taskId);
		if (task == null) {
			System.out.println("Task with ID " + taskId + " not found.");
			return;
		}
		
		TempData.deleteTask(taskId);
		
	System.out.println("Task deleted with ID: " + taskId);
	}

	public static Task getTaskById(List<Task> taskList, int taskId) {
		// TODO Auto-generated method stub
		if (taskList == null || taskList.isEmpty()) {
			System.out.println("No tasks available.");
			return null;
		}
		for (Task task : taskList) {
			if (task.getId() == taskId) {
				return task;
			}
		}
		return null;
	}

}
