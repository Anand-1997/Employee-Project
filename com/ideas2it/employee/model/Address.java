/**
 * In this program we create the address of for an Employee class
 * and pass the vvalues using getter and setter
 * @version 11.0.3 
 * @author Anand P
 * @since 10.12.2020
**/
package com.ideas2it.employee.model;

/*
 * This is a POJO class, where it gets Address details of Employee
 * and also sets all the details of Employee.
 */
public class Address {
	private String addressId;
	private String street;
	private String area;
	private String city;
	private String pincode;
	private Employee employee;

	//Default Constructor
	public Address() {}
	
	//Parameterized Constructor
	public Address(String street, String area, String city, String pincode) {
		super();
		this.street = street;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", area=" + area + ", city=" + city
				+ ", pincode=" + pincode + "]";
	}
	

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
}
