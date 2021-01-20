/**
 * In this program we define the logic and provide
 * the instructions neccessary for each method.
 * @version 11.0.3 
 * @author Anand P
 * @since 10.12.2020
**/
package com.ideas2it.employee.service;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;

/*
 * this class is used to provide all the services of
 * all CRUD operations are done in this class
 * this class will be accessed by services
 */
public interface EmployeeService {
	
	/* 
     * The insert method is used to insert records based on value  
	 * given by the user 
     */
	void insertEmployee(Employee employee,Address currentAddress, Address permanentAddress) throws Exception;
	
	/* 
     * This method is used to pass employee details required  
	 * for the insert operation. 
     */
	Employee setEmployeeDetails(String firstName,String lastName, String phoneNumber, String email, String dateOfBirth) throws Exception;
	
	/* 
     * This method is used to pass address details required  
	 * for the insert operation. 
     */
	Address setAddressDetails(String street,String city, String area, String pincode) throws Exception;
	
	/* 
     * The remove method is used to delete record based on the key the user 
	 * provides, finds and then removes 
     */
	void removeEmployee(int employeeId) throws Exception;
	
	/*
     * The retrive method is used to display record based on the key value 
     */
	void retriveEmployee(int employeeId) throws Exception;
	
	/* 
	 * The list method is used to print the entire records 
	 */
	void listEmployee() throws Exception;
	
	/* 
     * The update method is used to select a record based on the key the user 
	 * provides, finds and then updates the values 
     */
	void updateEmployee(Employee employee,Address currentAddress, Address permanentAddress) throws Exception;
	
	/* 
     * The assign method is used to select a record based on the key the user 
	 * provides, finds and then assigns the values 
     */
	void assignProject(int employeeId, int projectId) throws Exception;
	
	/* 
     * This method validates the given date of birth  
	 * with the given format and return date of birth 
     */
	String validatedateOfBirth(String DOB) throws Exception;
	
	/* 
     * This method validates the given Email 
	 * with the given format and return Email 
     */
	String validateEmail(String email) throws Exception;
	
	/* 
     * This method validates the given Phone Number  
	 * with the given format and return Phone Number
     */
	String validatePhoneNumber(String phoneNumber) throws Exception;

}
