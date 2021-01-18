/**
 * In this program we define the logic and provide
 * the instructions neccessary for each method.
 * @version 11.0.3 
 * @author Anand P
 * @since 19.12.2020
**/
package com.ideas2it.project.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.ideas2it.project.model.Project;
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.project.dao.ProjectDao;

public class ProjectService {

	private static HashMap<String, Project> projectsByKey = new HashMap<String, Project> ();
	static ProjectDao projectDao = new ProjectDao();

	/* 
     * The insert method is used to insert records based on value  
	 * given by the user 
     */
	public void insertProject(Project newProject,int id) {
		System.out.println("Inserted");
		//projectsByKey.put(newProject.getprojectId(), newProject);
		projectDao.insertProject(newProject,id);
	}
	public static Project setProjectDetails(String projectName,String dueDate, String managerName){
		Project project = new Project(projectName,  dueDate, managerName);
		return project;
	}
	
	/* 
     * This method is used to pass employee details required  
	 * for the insert operation. 
     */
	public static Employee setEmployeeDetails(String firstName,String lastName, String phoneNumber, String email, String dateOfBirth){
		Employee employee = new Employee(firstName,  lastName, dateOfBirth, email, phoneNumber);
		return employee;
	}
	
	/* 
     * This method is used to pass address details required  
	 * for the insert operation. 
     */
	public static Address setAddressDetails(String street,String city, String area, String pincode){
		Address address = new Address(street,  city, area, pincode);
		return address;
	}

	/* 
     * The remove method is used to delete record based on the key the user 
	 * provides, finds and then removes 
     */
	public static void removeProject(int projectId) {
		projectDao.deleteProject(projectId);        
	}

	/*
     * The retrive method is used to display record based on the key value 
     */
	public static void retriveProject(int projectId) {
		projectDao.retriveProject(projectId);
	}

	/* 
	 * The list method is used to print the entire records 
	 */

	public static void listProject() {
		projectDao.listProject();
	}
	
	/* 
     * The update method is used to select a record based on the key the user 
	 * provides, finds and then updates the values 
     */
	/*public static void updateProject(Project project){
		System.out.println("Inserted");
        employeeDao.updateProject(project);
	}*/


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
