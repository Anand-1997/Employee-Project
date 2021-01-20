package com.ideas2it.project.dao;

import java.util.List;

import com.ideas2it.project.model.Project;

public interface ProjectDao {
	
	/*
     * Used to insert the values into the database given
     * by the values provided by user
     * @param it gets the parameter of Employees type to create the person
     */   
	void insertProject(Project project,List <Integer> employeesId) throws Exception;
	
	/*
     * Used to delete the values into the database given
     * by the id provided by user
     * @param it gets the id of Employees for deleting
     */   
	void deleteProject(int id) throws Exception; 
	
	/*
     * Used to retrive the values into the database given
     * by the id provided by user
     * @param it gets the id of Employees for retriving
     */
	void retriveProject(int id) throws Exception;
	 
	/*
     * Used to print the values from the database given
     * provided by user
     */
	void listProject() throws Exception;
	
	/*
     * Used to update the values from the database given
     * provided by user
     */
	void updateProject(Project project) throws Exception; 

}
