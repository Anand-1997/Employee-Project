package com.ideas2it.project.dao;

import java.util.List;

import com.ideas2it.project.model.Project;

public interface ProjectDao {
	
	void insertProject(Project project,List <Integer> employeesId) throws Exception;
	
	void deleteProject(int id) throws Exception; 
	
	void retriveProject(int id) throws Exception;
	 
	void listProject() throws Exception;

}
