package com.cc.taskmanager;

import java.util.List;
import java.util.Stack;

import com.cc.taskmanager.data.TempData;
import com.cc.taskmanager.enums.ActionType;
import com.cc.taskmanager.enums.Priority;
import com.cc.taskmanager.enums.Status;
import com.cc.taskmanager.model.Task;
import com.cc.taskmanager.service.DataService;
import com.cc.taskmanager.service.ProductivityService;
import com.cc.taskmanager.service.TaskService;
import com.cc.taskmanager.util.LoggerUtility;
import com.cc.taskmanager.util.TaskManagerUtility;

public class Main {

	public static void main(String[] args) {
		
		List<Task> taskList = TempData.getTempData();
		Stack<Task> deletedTasks = TempData.getDeletedTasks();
		
		// This is the entry point of the application.
		// You can initialize your application here, set up the user interface, etc.
		System.out.println("Welcome to the Personal Task Manager!");
		
		// Example usage of TaskService
		TaskService taskService = new TaskService();
		ProductivityService productivityService = new ProductivityService();

		// You can add more functionality or user interaction here.
		
		System.out.println("Application started successfully.");
		boolean running = true;
		while(running) {
			int action = taskService.showMainMenu();
			switch(action) {
			case 1:
				//TODO add new task
				Task  newTask= taskService.addTask();
				taskList.add(newTask);
				LoggerUtility.log(ActionType.ADD_NEW_TASK, newTask);
				System.out.println(LoggerUtility.log(ActionType.ADD_NEW_TASK, newTask));
				break;
			case 2:
				//TODO Update existing task
				int taskId = TaskManagerUtility.askInt("Enter the ID of the task you want to update: ");
				Task taskToUpdate = DataService.getTaskById(taskList, taskId);
				if(taskToUpdate != null) {
					taskService.updateTask(taskToUpdate);
					System.out.println("Task updated successfully.");
					System.out.println("updated task: "+ taskList.get(taskId));
				} else {
					System.out.println("Task with ID " + taskId + " not found.");
				}
				break;
			case 3:
				//TODO Delete exisitng task
				int taskIdToDelete = TaskManagerUtility.askInt("Enter the ID of the task you want to delete: ");
				DataService.deleteTask(taskIdToDelete);
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
				int productivityOption = TaskManagerUtility.askInt("What do you want to do?\n1. View Top Priority Tasks\n2. View Upcoming Due Tasks\n3. ");
				
				switch (productivityOption) {
				case 1:
					productivityService.viewTopPriorityTasks(taskList);
					break;
				case 2:
					productivityService.viewUpcomingDueTasks(taskList);
				case 3:
					productivityService.undoDeletedTask(taskList, deletedTasks);
				default:
					System.out.println("Otion not available. Moving to main menu..");
					break;
				}
			case 6:
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
