package com.cc.taskmanager;

import java.util.List;

import com.cc.taskmanager.data.TempData;
import com.cc.taskmanager.enums.Priority;
import com.cc.taskmanager.enums.Status;
import com.cc.taskmanager.model.Task;
import com.cc.taskmanager.service.DataService;
import com.cc.taskmanager.service.TaskService;
import com.cc.taskmanager.util.TaskManagerUtility;

public class Main {

	public static void main(String[] args) {
		
		TempData tempData = new TempData();
		List<Task> taskList = tempData.getTempData();
		
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
				taskList.add(taskService.addTask());
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
				DataService.viewAllTask(taskList);
				boolean withFilter = TaskManagerUtility.askYesNo("Do you want to filter tasks? (yes/no): ");
				if(withFilter) {
					int filterOption = TaskManagerUtility.askInt("Select filter option:\n1. By Priority\n2. By Status\n3.By Tags\n4.Anything else to skip filter\nPlease enter your choice (1-3): ");
					switch(filterOption) {
					case 1:
						Priority priority = TaskManagerUtility.askPriority();
						DataService.viewAllTask(taskList, priority);
						break;
					case 2:
						Status status = TaskManagerUtility.askStatus();
						DataService.viewAllTask(taskList, status);
						break;
					case 3:
						System.out.println("Filtering by tags is not implemented yet.");
						break;
					default:
						System.out.println("Skipping filter.");
						break;
					}
				}
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
