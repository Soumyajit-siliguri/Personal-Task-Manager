package com.cc.taskmanager.util;

import java.time.LocalDateTime;

import com.cc.taskmanager.enums.ActionType;
import com.cc.taskmanager.enums.Status;
import com.cc.taskmanager.model.Task;

public class LoggerUtility {
	
	public static String log(ActionType action, Task task) {
		StringBuilder logMessage = new StringBuilder();
		logMessage.append("[").append(LocalDateTime.now()).append("] ");
		logMessage.append(task.getId()).append(" - ").append(task.getTitle()).append(": ");
		switch(action) {
			case ADD_NEW_TASK:
				logMessage.append("New task added");
				System.out.println("[LOG] New task added: " + task.getId() + task.getTitle());
				break;
			case UPDATE_TASK_TITLE:
				
				logMessage.append("Task title updated");
				System.out.println("[LOG] New task Title: " + task.getTitle());
				break;
			case UPDATE_TASK_DESCRIPTION:
				System.out.println("[LOG] New task Description: " + task.getDescription());
				logMessage.append("Task description updated");
				break;
			case UPDATE_TASK_DUE_DATE:
				System.out.println("[LOG] Updated task due date: " + task.getDueDate().toString());
				logMessage.append("Task due date updated");
				break;
			case UPDATE_TASK_PRIORITY:
				System.out.println("[LOG] Updated task priority: " + task.getPriority().toString());
				logMessage.append("Task priority updated");
				break;
			case UPDATE_TASK_STATUS:
				if(task.getStatus().equals(Status.DONE)) {
					System.out.println("[LOG] Task marked as completed: " + task.getId());
					logMessage.append("Task marked as completed");
				}else if(task.getStatus().equals(Status.IN_PROGRESS)) {
					System.out.println("[LOG] Task Started: " + task.getId());
					logMessage.append("Task Started");
				}else {
					System.out.println("[LOG] Task status updated: " + task.getId() + task.getStatus().toString());
					logMessage.append("Task status updated");
				}
				break;
			case DELETE_TASK:
				System.out.println("[LOG] Task deleted: " + task.getId() + task.getTitle());
				logMessage.append("Task deleted");

				break;
			case UNDO_DELETE_TASK:
				System.out.println("[LOG] Task deletion undone: " + task.getId() + task.getTitle() + LocalDateTime.now());
				logMessage.append("Task deletion undone");
				break;
			case UPDATE_TASK_TAGS:
				System.out.println("[LOG] Updated tags: " + task.getId() + task.getTitle() + "-" + task.getTagString());
				logMessage.append("Task tags updated");
				break;
			default:
				System.out.println("[LOG] Unknown action for task: " + task.getId() + task.getTitle() + LocalDateTime.now());
				logMessage.append("Unknown action");
				break;
		}		
		return logMessage.toString();
	}

}
