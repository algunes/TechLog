package com.TechLog.Users;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;

public class UserBuilder {
	
	private String firstname;
	private String lastname;
	private String department;
	private String position;
	private String role;
	
	private List<Customer> created_customers = new ArrayList<>();
	private List<Customer> updated_customers = new ArrayList<>();
	private List<Corporation> created_corporations = new ArrayList<>();
	private List<Corporation> updated_corporations = new ArrayList<>();
	private String email;
	private String telNumber;
	private String address;
	private BigDecimal totalSales;
	private LocalDate lastLogin;
	private LocalDate startDate;
	
	public UserBuilder setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	public UserBuilder setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	
	public UserBuilder setDepartment(String department) {
		this.department = department;
		return this;
	}
	
	public UserBuilder setPosition(String position) {
		this.position = position;
		return this;
	}
	
	public UserBuilder setRole(String role) {
		this.role = role;
		return this;
	}
	
	public UserBuilder setCreatedCustomers(List<Customer> created_customers) {
		this.created_customers = created_customers;
		return this;
	}
	
	public UserBuilder setUpdatedCustomers(List<Customer> updated_customers) {
		this.updated_customers = updated_customers;
		return this;
	}
	
	public UserBuilder setCreatedCorporations(List<Corporation> created_corporations) {
		this.created_corporations = created_corporations;
		return this;
	}
	
	public UserBuilder setUpdatedCorporations(List<Corporation> updated_corporations) {
		this.updated_corporations = updated_corporations;
		return this;
	}
	
	public UserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public UserBuilder setTelNumber(String telNumber) {
		this.telNumber = telNumber;
		return this;
	}
	
	public UserBuilder setAddress(String address) {
		this.address = address;
		return this;
	}
	
	public UserBuilder setTotalSales(BigDecimal totalSales) {
		this.totalSales = totalSales;
		return this;
	}
	
	public UserBuilder setLastLogin(LocalDate last_login) {
		this.lastLogin = last_login;
		return this;
	}
	
	public UserBuilder setStartDate(LocalDate startDate) {
		this.startDate = startDate;
		return this;
	}
	
	public Users build()  {
		return new Users(firstname, lastname, department, position, role,
				created_customers, updated_customers, created_corporations,
				updated_corporations, email, telNumber,address,
				totalSales, lastLogin, startDate);
	}

}
