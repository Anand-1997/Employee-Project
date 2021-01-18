/**
 * In this program we pass the values to the service class and get
 * the values using scanner and pass the values.
 * @version 11.0.3 
 * @author Anand P
 * @since 10.12.2020
**/
package com.ideas2it.employee.controller;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;

import com.ideas2it.employee.service.EmployeeService;
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;

/*
 * this class gives the user to perform all the
 * given CRUD operations are done in this class
 * this class will be accessed by services
 */

public class EmployeeController {
	static EmployeeService employeeService = new EmployeeService();
	static Employee employee = new Employee();
	/* 
     * This method consists of three paramters list for storing, 
	 * Displays different choices and user provides options and
	 * It contains switch method where when the user enters a option based 
	 * on option the cases get called 
     */
	public static void employeeControl() {
		int options;
		try {
		do { 
		    System.out.println("Choose one option from the following : ");
			System.out.println("1) Insert a new employee.");
			System.out.println("2) Remove an employee via ID.");
			System.out.println("3) Retrive an employee via ID.");
			System.out.println("4) List all employees.");
			System.out.println("5) update employee.");
			System.out.println("6) Exit.");
			Scanner scanner = new Scanner(System.in);
			options = scanner.nextInt();
			switch (options) {
			case 1:
			    getInfo();
			    Address currentAddress = getEmployeeAddress();
				Address permanentAddress = getEmployeeAddress();
				EmployeeService.insertEmployee(employee,currentAddress,permanentAddress); //Calls the insert method
				break;
			case 2:
				int employeeId = getEmployeeId();
				employeeService.removeEmployee(employeeId); //Calls the remove method
				break;
			case 3:
				employeeId = getEmployeeId();
				employeeService.retriveEmployee(employeeId); //Calls the retrive method
				break;
			case 4:
			    employeeService.listEmployee(); //Calls the list method
				break;
			case 5:
				updateInfo();
			    currentAddress = getEmployeeAddress();
				permanentAddress = getEmployeeAddress();
				EmployeeService.updateEmployee(employee,currentAddress,permanentAddress);//Calls the update method
				break;
			default:
				System.out.println("Invalid Choice"); //If none of the options exits*/
			}
		} while(options!=6);
		} catch(Exception e) {
			System.out.println("Invalid entry");
		}
    }
    
    /* 
     * This method is used to get values for the insert method and
     * provide the neccessary inputs. 
     */
	public static Employee getInfo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter First Name: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter Last Name: ");
		String lastName = scanner.nextLine();
		System.out.println("Enter Date Of Birth: ");
		String dateOfBirth = scanner.nextLine();
		employeeService.validatedateOfBirth(dateOfBirth);
		System.out.println("Enter EmailID: ");
		String email = scanner.nextLine();
		employeeService.validateEmail(email);
		System.out.println("Enter phone number: ");
		String phoneNumber = scanner.nextLine();
		employeeService.validatePhoneNumber(phoneNumber);
		
		employee = employeeService.setEmployeeDetails(firstName, lastName, dateOfBirth, email, phoneNumber);
		return employee;
	}

	/*
     * This method fetches the Employee ID from user 
     */
	public static int getEmployeeId() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the ID of an employee");
		int employeeId = scanner.nextInt();
		return employeeId;
	}
	
	public static Address getEmployeeAddress() {
		Address address = new Address();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Street: ");	
		String street = scanner.nextLine();
		System.out.println("Enter Area: ");	
		String area = scanner.nextLine();
		System.out.println("Enter City: ");
		String city = scanner.nextLine();	
		System.out.println("Enter Pincode: ");	
		String pincode = scanner.nextLine();
		address = employeeService.setAddressDetails(street, area, city, pincode);
		return address;
	}
	public static Employee updateInfo() {
		System.out.println("modification Values");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Employee Id: ");
		String id = scanner.nextLine();
		System.out.println("Enter First Name: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter Last Name: ");
		String lastName = scanner.nextLine();
		System.out.println("Enter Date Of Birth: ");
		String dateOfBirth = scanner.nextLine();
		employeeService.validatedateOfBirth(dateOfBirth);
		System.out.println("Enter EmailID: ");
		String email = scanner.nextLine();
		employeeService.validateEmail(email);
		System.out.println("Enter phone number: ");
		String phoneNumber = scanner.nextLine();
		int employeeId = Integer.parseInt(id);
		employeeService.validatePhoneNumber(phoneNumber);
		employee = employeeService.setEmployeeDetails(firstName, lastName, dateOfBirth, email, phoneNumber);
		employee.setEid(employeeId);
		return employee;
	}

	/* 
     * The update method is used to select a record based on the key the user 
	 * provides, finds and then updates the values 
     */
        /*public static Employee getEmployeeDetails() {
         Employee employee = new Employee(); 
	     System.out.println("Type ID to be modified");
	     Scanner scanner = new Scanner(System.in);
	     String eid = scanner.nextLine();
         System.out.println("Modification values");
         System.out.println("Enter First Name: ");
	     String firstName = scanner.nextLine();
         System.out.println("Enter Last Name: ");
	     String lastName = scanner.nextLine();
	     System.out.println("Enter Date of birth: ");
	     String dateOfBirth = scanner.nextLine();
	     System.out.println("Enter email: ");
	     String email = scanner.nextLine();
	     System.out.println("Enter phone number: ");
	     String phoneNumber = scanner.nextLine();
         employee.setfirstName(firstName);
         employee.setlastName(lastName);
	     employee.setdateOfBirth(dateOfBirth);
	     employee.setemail(email);
	     employee.setphoneNumber(phoneNumber);
		 employeeService.updateEmployee(eid, employee); 
         return employee;
    }*/
}
