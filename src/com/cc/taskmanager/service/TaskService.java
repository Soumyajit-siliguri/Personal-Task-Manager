package com.cc.taskmanager.service;

import java.time.LocalDate;
import java.util.Set;

import com.cc.taskmanager.enums.ActionType;
import com.cc.taskmanager.enums.Priority;
import com.cc.taskmanager.enums.Status;
import com.cc.taskmanager.model.Task;
import com.cc.taskmanager.util.LoggerUtility;
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
		
		while (dueDate.isBefore(LocalDate.now())) {
		    System.out.println("Due date cannot be in the past. Please enter a valid date.");
		    dueDate = TaskManagerUtility.askDate("When is it due? (YYYY-MM-DD)");
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
		int option = TaskManagerUtility.askInt("What do you want to update?\n1. Title\n2. Description\n3. Due Date\n4. Priority\n5. Tags\n6. Status\nPlease enter your choice (1-6): ");
		switch (option) {
			case 1:
				String newTitle = TaskManagerUtility.askString("Enter new title:");
				changeTitle(task, newTitle);
				System.out.println(LoggerUtility.log(ActionType.UPDATE_TASK_TITLE, task)); 
				break;
			case 2:
				String newDescription = TaskManagerUtility.askString("Enter new description:");
				changeDescription(task, newDescription);
				System.out.println(LoggerUtility.log(ActionType.UPDATE_TASK_DESCRIPTION, task));
				break;
			case 3:
				LocalDate newDueDate = TaskManagerUtility.askDate("Enter new due date (YYYY-MM-DD):");
				changeDueDate(task, newDueDate);
				System.out.println(LoggerUtility.log(ActionType.UPDATE_TASK_DUE_DATE, task));
				break;
			case 4:
				Priority newPriority = TaskManagerUtility.askPriority();
				changePriority(task, newPriority);
				System.out.println(LoggerUtility.log(ActionType.UPDATE_TASK_PRIORITY, task));
				break;
			case 5:
				changeTags(task);
				System.out.println(LoggerUtility.log(ActionType.UPDATE_TASK_TAGS, task));
				break;
			case 6:
				Status newStatus = TaskManagerUtility.askStatus();
				changeStatus(task, newStatus);
				System.out.println(LoggerUtility.log(ActionType.UPDATE_TASK_STATUS, task));
				break;
			default:
				System.out.println("Invalid option. No changes made.");
		}
		System.out.println("Task updated: " + task.getTitle());
	}
	
	
	
	public void changeTitle(Task task, String newTitle) {
		// Logic to change the title of a task
		if(newTitle == null || newTitle.trim().isEmpty()) {
			System.out.println("Title cannot be empty. No changes made.");
			return;
		}else {
			task.setTitle(newTitle);
		}
		System.out.println("Task ID " + task.getId() + " title changed to: " + task.getTitle());
	}
	
	public void changeDescription(Task task, String newDescription) {
		// Logic to change the description of a task
		if(newDescription == null || newDescription.trim().isEmpty()) {
			System.out.println("Description cannot be empty. No changes made.");
			return;
		}else {
			task.setDescription(newDescription);
		}
		System.out.println("Task ID " + task.getId() + " description changed to: " + task.getDescription());
	}
	
	public void changeDueDate(Task task, LocalDate newDueDate) {
		// Logic to change the due date of a task
		//TODO - can not be past date.
		if(newDueDate == null || newDueDate.isBefore(LocalDate.now())) {
			System.out.println("Due date cannot be in the past or null. No changes made.");
			return;
		}else {
			task.setDueDate(newDueDate);
		}
		System.out.println("Task ID " + task.getId()  + " due date changed to: " + task.getDueDate());
	}
	
	public void changePriority(Task task, Priority newPriority) {
		// Logic to change the priority of a task
		task.setPriority(newPriority);
		System.out.println("Task ID "  + " priority changed to: " + newPriority);
	}
	
	public void changeTags(Task task) {
		// Logic to change the tags of a task
		//TODO - ask : add, remove or replace tags
		System.out.println("Current tags: " + task.getTagString());
		int option = TaskManagerUtility.askInt("What do you want to do with tags?\n1. Add Tags\n2. Remove Tags\n3. Replace Tags\nPlease enter your choice (1-3): ");
		switch (option) {
			case 1:
				String addTags = TaskManagerUtility.askString("Enter tags to add (comma-separated):");
				task.addTags(TaskManagerUtility.parseTags(addTags));
				break;
			case 2:
				String removeTags = TaskManagerUtility.askString("Enter tags to remove (comma-separated):");
				task.removeTags(TaskManagerUtility.parseTags(removeTags));
				break;
			case 3:
				String replaceTags = TaskManagerUtility.askString("Enter new tags (comma-separated):");
				task.setTags(TaskManagerUtility.parseTags(replaceTags));
				break;
			default:
				System.out.println("Invalid option. No changes made.");
				return;
		}
		System.out.println("Task ID " + " tags changed to: " + task.getTagString());
	}
	
	public void changeStatus(Task task, Status newStatus) {
		// Logic to change the status of a task
		task.setStatus(newStatus);
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
