package com.cc.taskmanager.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.cc.taskmanager.model.Task;

public class TempData {
	static List<Task> tempData = new ArrayList<>();
	static Stack<Task> deletedTasks = new Stack<Task>();
	
	

	/**
	 * Returns the stack holding tasks removed from the temporary dataset (deletion history).
	 *
	 * <p>The returned Stack is the live storage used to record deleted Task objects (e.g., for undo/recovery).
	 * Modifications to the returned Stack affect the TempData deletion history directly.
	 *
	 * @return the live Stack of deleted Task instances (never null)
	 */
	public static Stack<Task> getDeletedTasks() {
		return deletedTasks;
	}

	/**
	 * Sets the global deletion history stack used to store removed tasks.
	 *
	 * Replaces the current static deletedTasks stack with the provided one. Passing
	 * null clears the deletion history (the static reference will be set to null).
	 *
	 * @param deletedTasks the new Stack of deleted Task objects to use as the deletion history
	 */
	public static void setDeletedTasks(Stack<Task> deletedTasks) {
		TempData.deletedTasks = deletedTasks;
	}

	/**
	 * Returns the in-memory list of temporary Task objects.
	 *
	 * This is the static backing list used by the class to store current tasks.
	 * The returned list is the live, mutable collection; callers modifying it
	 * will affect the shared temporary task storage.
	 *
	 * @return the live List of temporary Task instances
	 */
	public static List<Task> getTempData() {
		return tempData;
	}

	/**
	 * Replace the in-memory list of temporary tasks used by TempData.
	 *
	 * This assigns the provided List<Task> to the class-level storage; the reference is stored as-is
	 * (no defensive copy). Existing deletedTasks stack is not modified.
	 *
	 * @param tempData the new list to use as the temporary task store (may be null)
	 */
	public static void setTempData(List<Task> tempData) {
		TempData.tempData = tempData;
	}
	
	/**
	 * Removes the first Task with the given id from the in-memory tempData list and records it on the deletion stack.
	 *
	 * If a Task with the specified id is found, it is pushed onto {@code deletedTasks} before being removed from
	 * {@code tempData}. The method stops after the first match (IDs are treated as unique).
	 *
	 * @param taskId the id of the Task to remove and record for potential recovery
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
