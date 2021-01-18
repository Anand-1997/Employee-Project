/**
 * In this program we create the model of for an Employee clas
 * and pass the vvalues using getter and setter
 * @version 11.0.3 
 * @author Anand P
 * @since 10.12.2020
**/
package com.ideas2it.employee.model;

import java.util.Set;

public class Employee {
	private int eid;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String email;
	private String phoneNumber;
	private String status;
	private Set Address;
	private Set Project;
	
	public Set getProject() {
		return Project;
	}

	public void setProject(Set project) {
		Project = project;
	}

	public Set getAddress() {
		return Address;
	}

	public void setAddress(Set address) {
		Address = address;
	}

	public Employee() {
	}

	public Employee(String firstName, String lastName, String phoneNumber, String email, String dateOfBirth) {
		//this.eid = eid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", email=" + email + ", phoneNumber=" + phoneNumber + ", status=" + status
				+ ", Address="
				+ Address + "]\n";
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/*
	 * public Address getCurrentAddress() { return currentAddress; }
	 * 
	 * public void setCurrentAddress(Address address) { this.currentAddress =
	 * address; }
	 * 
	 * public Address getPermanentAddress() { return permanentAddress; }
	 * 
	 * public void setPermanentAddress(Address permanentAddress) {
	 * this.permanentAddress = permanentAddress; }
	 */



	//default constructor
	/*public Employee() {
	}

	//argument-constructor to initialize fields  
	public Employee(String eid, String lastName, String firstName, String dateOfBirth, String email, String phoneNumber) {
		this.eid = eid;
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	/*public String toString() {
		return "\nEmployee" + "\n" + " Id= " + getEid() + " \t" + "First Name =  " + getFirstName() + " \t" + " Last Name = " + getLastName() + " \t" + " Date Of Birth =" + getDateOfBirth() + " \t" + " E-mail = " + getEmail() + " \t" + " phone number = " + getPhoneNumber();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEid() {
		return eid;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) { this.lastName = lastName; }

	public void setEid(String Eid) {
		this.eid = Eid;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}*/
}
