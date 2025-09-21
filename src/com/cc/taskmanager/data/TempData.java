package com.cc.taskmanager.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.cc.taskmanager.model.Task;

public class TempData {
	static List<Task> tempData = new ArrayList<>();
	static Stack<Task> deletedTasks = new Stack<Task>();
	
	

	public static Stack<Task> getDeletedTasks() {
		return deletedTasks;
	}

	public static void setDeletedTasks(Stack<Task> deletedTasks) {
		TempData.deletedTasks = deletedTasks;
	}

	public static List<Task> getTempData() {
		return tempData;
	}

	public static void setTempData(List<Task> tempData) {
		TempData.tempData = tempData;
	}
	
	/*
	 public static void deleteTask(int taskId) {
	 
		
		tempData.removeIf(task -> task.getId() == taskId);
	}
	*/
	
	public static void deleteTask(int taskId) {
	    // Find the task to delete
	    for (Iterator<Task> iterator = tempData.iterator(); iterator.hasNext();) {
	        Task task = iterator.next();
	        if (task.getId() == taskId) {
	            // Push into stack first
	            deletedTasks.push(task);

	            // Remove from tempData
	            iterator.remove();
	            break; // assuming IDs are unique
	        }
	    }
	}

	

}
