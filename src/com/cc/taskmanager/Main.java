package com.cc.taskmanager;

import java.util.List;

import com.cc.taskmanager.data.TempData;
import com.cc.taskmanager.model.Task;
import com.cc.taskmanager.service.TaskService;

public class Main {

	public static void main(String[] args) {
		
		TempData tempData = new TempData();
		List<Task> TaskList = tempData.getTempData();
		
		// This is the entry point of the application.
		// You can initialize your application here, set up the user interface, etc.
		System.out.println("Welcome to the Personal Task Manager!");
		
		// Example usage of TaskService
		TaskService taskService = new TaskService();

		// You can add more functionality or user interaction here.
		
		System.out.println("Application started successfully.");
		boolean running = true;
		while(running) {
			int action = taskService.showMainMenu();
			switch(action) {
			case 1:
				//TODO add new task
				TaskList.add(taskService.addTask());
				System.out.println("New task added successfully.");
				break;
			case 2:
				//TODO Update existing task
				break;
			case 3:
				//TODO Delete exisitng task
				break;
			case 4:
				//View all tasks
				break;
			case 5:
				System.out.println("Exiting the application. Goodbye!");
				running = false;
				break;
			default:
				System.out.println("Invalid option. Please try again.");
				break;
			}
		}
	}

}
