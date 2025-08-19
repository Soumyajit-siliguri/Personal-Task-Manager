package com.cc.taskmanager;

import com.cc.taskmanager.service.TaskService;

public class Main {

	public static void main(String[] args) {
		// This is the entry point of the application.
		// You can initialize your application here, set up the user interface, etc.
		System.out.println("Welcome to the Personal Task Manager!");
		
		// Example usage of TaskService
		TaskService taskService = new TaskService();
		taskService.addTask("Sample Task", "This is a sample task description", "2023-12-31", "High", "tag1,tag2");
		
		// You can add more functionality or user interaction here.
		
		System.out.println("Application started successfully.");

	}

}
