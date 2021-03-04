/**
 * In this program we pass the values to the service class and get
 * the values using scanner and pass the values.
 * @version 11.0.3 
 * @author Anand P
 * @since 10.12.2020
**/
package com.ideas2it.employee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.service.EmployeeService;
import com.ideas2it.employee.service.EmployeeServiceImpl;
import com.ideas2it.project.model.Project;

/*
 * This class gives the user to perform all the
 * given CRUD operations are done in this class
 * this class will be accessed by services
 */
@Controller
public class EmployeeController extends HttpServlet {
	
	private static EmployeeService employeeService = new EmployeeServiceImpl();
	
	@RequestMapping("/addEmployee")
	public ModelAndView insertEmployee(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("employee")Employee employee) throws IOException, ServletException { 
		ModelAndView model = new ModelAndView();
		try { 
			  //Employee employee = new Employee();
			  employee.setFirstName(request.getParameter("firstName"));
			  employee.setLastName(request.getParameter("lastName"));
			  employee.setDateOfBirth(request.getParameter("phoneNumber"));
			  employee.setEmail(request.getParameter("email"));
			  employee.setPhoneNumber(request.getParameter("dateOfBirth"));
			  employee.setStatus("Not Confirmed"); Address currentAddress = new Address();
			  currentAddress.setStreet(request.getParameter("currentStreet"));
			  currentAddress.setArea(request.getParameter("currentArea"));
			  currentAddress.setCity(request.getParameter("currentCity"));
			  currentAddress.setPincode(request.getParameter("currentPincode")); Address
			  permanentAddress = new Address();
			  permanentAddress.setStreet(request.getParameter("permanentStreet"));
			  permanentAddress.setArea(request.getParameter("permanentArea"));
			  permanentAddress.setCity(request.getParameter("permanentCity"));
			  permanentAddress.setPincode(request.getParameter("permanentPincode"));
			  System.out.println(currentAddress); System.out.println(permanentAddress); Set
			  <Address> address = new HashSet<Address>(); address.add(currentAddress);
			  address.add(permanentAddress); employee.setAddress(address);
			  permanentAddress.setEmployee(employee); currentAddress.setEmployee(employee);
			  System.out.println(employee);
			  employeeService.insertEmployee(employee,currentAddress,permanentAddress); 
			  model.addObject("message", "Employee Added Successfully");
			  
			  }
			  catch (Exception exception) { 
				  //request.setAttribute("error", exception);
				  exception.printStackTrace(); 
				  //RequestDispatcher rd = request.getRequestDispatcher("/project/ErrorPage.jsp"); 
				  //rd.forward(request,response); } }
			  }
		return model;
	}
	
	/* Gets the list of employees from server and forwards the request, response */
	@RequestMapping("/listEmployees")
	  public ModelAndView listEmployees(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		 ModelAndView model = new ModelAndView("ListEmployees");    
		  try{ 
			  List<Employee> employees = employeeService.listEmployee(); 
		 System.out.println(employees);
		  model.addObject("employees", employees); 
		  //RequestDispatcher dispatcher = request.getRequestDispatcher("ListEmployees.jsp"); 
		  for(Employee employee :employees) { 
			  System.out.println(employee.getAddress()); 
			  Set<Address> address = employee.getAddress(); 
			  for(Address addresses : address ) {
				  System.out.println(addresses); 
				  } 
			  } 
		  //dispatcher.forward(request, response); 
		  }
		  catch (Exception e) {
			  System.out.println(e.getMessage() + e); 
			  } 
		  return model;
		  }
		
