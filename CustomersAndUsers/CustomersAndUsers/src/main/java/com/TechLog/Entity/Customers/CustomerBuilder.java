package com.TechLog.Entity.Customers;

import java.time.LocalDate;
import java.util.*;

import com.TechLog.Entity.Corporations.Corporation;
import com.TechLog.Entity.Users.Users;

public class CustomerBuilder {
	
	private String firstname;
	private String lastname;
	private Corporation corporation;
	private String department;
	private String position;
	private List<String> emails = new ArrayList<>();
	private List<String> telNums = new ArrayList<>();
	private List<String> addresses = new ArrayList<>();
	private Users created_by;
	private Users updated_by;
	private LocalDate last_update;
	private LocalDate creation_date;
	
	public CustomerBuilder setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	public CustomerBuilder setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	
	public CustomerBuilder setCorporation(Corporation corporation) {
		this.corporation = corporation;
		return this;
	}
	
	public CustomerBuilder setDepartment(String department) {
		this.department = department;
		return this;
	}
	
	public CustomerBuilder setPosition(String position) {
		this.position = position;
		return this;
	}
	
	public CustomerBuilder setEmail(List<String> emails) {
		this.emails = emails;
		return this;
	}
	
	public CustomerBuilder addEmail(String email) {
		this.emails.add(email);
		return this;
	}
	
	public CustomerBuilder setTelNum(List<String> telNums) {
		this.telNums = telNums;
		return this;
	}
	
	public CustomerBuilder addTelNum(String telNum) {
		this.telNums.add(telNum);
		return this;
	}
	
	public CustomerBuilder setAddress(List<String> addresses) {
		this.addresses = addresses;
		return this;
	}
	
	public CustomerBuilder addAddress(String address) {
		this.addresses.add(address);
		return this;
	}
	
	public CustomerBuilder setCreatedBy(Users user) {
		this.created_by = user;
		return this;
	}
	
	public CustomerBuilder setUpdatedBy(Users user) {
		this.updated_by = user;
		return this;
	}
	
	public CustomerBuilder setLastUpdate(LocalDate date) {
		this.last_update = date;
		return this;
	}
	
	public CustomerBuilder setCreationDate(LocalDate date) {
		this.creation_date = date;
		return this;
	}
	
	public Customer build() {
		return new Customer(firstname, lastname, corporation, department, position,
				emails, telNums, addresses, created_by, updated_by, 
				last_update, creation_date);
	}
	
}
