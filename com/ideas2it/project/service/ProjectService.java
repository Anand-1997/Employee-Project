package com.ideas2it.project.service;

import java.util.List;

import com.ideas2it.project.model.Project;

public interface ProjectService {
	
	/* 
     * The insert method is used to insert records based on value  
	 * given by the user 
     */
	void insertProject(Project newProject,List<Integer> employeesId) throws Exception;
	
	/* 
     * This method is used to pass project details required  
	 * for the insert operation. 
     */
	Project setProjectDetails(String projectName,String dueDate, String managerName) throws Exception;
	
	/* 
     * The remove method is used to delete record based on the key the user 
	 * provides, finds and then removes 
     */
	void removeProject(int projectId) throws Exception;
	
	/*
     * The retrive method is used to display record based on the key value 
     */
	void retriveProject(int projectId) throws Exception;
	
	/* 
	 * The list method is used to print the entire records 
	 */
	void listProject() throws Exception;
	
	/* 
     * The update method is used to select a record based on the key the user 
	 * provides, finds and then updates the values 
     */
	void updateProject(Project project) throws Exception;
	
	
	
	String validateDate(String date) throws Exception;

}
