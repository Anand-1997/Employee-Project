/**
 * In this program we pass the values to the service class and get
 * the values using scanner and pass the values.
 * @version 11.0.3 
 * @author Anand P
 * @since 10.12.2020
**/
package com.ideas2it.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.project.model.Project;
import com.ideas2it.project.service.ProjectService;
import com.ideas2it.project.service.ProjectServiceImpl;


/*
 * This class gives the user to perform all the
 * given CRUD operations are done in this class
 * this class will be accessed by services
 */
public class ProjectController {
	ProjectService projectService = new ProjectServiceImpl();
	Project project = new Project();
	
	/* 
     * This method consists of three parameters list for storing, 
	 * Displays different choices and user provides options and
	 * It contains switch method where when the user enters a option based 
	 * on option the cases get called 
     */
    public void projectControl() {
		int options;
		try {
			do { 
		    	System.out.println("Choose one option from the following : ");
				System.out.println("1) Insert a new project.");
				System.out.println("2) Remove an project via ID.");
				System.out.println("3) Retrive an project via ID.");
				System.out.println("4) List all projects.");
				System.out.println("5) update project.");
				System.out.println("6) Assign Project.");
				System.out.println("7) Exit.");
				Scanner scanner = new Scanner(System.in);
				options = scanner.nextInt();
				switch (options) {			
				case 1:
					getInfo();
					System.out.println("Enter the no. of employees you wish to map");
					int n = scanner.nextInt();
					int i =0;
					List<Integer> employeesId = new ArrayList<Integer>();
					for(i = 0 ; i < n ; i++)
					{
						System.out.println("Enter the employee id you wish to map into project: ");
						int id = scanner.nextInt();
						employeesId.add(id);
					}
					projectService.insertProject(project,employeesId); //Calls the insert method
					break;
				case 2:
					int projectId = getProjectId();
					projectService.removeProject(projectId); //Calls the remove method
					break;
				case 3:
					projectId = getProjectId();
					projectService.retriveProject(projectId); //Calls the retrive method
					break;
				case 4:
					projectService.listProject(); //Calls the list method
					break;
				case 5:
					updateProject();
					projectService.updateProject(project); //Calls the update method
					break;
				case 6:
					int employeeId = getEmployeeId();
					projectId = getProjectId();
					//projectService.assignEmployee(employeeId,projectId);
					break;
				case 7:
					break;
				default:
					System.out.println("Invalid Choice"); //If none of the options exits*/
				}
			} while(options!=7);
			} catch(Exception e) {
				System.out.println("Invalid entry");
			}
		}
    /* 
     * This method is used to get values for the insert method and
     * provide the neccessary inputs. 
     */
	public Project getInfo() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Project Name: ");
		String name = scanner.nextLine();
		System.out.println("Enter Due Date: ");
		String dueDate = scanner.nextLine();
		projectService.validateDate(dueDate);
		System.out.println("Enter Project Manager Name: ");
		String projectManager = scanner.nextLine();
		project = projectService.setProjectDetails(name,dueDate,projectManager);
		return project;
	}

	/*
     * This method fetches the Employee ID from user 
     */
	public int getProjectId() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the ID of an project");
		int projectId = scanner.nextInt();
		return projectId;
	}

	/* 
     * The update method is used to select a record based on the key the user 
	 * provides, finds and then updates the values 
     */
	 public Project updateProject() throws Exception {
	     System.out.println("Type ID to be modified");
	     Scanner scanner = new Scanner(System.in);
	     String id = scanner.nextLine();
         System.out.println("Modification values");
         System.out.println("Enter project Name: ");
	     String name = scanner.nextLine();
         System.out.println("Enter Due Date: ");
	     String dueDate = scanner.nextLine();
		 projectService.validateDate(dueDate);
	     System.out.println("Enter Manager name: ");
	     String managerName = scanner.nextLine();
	     int pid = Integer.parseInt(id);
	     project = projectService.setProjectDetails(name,dueDate,managerName );
	     project.setProjectId(pid);
	     return project;
    } 
	 
	/*
	 * This method fetches the Employee ID from user 
	 */
	public int getEmployeeId() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the ID of an employee");
		int employeeId = scanner.nextInt();
		return employeeId;
	}
}
