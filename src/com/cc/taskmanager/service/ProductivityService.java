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
	
	/*
	 * methods:
	 * 1. [ ] View Top Priority Tasks
	 * 2. [ ] View Upcoming Due Tasks
	 * 3. [ ] Undo Deleted Task
	 * 4. [ ] Task History
	 * 5. [ ] Fast Search by Title/Keyword
	 * 6. [ ] Tag-Based Search
	 * 7. [ ] Sort by Custom Logic (date + priority + status)
	 * 8. [ ] Save/Load Tasks from File
	 * 9. [ ] Count Tasks by Status / Tag
	 * 10. [ ] Split Complex Task into Subtasks (Recursive)
	 * 11. [ ] Time Logs per Task
	 * 12. [ ] Filter Task Logs between Date Ranges
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
