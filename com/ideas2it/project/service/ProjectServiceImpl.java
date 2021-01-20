/**
 * In this program we define the logic and provide
 * the instructions neccessary for each method.
 * @version 11.0.3 
 * @author Anand P
 * @since 19.12.2020
**/
package com.ideas2it.project.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

import com.ideas2it.project.model.Project;
import com.ideas2it.project.dao.ProjectDao;
import com.ideas2it.project.dao.ProjectDaoImpl;

/*
 * This class is used to provide all the services of
 * all CRUD operations are done in this class
 * this class will be accessed by services
 */
public class ProjectServiceImpl implements ProjectService {
	ProjectDao projectDao = new ProjectDaoImpl();

	/* 
     * The insert method is used to insert records based on value  
	 * given by the user 
     */
	public void insertProject(Project newProject,List<Integer> employeesId) throws Exception {
		projectDao.insertProject(newProject,employeesId);
	}
	
	/* 
     * This method is used to pass project details required  
	 * for the insert operation. 
     */
	public Project setProjectDetails(String projectName,String dueDate, String managerName){
		Project project = new Project(projectName,  dueDate, managerName);
		return project;
	}
	
	/* 
     * The remove method is used to delete record based on the key the user 
	 * provides, finds and then removes 
     */
	public void removeProject(int projectId) throws Exception {
		projectDao.deleteProject(projectId);        
	}

	/*
     * The retrive method is used to display record based on the key value 
     */
	public void retriveProject(int projectId) throws Exception {
		projectDao.retriveProject(projectId);
	}

	/* 
	 * The list method is used to print the entire records 
	 */

	public void listProject() throws Exception {
		projectDao.listProject();
	}
	
	/* 
     * The update method is used to select a record based on the key the user 
	 * provides, finds and then updates the values 
     */
	/*public void updateProject(Project project){
		System.out.println("Inserted");
        employeeDao.updateProject(project);
	}*/
	
	 /* 
     * This method validates the given date of project  
	 * with the given format and returns the date.
     */
	public String validateDate(String date) {
		String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
		//Creating a pattern object
		Pattern pattern = Pattern.compile(regex);
		//Matching the compiled pattern in the String
		Matcher matcher = pattern.matcher(date);
		if (matcher.matches()) {
			System.out.println("Date is valid");

		} else {
			System.out.println("Date is not valid");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter a valid DOB: ");
			date = scanner.nextLine();
			validateDate(date);
		}
		return date;
	}
}
