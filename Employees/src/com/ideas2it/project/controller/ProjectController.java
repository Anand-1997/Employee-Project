/**
 * In this program we pass the values to the service class and get
 * the values using scanner and pass the values.
 * @version 11.0.3 
 * @author Anand P
 * @since 10.12.2020
**/
package com.ideas2it.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ideas2it.employee.model.Employee;
import com.ideas2it.project.model.Project;
import com.ideas2it.project.service.ProjectService;
import com.ideas2it.project.service.ProjectServiceImpl;


/*
 * This class gives the user to perform all the
 * given CRUD operations are done in this class
 * this class will be accessed by services
 */
public class ProjectController extends HttpServlet {
	ProjectService projectService = new ProjectServiceImpl();
	Project project = new Project();
	int updateId = 0;
	int assignProjectId = 0;
	List <Employee> employeeList = new ArrayList<Employee>();
	/*
	 * Employee employees = new Employee();
	 * 
	 * 
	 * public ProjectController() { employees.setEid(1);
	 * employees.setFirstName("Anand"); employeeList.add(employees); }
	 */
	
	/* 
     * This method consists of three parameters list for storing, 
	 * Displays different choices and user provides options and
	 * It contains switch method where when the user enters a option based 
	 * on option the cases get called 
     */
	 public void doPost(HttpServletRequest request, HttpServletResponse response) 
			    throws IOException, ServletException {
			        switch(request.getServletPath()) {
			            case "/addProject" :
			                insertProject(request,response);
			                break;
						
						  case "/updateProject" : 
							  updateProject(request,response); 
							  break; 
						 case "/deleteProject" : 
							 deleteProject(request,response); 
							 break;
						 case "/getUpdateId" : 
							 getUpdateId(request,response); 
							 break;
						 case "/getAssignProjectId": 
							  getEmployees(request, response);
							  getAssignProjectId(request, response);
							  break;
						  case "/assignEmployee": 
							  assignEmployee(request, response); 
							  break;
			        }
			    }
			    
			    /**
			     * Handles all the get requests from the server and calls the 
			     * corresponding methods 
			     * @param request contains the url path to the servlet through which the 
			     *        corresponding method is called
			     */
				
				  public void doGet(HttpServletRequest request, HttpServletResponse response)
						  	throws IOException, ServletException { 
					  			switch(request.getServletPath()) {
					  				case "/listProjects" : 
					  					listProjects(request,response);
					  				break; 
								/*
								 * case "/getproject" : getproject(request,response); break;
								 */ 
					  			} 
					  		}
				 

			    /**
			     * Gets the project details from the user in jsp page and sets it the 
			     * project object which is added to the projects list
			     * @param request contains the project details to be added to the object
			     */
			    public void insertProject(HttpServletRequest request, HttpServletResponse response)
			    throws IOException, ServletException {
			        try {
			            //Project project = projectService.generateId();
			        	//Project project = new Project();
			            project.setProjectName(request.getParameter("projectName"));
			            project.setDueDate(request.getParameter("dueDate"));
			            project.setManagerName(request.getParameter("managerName"));
			            project.setStatus("true");
			            projectService.addProject(project);
			            //getAllprojects(request,response);
			        } catch (Exception exception) {
			            request.setAttribute("error", exception);
			            RequestDispatcher rd = request.getRequestDispatcher
			               ("/ErrorPage.jsp"); 
			            rd.forward(request, response);
			        }
			    }
			    /**
			     * Lists the project details from the user in jsp page and sets it the 
			     * project object which is added to the projects list
			     * @param request contains the project details to be listed
			     */
			    public void listProjects(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException { 
					/*
					 * response.setContentType("text/html"); PrintWriter out = response.getWriter();
					 */
			         try{
			         List<Project> projects = projectService.listProject();
			         System.out.println(projects);
			         request.setAttribute("projects", projects);
			         RequestDispatcher dispatcher = request.getRequestDispatcher("ListProjects.jsp");
			         dispatcher.forward(request, response); 
			         
			         } catch (Exception e) {
			             System.out.println(e.getMessage() + e);
			         }
			    }
			    
			    public void getUpdateId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			    	String id = request.getParameter("projectId");
		    		Integer projectid = Integer.parseInt(id);
		    		Project projectToBeUpdated = projectService.getProject(projectid);
		    		System.out.println(projectToBeUpdated);
		    		updateId = projectid;
		    		request.getSession().setAttribute("projectToBeUpdated", projectToBeUpdated);
					RequestDispatcher rd = request.getRequestDispatcher("UpdateProject.jsp");
					rd.forward(request, response);	
			    }
			    
			    public void updateProject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { 
			    	try { 
			    		  Project project = new Project();
			    		  project.setProjectName(request.getParameter("projectName"));
			    		  project.setDueDate(request.getParameter("dueDate"));
			    		  project.setManagerName(request.getParameter("managerName"));
			    		  project.setProjectId(updateId);
			    		  projectService.updateProject(project); 
			    		  //getAllemployees(request,response);
			    		  } catch(Exception exception) {
			    		  System.out.println(exception.getMessage()); 
			    		  } 
			    }
			    
			    private void deleteProject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { 
			    	try { 
			    		String id = request.getParameter("projectId");
			    		System.out.println("Inside delete"+ id);
			    		Integer projectid = Integer.parseInt(id);
						/*
						 * employee employee = employeeService.getemployee(request.getParameter("Id"));
						 * employeeService.deleteemployee(employee); getAllemployees(request,response);
						 */
			    		projectService.removeProject(projectid);
						/*
						 * RequestDispatcher rd = request.getRequestDispatcher("ListProjects.jsp");
						 * rd.forward(request, response);
						 */
						} catch(Exception exception) {
						  System.out.println(exception.getMessage()); 
						} 
			    	}
			    public void getAssignProjectId(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException { 
					  try {
						  String id = request.getParameter("projectId"); 
						  Integer projectid = Integer.parseInt(id);
						  System.out.println(projectid);
						  assignProjectId = projectid; 
						  RequestDispatcher rd = request.getRequestDispatcher("AssignEmployee.jsp");
						  rd.forward(request,response);
							 
						  } catch(Exception exception) { 
							  System.out.println(exception.getMessage()); 
						  }
				  } 
					
			    public void assignEmployee(HttpServletRequest request, HttpServletResponse response) { 
						  String id[] = request.getParameterValues("emp"); 
						  int employeeid [] = new int[10];
						  int index = 0;
						  for(String empid : id) {
							  Integer emplId = Integer.parseInt(empid);
							  employeeid[index] = emplId;
							  index++;
						  }
						  projectService.assignEmployee(assignProjectId,employeeid); 
					  }
				public void getEmployees(HttpServletRequest request, HttpServletResponse response)
					{
					try{
				         List<Employee> employees = projectService.getEmployees();
				         System.out.println("From Database" + employees);
				         request.setAttribute("employees", employees);
				         employeeList = employees;
				         
							/*
							 * RequestDispatcher dispatcher =
							 * request.getRequestDispatcher("ListProjects.jsp"); dispatcher.forward(request,
							 * response);
							 */
				         
				         } catch (Exception e) {
				             System.out.println(e.getMessage() + e);
				         }
					}
}
