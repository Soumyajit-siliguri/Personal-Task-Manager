package com.cc.taskmanager.service;

import java.time.LocalDate;
import java.util.Set;

import com.cc.taskmanager.enums.Priority;
import com.cc.taskmanager.model.Task;
import com.cc.taskmanager.util.TaskManagerUtility;

public class TaskService {
	
	public Task addTask() {
		// Logic to add a task
		String taskName = TaskManagerUtility.askString("What's the Task?");
		LocalDate dueDate = TaskManagerUtility.askDate("When is it due? (YYYY-MM-DD)");
		String description = "";
		Priority priority = null;
		Set<String> tagsSet = null; // Initialize tagsSet to null
		
		// Optional fields
		/*
		 * ALL THE BELOW WILL NO LONGER BE REQUIRED IF SYSTEM GAINS An U.I
		 */
		boolean hasDescription = TaskManagerUtility.askYesNo("Does the task have a description?");
		if (hasDescription) {
			description = TaskManagerUtility.askString("Please enter the task description:");
		}
		boolean hasPriority = TaskManagerUtility.askYesNo("Does the task have a priority?");
		if (hasPriority) {
			priority = TaskManagerUtility.askPriority();
			//TODO - validate priority
		}
		boolean hasTags = TaskManagerUtility.askYesNo("Does the task have tags?");
		if (hasTags) {
			String tags = TaskManagerUtility.askString("Please enter the task tags (comma-separated):");
			tagsSet = TaskManagerUtility.parseTags(tags);
		}
		
		
		
		if(dueDate.isBefore(LocalDate.now())) {
			System.out.println("Due date cannot be in the past. Please enter a valid due date.");
			dueDate =  LocalDate.now();// or handle as needed
		}
		
		if(hasDescription && hasPriority && hasTags) {
			return new Task(taskName, description, dueDate, priority, tagsSet);
		}else if(hasDescription && hasPriority) {
			return new Task(taskName, description, dueDate, priority);
		} else if(hasDescription) {
			return new Task(taskName, description, dueDate);
		} else if(hasPriority) {
			return new Task(taskName, dueDate, priority);
		}
		
		return new Task(taskName, dueDate);
	}
	
	public void updateTask(Task task) {
		// Logic to update a task
		//TODO - ask what to update and update accordingly if task present
		System.out.println("Task updated: " + task.getTitle());
	}
	
	public void deleteTask(int taskId) {
		// Logic to delete a task
		System.out.println("Task deleted with ID: " + taskId);
	}
	
	public void changeTitle(Task task, String newTitle) {
		// Logic to change the title of a task
		System.out.println("Task ID "  + " title changed to: " + newTitle);
	}
	
	public void changeDescription(Task task, String newDescription) {
		// Logic to change the description of a task
		System.out.println("Task ID "  + " description changed to: " + newDescription);
	}
	
	public void changeDueDate(Task task, String newDueDate) {
		// Logic to change the due date of a task
		//TODO - can not be past date.
		System.out.println("Task ID "  + " due date changed to: " + newDueDate);
	}
	
	public void changePriority(Task task, String newPriority) {
		// Logic to change the priority of a task
		System.out.println("Task ID "  + " priority changed to: " + newPriority);
	}
	
	public void changeTags(Task task) {
		// Logic to change the tags of a task
		//TODO - ask : add, remove or replace tags
		System.out.println("Task ID " + " tags changed to: " + task.getTagString());
	}
	
	public void changeStatus(Task task, String newStatus) {
		// Logic to change the status of a task
		System.out.println("Task ID "  + " status changed to: " + newStatus);
	}

	public int showMainMenu() {
		System.out.println("Task Manager Menu:");
		System.out.println("1. Add Task");
		System.out.println("2. Update Task");
		System.out.println("3. Delete Task");
		System.out.println("4. View All Tasks");
		System.out.println("5. Exit");
		int option = TaskManagerUtility.askInt("Please select an option (1-5): ");
		while (option < 1 || option > 5) {
			System.out.println("Invalid option. Please try again.");
			option = TaskManagerUtility.askInt("Please select an option (1-5): ");
		}
		return option;
	}
	
	
	
	
	
	
	

}
