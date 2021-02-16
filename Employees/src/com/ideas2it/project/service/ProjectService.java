package com.ideas2it.project.service;

import java.util.List;

import com.ideas2it.employee.model.Employee;
import com.ideas2it.project.model.Project;

public interface ProjectService {

	/*
	 * The insert method is used to insert records based on value given by the user
	 */
	public void addProject(Project newProject) throws Exception;

	/*
	 * This method is used to pass project details required for the insert
	 * operation.
	 */
	Project setProjectDetails(String projectName, String dueDate, String managerName) throws Exception;

	
	
	/**
	 * The remove method is used to delete record based on the key the user
	 * provides, finds and then removes
	 */
	
	  public void removeProject(int projectId) throws Exception;
	  
	/* The list method is used to print the entire records */
	  
	  public List<Project> listProject() throws Exception;
	  
	  /*
	   * The update method is used to select a record based on the key the user
	   * provides, finds and then updates the values
	   */
		  
      public void updateProject(Project project) throws Exception;
		  
		  
      String validateDate(String date) throws Exception;

	public void assignEmployee(int assignProjectId, int[] employeeid);

	public Project getProject(Integer projectid);

	public List<Employee> getEmployees();

}
