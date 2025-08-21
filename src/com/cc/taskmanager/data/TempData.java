package com.cc.taskmanager.data;

import java.util.ArrayList;
import java.util.List;

import com.cc.taskmanager.model.Task;

public class TempData {
	List<Task> tempData = new ArrayList<>();

	public List<Task> getTempData() {
		return tempData;
	}

	public void setTempData(List<Task> tempData) {
		this.tempData = tempData;
	}
	

}
