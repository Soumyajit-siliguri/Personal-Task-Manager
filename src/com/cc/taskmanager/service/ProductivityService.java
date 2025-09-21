package com.cc.taskmanager.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import com.cc.taskmanager.enums.ActionType;
import com.cc.taskmanager.enums.Status;
import com.cc.taskmanager.model.Task;
import com.cc.taskmanager.util.LoggerUtility;

public class ProductivityService {
	
	/**
	 * Prints the given tasks to standard output ordered by their priority (ascending).
	 *
	 * Builds a PriorityQueue using Task.getPriority() as the comparison key and prints
	 * tasks from highest-to-lowest priority according to the queue's ascending order.
	 *
	 * @param taskList the collection of tasks to order and display; the list itself is not modified
	 */
	
	public void viewTopPriorityTasks(List<Task> taskList) {
		 PriorityQueue<Task> pq = new PriorityQueue<>(
				 (t1, t2) -> t1.getPriority().compareTo(t2.getPriority())
				 );
		 
		 pq.addAll(taskList);
		 
		 System.out.println("Tasks in priority order:");
		    while (!pq.isEmpty()) {
		        System.out.println(pq.poll());
		    }
		
	}
	
	/**
	 * Prints tasks from the provided list that are due today or later, ordered by earliest due date first.
	 *
	 * <p>Filters the input tasks to include only those whose due date is on or after the current system date
	 * (LocalDate.now()) and whose status is neither DONE nor DELETED, then outputs them in ascending due-date order.</p>
	 *
	 * @param taskList the list of tasks to inspect; expected to contain Task instances with non-null due dates and statuses
	 */
	public void viewUpcomingDueTasks(List<Task> taskList) {
		
	    PriorityQueue<Task> minHeap = new PriorityQueue<>(
	        Comparator.comparing(Task::getDueDate)   // earliest due date first
	    );
	    
	 // Load tasks into heap
	 // Add only tasks whose dueDate >= today
	   /* for (Task task : taskList) {
	        if (!task.getDueDate().isBefore(LocalDate.now()) && !task.getStatus().equals(Status.DONE) && !task.getStatus().equals(Status.DELETED)) { // keep today + future
	            minHeap.add(task);
	        }
	    }
	    */
	    taskList.stream()
        .filter(task -> !task.getDueDate().isBefore(LocalDate.now()))
        .filter(task -> task.getStatus() != Status.DONE && task.getStatus() != Status.DELETED)
        .forEach(minHeap::add); 

	    System.out.println("Upcoming due tasks (soonest first):");
	    while (!minHeap.isEmpty()) {
	        System.out.println(minHeap.poll());
	    }
		
	}
	
	/**
	 * Restores the most recently deleted Task from the provided stack back into the working task list.
	 *
	 * If the deletedTasks stack is non-empty this method pops the top Task (LIFO). If no Task in tempData
	 * has the same id, the method adds the popped Task to tempData, prints a restoration message, and
	 * records the undo action via LoggerUtility. If a Task with the same id already exists in tempData,
	 * it prints an ID conflict message and does not restore. If deletedTasks is empty, a message is printed.
	 *
	 * Side effects:
	 * - May modify tempData (adds a Task) and deletedTasks (pops a Task).
	 * - Prints status messages to standard output and logs the undo action via LoggerUtility when restoration occurs.
	 *
	 * @param tempData     the working list of tasks to restore into
	 * @param deletedTasks a stack of deleted tasks where the most recently deleted task is at the top
	 */
	public void undoDeletedTask(List<Task> tempData, Stack<Task> deletedTasks) {
		if (!deletedTasks.isEmpty()) {
	        Task taskToRestore = deletedTasks.pop(); // LIFO: get the last deleted task
	        
	        boolean exists = tempData.stream().anyMatch(t -> t.getId() == taskToRestore.getId());
	        if (!exists) {
	            tempData.add(taskToRestore);
	            System.out.println("Task restored: " + taskToRestore);
	            System.out.println(LoggerUtility.log(ActionType.UNDO_DELETE_TASK, taskToRestore));
	        } else {
	            System.out.println("Cannot restore task — ID already exists: " + taskToRestore.getId());
	        }
 
	    } else {
	        System.out.println("No deleted tasks to undo.");
	    }
		
		
	}
	
	/**
	 * Display the application's task modification history to the user.
	 *
	 * <p>Placeholder method: intended to present a chronological view of recent task events
	 * (creations, updates, deletions). Implementations may use a time-ordered collection
	 * (e.g., List/LinkedList or Queue/Deque) to maintain and iterate recent history entries,
	 * and should format each history entry with a timestamp, task identifier, and brief action
	 * description.</p>
	 */
	public static void viewTaskHistory() {
		// TODO List or LinkedList to maintain history
		//OR TODO Queue or Deque (view recently modified tasks)
	}
	
	public static void fastSearchByTitleOrKeyword() {
		// TODO HashMap for O(1) lookups
		//HashMap<String, List<Task>> or simple substring
	}
	
	public static void tagBasedSearch() {
		// TODO Inverted Index using HashMap<String, List<Task>>
	}
	
	public static void sortByCustomLogic() {
		// TODO Custom Comparator with multiple criteria
		//Comparator, Collections.sort()
	}
	
	public static void saveLoadTasksFromFile() {
		// TODO Serialization/Deserialization using JSON or XML
		//Gson, Jackson, JAXB
		//Java Serialization (ObjectOutputStream, etc.)
	}
	
	public static void countTasksByStatusOrTag() {
		// TODO HashMap<Status/Tag, Integer> for counting
		//Use of Map<String, Integer>
	}
	
	public static void splitComplexTaskIntoSubtasks() {
		// TODO Composite Pattern or Tree Structure
		//Tree, Recursive Data Structure
		//Use recursion, tree-like design
	}
	
	public static void timeLogsPerTask() {
		// TODO List of TimeLog objects per Task
		//List<TimeLog> in Task class
		//OR TODO Map<TaskId, List<TimeLog>>
	}
	
	public static void filterTaskLogsBetweenDateRanges() {
		// TODO Stream API with filter by date range
		//Use Stream.filter(), LocalDate comparisons
		//Date comparison, Stream or loop logic
	}
	

}
