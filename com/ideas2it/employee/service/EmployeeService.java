package com.ideas2it.employee.service;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;

public interface EmployeeService {
	
	void insertEmployee(Employee employee,Address currentAddress, Address permanentAddress) throws Exception;
	
	Employee setEmployeeDetails(String firstName,String lastName, String phoneNumber, String email, String dateOfBirth) throws Exception;
	
	Address setAddressDetails(String street,String city, String area, String pincode) throws Exception;
	
	void removeEmployee(int employeeId) throws Exception;
	
	void retriveEmployee(int employeeId) throws Exception;
	
	void listEmployee() throws Exception;
	
	void updateEmployee(Employee employee,Address currentAddress, Address permanentAddress) throws Exception;
	
	String validatedateOfBirth(String DOB) throws Exception;
	
	String validateEmail(String email) throws Exception;
	
	String validatePhoneNumber(String phoneNumber) throws Exception;

}
