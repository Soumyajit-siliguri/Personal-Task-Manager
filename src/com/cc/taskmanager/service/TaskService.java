package com.cc.taskmanager.service;

import com.cc.taskmanager.model.Task;

public class TaskService {
	
	public void addTask(String title, String description, String dueDate, String priority, String tags) {
		// Logic to add a task
		System.out.println("Task added: " + title);
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
	

}
