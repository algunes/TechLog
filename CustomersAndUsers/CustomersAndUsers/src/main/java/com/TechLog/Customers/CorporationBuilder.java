package com.TechLog.Customers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.TechLog.Users.Users;

public class CorporationBuilder {
	
	private String name;
	private String sector;
	private boolean isActive;
	private List<Customer> customers = new ArrayList<>();
	private Users created_by;
	private Users updated_by;
	private LocalDate last_update = LocalDate.now();
	private LocalDate creation_date;
	
	public CorporationBuilder setName(String name) {
		this.name= name;
		return this;
	}
	
	public CorporationBuilder setSector(String sector) {
		this.sector = sector;
		return this;
	}
	
	public CorporationBuilder setIsActive(Boolean isActive) {
		this.isActive = isActive;
		return this;
	}
	
//	public CorporationBuilder setCustomers(Customer customer) {
//		this.customers.add(customer);
//		return this;
//	}
	
	public CorporationBuilder setCreated_by(Users created_by) {
		this.created_by =created_by;
		this.updated_by = created_by;
		return this;
	}
	
	public CorporationBuilder setUpdated_by(Users updated_by) {
		this.updated_by = updated_by;
		return this;
	}
	
	public CorporationBuilder setCreationDate(LocalDate creation_date) {
		this.creation_date = creation_date;
		this.last_update = creation_date;
		return this;
	}
	
	public CorporationBuilder setLastUpdate(LocalDate last_update) {
		this.last_update = last_update;
		return this;
	}
	
	public Corporation build() {
		return new Corporation(name, sector, isActive, customers, created_by,
				updated_by, last_update, creation_date);
	}
	
}
