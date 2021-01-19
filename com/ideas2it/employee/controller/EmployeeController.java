/**
 * In this program we pass the values to the service class and get
 * the values using scanner and pass the values.
 * @version 11.0.3 
 * @author Anand P
 * @since 10.12.2020
**/
package com.ideas2it.employee.controller;

import java.util.Scanner;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.service.EmployeeService;

/*
 * This class gives the user to perform all the
 * given CRUD operations are done in this class
 * this class will be accessed by services
 */

public class EmployeeController {
	EmployeeService employeeService = new EmployeeService();
	Employee employee = new Employee();
	
	/* 
     * This method consists of three parameters list for storing, 
	 * Displays different choices and user provides options and
	 * It contains switch method where when the user enters a option based 
	 * on option the cases get called 
     */
	public void employeeControl() {
		int options;
		try {
			do  { 
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
					employeeService.insertEmployee(employee,currentAddress,permanentAddress); //Calls the insert method
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
					employeeService.updateEmployee(employee,currentAddress,permanentAddress);//Calls the update method
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
	public Employee getInfo() {
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
	public int getEmployeeId() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the ID of an employee");
		int employeeId = scanner.nextInt();
		return employeeId;
	}
	
    /* 
     * This method is used to get values for the Address method and
     * provide the neccessary inputs. 
     */
	public Address getEmployeeAddress() {
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
	
    /* 
     * This method is used to provide values for the update method and
     * provide the neccessary inputs. 
     */
	public  Employee updateInfo() {
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
}
