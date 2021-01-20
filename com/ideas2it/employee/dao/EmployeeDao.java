package com.ideas2it.employee.dao;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;

public interface EmployeeDao{
	
	void insertEmployee(Employee employee,Address currentAddress, Address permanentAddress) throws Exception;
	
	void deleteEmployee(int id) throws Exception;
	
	void retriveEmployee(int id) throws Exception;
	
	void listEmployee() throws Exception;
	
	void updateEmployee(Employee employee,Address currentAddress, Address permanentAddress) throws Exception;

}