	@RequestMapping("/deleteEmployee")
		  public ModelAndView deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			  ModelAndView model = new ModelAndView();
			  try { 
				  String id = request.getParameter("eid"); 
				  System.out.println("Inside delete"+ id); 
				  Integer employeeid = Integer.parseInt(id);
				  employeeService.deleteEmployee(employeeid);
				  model.addObject("message", "Employee Deleted Successfully");
		            return model; 
				  } catch(Exception exception) {
					  System.out.println(exception.getMessage()); 
					  } 
			  return model;
			  }
	
	
	
	/*try { */
			  /*Employee employee = new Employee();
			  employee.setFirstName(request.getParameter("firstName"));
			  employee.setLastName(request.getParameter("lastName"));
			  employee.setDateOfBirth(request.getParameter("phoneNumber"));
			  employee.setEmail(request.getParameter("email"));
			  employee.setPhoneNumber(request.getParameter("dateOfBirth"));
			  employee.setStatus("Not Confirmed"); Address currentAddress = new Address();
			  currentAddress.setStreet(request.getParameter("currentStreet"));
			  currentAddress.setArea(request.getParameter("currentArea"));
			  currentAddress.setCity(request.getParameter("currentCity"));
			  currentAddress.setPincode(request.getParameter("currentPincode")); Address
			  permanentAddress = new Address();
			  permanentAddress.setStreet(request.getParameter("permanentStreet"));
			  permanentAddress.setArea(request.getParameter("permanentArea"));
			  permanentAddress.setCity(request.getParameter("permanentCity"));
			  permanentAddress.setPincode(request.getParameter("permanentPincode"));
			  System.out.println(currentAddress); System.out.println(permanentAddress); Set
			  <Address> address = new HashSet<Address>(); address.add(currentAddress);
			  address.add(permanentAddress); employee.setAddress(address);
			  permanentAddress.setEmployee(employee); currentAddress.setEmployee(employee);
			  System.out.println(employee);
			  employeeService.insertEmployee(employee,currentAddress,permanentAddress); 
			  }
			  catch (Exception exception) { 
				  //request.setAttribute("error", exception);
				  exception.printStackTrace(); 
				  //RequestDispatcher rd = request.getRequestDispatcher("/project/ErrorPage.jsp"); 
				  //rd.forward(request,response); } }
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * EmployeeService employeeService = new EmployeeServiceImpl(); Scanner scanner
	 * = new Scanner(System.in); int updateId = 0; int assignEmployeeId = 0; List
	 * <Project> projectList = new ArrayList<Project>();
	 * 
	 *//**
		 * Handles all the post requests from the server and calls the corresponding
		 * methods
		 */
	/*
	 * public void doPost(HttpServletRequest request, HttpServletResponse response)
	 * throws IOException, ServletException { switch (request.getServletPath()) {
	 * case "/addEmployee": insertEmployee(request, response); break; case
	 * "/deleteEmployee": deleteEmployee(request, response); break; case
	 * "/updateEmployee": updateEmployee(request, response); break; case
	 * "/getEmployeeId": getEmployeeId(request, response); break;
	 * 
	 * case "/getAssignEmployeeId": getProjects(request, response);
	 * getAssignEmployeeId(request, response); break; case "/assignProject":
	 * assignProject(request, response); break;
	 * 
	 * } }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 *//**
		 * Handles all the get requests from the server and calls the corresponding
		 * methods
		 */
	/*
	 * public void doGet(HttpServletRequest request, HttpServletResponse response)
	 * throws IOException, ServletException { switch(request.getServletPath()) {
	 * case "/listEmployees" : listEmployees(request,response); break; } }
	 * 
	 *//**
		 * Gets the employee details from the user in jsp page and sets it the employee
		 * object which is added to the employees list
		 */
	/*
	 * private void insertEmployee(HttpServletRequest request, HttpServletResponse
	 * response) throws IOException, ServletException { try { //Employee employee =
	 * employeeService.generateId(); Employee employee = new Employee();
	 * employee.setFirstName(request.getParameter("firstName"));
	 * employee.setLastName(request.getParameter("lastName"));
	 * employee.setDateOfBirth(request.getParameter("phoneNumber"));
	 * employee.setEmail(request.getParameter("email"));
	 * employee.setPhoneNumber(request.getParameter("dateOfBirth"));
	 * employee.setStatus("Not Confirmed"); Address currentAddress = new Address();
	 * currentAddress.setStreet(request.getParameter("currentStreet"));
	 * currentAddress.setArea(request.getParameter("currentArea"));
	 * currentAddress.setCity(request.getParameter("currentCity"));
	 * currentAddress.setPincode(request.getParameter("currentPincode")); Address
	 * permanentAddress = new Address();
	 * permanentAddress.setStreet(request.getParameter("permanentStreet"));
	 * permanentAddress.setArea(request.getParameter("permanentArea"));
	 * permanentAddress.setCity(request.getParameter("permanentCity"));
	 * permanentAddress.setPincode(request.getParameter("permanentPincode"));
	 * System.out.println(currentAddress); System.out.println(permanentAddress); Set
	 * <Address> address = new HashSet<Address>(); address.add(currentAddress);
	 * address.add(permanentAddress); employee.setAddress(address);
	 * permanentAddress.setEmployee(employee); currentAddress.setEmployee(employee);
	 * System.out.println(employee);
	 * employeeService.insertEmployee(employee,currentAddress,permanentAddress); }
	 * catch (Exception exception) { //request.setAttribute("error", exception);
	 * exception.printStackTrace(); //RequestDispatcher rd =
	 * request.getRequestDispatcher("/project/ErrorPage.jsp"); //rd.forward(request,
	 * response); } }
	 * 
	 * Gets the list of employees from server and forwards the request, response
	 * public void listEmployees(HttpServletRequest request,HttpServletResponse
	 * response) throws IOException, ServletException { try{ List<Employee>
	 * employees = employeeService.listEmployee(); System.out.println(employees);
	 * request.setAttribute("employees", employees); RequestDispatcher dispatcher =
	 * request.getRequestDispatcher("ListEmployees.jsp"); for(Employee employee :
	 * employees) { //System.out.println(employee.getAddress()); Set<Address>
	 * address = employee.getAddress(); for(Address addresses : address ) {
	 * System.out.println(addresses); } } dispatcher.forward(request, response); }
	 * catch (Exception e) { System.out.println(e.getMessage() + e); } }
	 * 
	 * 
	 * public void updateEmployee(HttpServletRequest request, HttpServletResponse
	 * response) throws IOException, ServletException { try {
	 * 
	 * Employee employee = new Employee();
	 * employee.setFirstName(request.getParameter("firstName"));
	 * employee.setLastName(request.getParameter("lastName"));
	 * employee.setDateOfBirth(request.getParameter("phoneNumber"));
	 * employee.setEmail(request.getParameter("email"));
	 * employee.setPhoneNumber(request.getParameter("dateOfBirth"));
	 * employee.setStatus("Not Confirmed"); Address currentAddress = new Address();
	 * currentAddress.setStreet(request.getParameter("currentStreet"));
	 * currentAddress.setArea(request.getParameter("currentArea"));
	 * currentAddress.setCity(request.getParameter("currentCity"));
	 * currentAddress.setPincode(request.getParameter("currentPincode")); Address
	 * permanentAddress = new Address();
	 * permanentAddress.setStreet(request.getParameter("permanentStreet"));
	 * permanentAddress.setArea(request.getParameter("permanentArea"));
	 * permanentAddress.setCity(request.getParameter("permanentCity"));
	 * permanentAddress.setPincode(request.getParameter("permanentPincode"));
	 * System.out.println(currentAddress); System.out.println(permanentAddress); Set
	 * <Address> address = new HashSet<Address>(); address.add(currentAddress);
	 * address.add(permanentAddress); employee.setAddress(address);
	 * permanentAddress.setEmployee(employee); currentAddress.setEmployee(employee);
	 * employee.setEid(updateId); System.out.println(employee);
	 * employeeService.updateEmployee(employee,currentAddress,permanentAddress);
	 * 
	 * } catch(Exception exception) { System.out.println(exception.getMessage()); }
	 * } public void getEmployeeId(HttpServletRequest request, HttpServletResponse
	 * response) throws IOException, ServletException { String id =
	 * request.getParameter("eid"); Integer employeeid = Integer.parseInt(id);
	 * Employee employeeToBeUpdated = employeeService.getEmployee(employeeid);
	 * updateId = employeeid;
	 * request.getSession().setAttribute("employeeToBeUpdated",
	 * employeeToBeUpdated); RequestDispatcher rd =
	 * request.getRequestDispatcher("UpdateEmployees.jsp"); rd.forward(request,
	 * response);
	 * 
	 * }
	 * 
	 * 
	 *//**
		 * Soft deletes the employee from the list of employees by geting the object
		 * from the entered employee id
		 *//*
			 * public void deleteEmployee(HttpServletRequest request, HttpServletResponse
			 * response) throws IOException, ServletException { try { String id =
			 * request.getParameter("eid"); System.out.println("Inside delete"+ id); Integer
			 * employeeid = Integer.parseInt(id);
			 * employeeService.deleteEmployee(employeeid); } catch(Exception exception) {
			 * System.out.println(exception.getMessage()); } }
			 * 
			 * public void getAssignEmployeeId(HttpServletRequest
			 * request,HttpServletResponse response) throws IOException, ServletException {
			 * try { String id = request.getParameter("eid"); Integer employeeid =
			 * Integer.parseInt(id); System.out.println(employeeid); assignEmployeeId =
			 * employeeid; RequestDispatcher rd =
			 * request.getRequestDispatcher("AssignProject.jsp");
			 * rd.forward(request,response);
			 * 
			 * } catch(Exception exception) { System.out.println(exception.getMessage()); }
			 * }
			 * 
			 * public void assignProject(HttpServletRequest request, HttpServletResponse
			 * response) { String id[] = request.getParameterValues("pro"); int projectid []
			 * = new int[10]; int index = 0; for(String proid : id) { Integer projId =
			 * Integer.parseInt(proid); projectid[index] = projId; index++; }
			 * employeeService.assignProject(assignEmployeeId,projectid); } public void
			 * getProjects(HttpServletRequest request, HttpServletResponse response) { try{
			 * List<Project> projects = employeeService.getProjects();
			 * System.out.println("From Database" + projects);
			 * request.setAttribute("projects", projects); projectList = projects;
			 * 
			 * 
			 * RequestDispatcher dispatcher =
			 * request.getRequestDispatcher("ListProjects.jsp"); dispatcher.forward(request,
			 * response);
			 * 
			 * 
			 * } catch (Exception e) { System.out.println(e.getMessage() + e); } }
			 */

}
