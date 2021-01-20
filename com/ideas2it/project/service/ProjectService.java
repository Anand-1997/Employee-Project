package com.ideas2it.project.service;

import java.util.List;

import com.ideas2it.project.model.Project;

public interface ProjectService {
	
	void insertProject(Project newProject,List<Integer> employeesId) throws Exception;
	
	Project setProjectDetails(String projectName,String dueDate, String managerName) throws Exception;
	
	void removeProject(int projectId) throws Exception;
	
	void retriveProject(int projectId) throws Exception;
	
	void listProject() throws Exception;
	
	String validateDate(String date) throws Exception;

}
