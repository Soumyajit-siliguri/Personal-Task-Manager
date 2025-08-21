package com.cc.taskmanager.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import com.cc.taskmanager.enums.Priority;
import com.cc.taskmanager.enums.Status;

public class Task {
	static int counter=0;
	private int id;
	private String title;
	private String description;
	private LocalDate dueDate;
	private Priority priority;
	private Set<String> tags;
	private Status status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public Set<String> getTags() {
		return tags;
	}
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Task(String title, String description, LocalDate dueDate, Priority priority, Set<String> tags) {
		super();
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.priority = priority;
		this.tags = tags;
		this.status = Status.TODO;
		this.id = ++counter;
	}
	
	public Task(String title, LocalDate dueDate) {
		this(title, "n/a" , dueDate, Priority.LOW, null);
	}
	
	public Task(String title, String description, LocalDate dueDate) {
		this(title, description, dueDate, Priority.LOW, null);
	}
	
	public Task(String title, String description, LocalDate dueDate, Priority priority) {
		this(title, description, dueDate, priority, null);
	}
	
	public Task(String title, LocalDate dueDate, Priority priority) {
		this(title, "n/a", dueDate, priority, null);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Task Id=").append(id)
		  .append(", Title=").append(title)
		  .append("\nDescription=").append(description)
		  .append("\nDue Date=").append(dueDate)
		  .append("\nPriority=").append(priority)
		  .append("\nTags=");
		
		if (tags != null && !tags.isEmpty()) {
		  for (String tag : tags) {
		    sb.append(", ").append(tag);
		  }
		}else {
			sb.append(" n/a");
		}
		
		sb.append("\nStatus=").append(status);
		
		return sb.toString();
	}
	
	public String getTagString() {
		if (tags == null || tags.isEmpty()) {
			return "n/a";
		}
		StringBuilder sb = new StringBuilder();
		for (String tag : tags) {
			sb.append(tag).append(", ");
		}
		return sb.substring(0, sb.length() - 2); // Remove the last comma and space
	}
	
	public void addTags(Set<String> tags2) {
		// TODO Auto-generated method stub
		if (tags2 != null && !tags2.isEmpty()) {
			if (this.tags == null) {
				this.tags = tags2;
			} else {
				this.tags.addAll(tags2);
			}
		} else {
			System.out.println("No tags to add.");
		}
		
	}
	public void removeTags(Set<String> tags2) {
		// TODO Auto-generated method stub
		if (tags2 != null && !tags2.isEmpty() && this.tags != null) {
			this.tags.removeAll(tags2);
		} else {
			System.out.println("No tags to remove or no existing tags.");
		}
		
	}
}
