package com.ideas2it.project.dao;

import java.util.List;

import com.ideas2it.employee.model.Employee;
import com.ideas2it.project.model.Project;

public interface ProjectDao {

	/*
	 * Used to insert the values into the database given by the values provided by
	 * user
	 * 
	 * @param it gets the parameter of Employees type to create the person
	 */
	void addProject(Project project) throws Exception;

	/*
	 * Used to delete the values into the database given by the id provided by user
	 * 
	 * @param it gets the id of Employees for deleting
	 */
	
	
	  public void deleteProject(int id) throws Exception;
	  
	  
	 /** Used to retrive the values into the database given by the id provided by user
	 * 
	 * @param it gets the id of Employees for retriving
	 * 
	 *           void retriveProject(int id) throws Exception;
	 * @return 
	 */	  
	  
	  /*Used to print the values from the database given provided by user*/
	  
	  public List<Project> listProject() throws Exception;
	  
		
	  /* Used to update the values from the database given provided by user */
		  
	  public void updateProject(Project project) throws Exception;

	public void assignEmployee(int assignProjectId, int[] employeeid);

	public Project getProject(Integer projectid);

	public List<Employee> getEmployees();
		 
}
