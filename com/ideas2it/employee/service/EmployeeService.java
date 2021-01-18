/**
 * In this program we define the logic and provide
 * the instructions neccessary for each method.
 * @version 11.0.3 
 * @author Anand P
 * @since 10.12.2020
**/
package com.ideas2it.employee.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.dao.EmployeeDao;


/*
 * this class is used to provide all the services of
 * all CRUD operations are done in this class
 * this class will be accessed by services
 */

public class EmployeeService {
    private static HashMap<String, Employee> employeesByKey = new HashMap<String, Employee> ();
    static EmployeeDao employeeDao = new EmployeeDao();

	/* 
     * The insert method is used to insert records based on value  
	 * given by the user 
     */
	public static void insertEmployee(Employee employee,Address currentAddress, Address permanentAddress) {
		System.out.println("Inserted");
		//employeesByKey.put(employee.getEid(), employee);
		System.out.println(employee);
        employeeDao.insertEmployee(employee,currentAddress,permanentAddress);
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
	public static void removeEmployee(int employeeId) {
		employeeDao.deleteEmployee(employeeId);        
	}

	/*
     * The retrive method is used to display record based on the key value 
     */
	public static void retriveEmployee(int employeeId) {
		employeeDao.retriveEmployee(employeeId);
	}

	/* 
	 * The list method is used to print the entire records 
	 */

	public static void listEmployee() {
		employeeDao.listEmployee();
	}
	
	/* 
     * The update method is used to select a record based on the key the user 
	 * provides, finds and then updates the values 
     */
	public static void updateEmployee(Employee employee,Address currentAddress, Address permanentAddress) {
		System.out.println("Inserted");
		System.out.println(employee);
        employeeDao.updateEmployee(employee,currentAddress,permanentAddress);
	}
    /* 
     * This method validates the given date of birth  
	 * with the given format and return date of birth 
     */
	public static String validatedateOfBirth(String DOB) {
		String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
		//Creating a pattern object
		Pattern pattern = Pattern.compile(regex);
		//Matching the compiled pattern in the String
		Matcher matcher = pattern.matcher(DOB);
		if (matcher.matches()) {
			System.out.println("Date is valid");

		} else {
			System.out.println("Date is not valid");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter a valid DOB: ");
			DOB = scanner.nextLine();
			validatedateOfBirth(DOB);
		}
		return DOB;
	}

    /* 
     * This method validates the given Email 
	 * with the given format and return Email 
     */
	public static String validateEmail(String email) {
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		//Creating a pattern object
		Pattern pattern = Pattern.compile(regex);
		//Creating a Matcher object
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			System.out.println("Given EmailID is valid");
		} else {
			System.out.println("Given EmailID is not valid");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter a valid EmailID: ");
			email = scanner.nextLine();
			validateEmail(email);
		}
		return email;
	}

    /* 
     * This method validates the given Phone Number  
	 * with the given format and return Phone Number
     */
	public static String validatePhoneNumber(String phoneNumber) {
		String regex = "\\d{10}";
		//Creating a pattern object
		Pattern pattern = Pattern.compile(regex);
		//Creating a Matcher object
		Matcher matcher = pattern.matcher(phoneNumber);
		if (matcher.matches()) {
			System.out.println("Given phone number is valid");
		} else {
			System.out.println("Given phone number is not valid ");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter a valid phone number: ");
			phoneNumber = scanner.nextLine();
			validatePhoneNumber(phoneNumber);
		}
		return phoneNumber;
	}	
}
