package com.cc.taskmanager.service;

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
	
	public static void viewTopPriorityTasks() {
		// TODO PriorityQueue with custom Comparator
		
	}
	
	public static void viewUpcomingDueTasks() {
		// TODO MinHeap or simple sort on due date
	}
	
	public static void undoDeletedTask() {
		// TODO Stack to store deleted tasks for undo
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
