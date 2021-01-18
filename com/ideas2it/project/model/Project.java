/**
 * In this program we create the model of for an Employee clas
 * and pass the vvalues using getter and setter
 * @version 11.0.3 
 * @author Anand P
 * @since 10.12.2020
**/
package com.ideas2it.project.model;

import java.util.Set;

public class Project {
	private int projectId;
	private String projectName;
	private String dueDate;
	private String managerName;
	private String status;
	private Set Employee;

	//default constructor
	public Project() {
	}

	//argument-constructor to initialize fields  
	public Project(String name, String dueDate, String manager) {
		this.projectName = name;
		this.dueDate = dueDate;
		this.managerName = manager;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", dueDate=" + dueDate
				+ ", managerName=" + managerName + "]";
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Set getEmployee() {
		return Employee;
	}

	public void setEmployee(Set employee) {
		Employee = employee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
