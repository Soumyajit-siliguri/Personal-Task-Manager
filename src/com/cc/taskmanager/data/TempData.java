package com.cc.taskmanager.data;

import java.util.ArrayList;
import java.util.List;

import com.cc.taskmanager.model.Task;

public class TempData {
	static List<Task> tempData = new ArrayList<>();

	public static List<Task> getTempData() {
		return tempData;
	}

	public static void setTempData(List<Task> tempData) {
		TempData.tempData = tempData;
	}
	
	public static void deleteTask(int taskId) {
		tempData.removeIf(task -> task.getId() == taskId);
	}
	

}
