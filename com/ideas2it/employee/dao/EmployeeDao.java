/**
 * In this program we define the DAO layer and
 * the instructions neccessary for each method.
 * @version 11.0.3 
 * @author Anand P
 * @since 17.12.2020
**/
package com.ideas2it.employee.dao;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;

/*
 * This class contains the list of Employees and the details of Employees
 * all CRUD operations are done in this class
 * this class will be accessed by services
 */
public interface EmployeeDao{
	
	/*
     * Used to insert the values into the database given
     * by the values provided by user
     * @param it gets the parameter of Employees type to create the person
     * @param it gets the parameter of Address to create currentAddress
     * @param it gets the parameter of Address to create permanentAddress
     */   
	void insertEmployee(Employee employee,Address currentAddress, Address permanentAddress) throws Exception;
	
	/*
     * Used to delete the values into the database given
     * by the id provided by user
     * @param it gets the id of Employees for deleting
     */   
	void deleteEmployee(int id) throws Exception;
	
	 /*
     * Used to retrive the values into the database given
     * by the id provided by user
     * @param it gets the id of Employees for retriving
     */
	void retriveEmployee(int id) throws Exception;
	
	/*
     * Used to print the values from the database given
     * provided by user
     */
	void listEmployee() throws Exception;
	
	/*
     * Used to update the values from the database given
     * provided by user
     */
	void updateEmployee(Employee employee,Address currentAddress, Address permanentAddress) throws Exception;
	
	/*
     * Used to assign the values from the database given
     * provided by user
     */
	void assignProject(int employeeId, int projectId) throws Exception;
}
