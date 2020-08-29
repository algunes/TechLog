package com.TechLog.Entity.Corporations;

import java.util.ArrayList;
import java.util.List;

import com.TechLog.Entity.Customers.Customer;
import com.TechLog.Entity.Users.Users;

public class CorporationBuilder {
	
	private String name;
	private String sector;
	private boolean isActive;
	private List<Customer> customers = new ArrayList<>();
	private Users created_by;
	
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
	
	public CorporationBuilder setCreated_by(Users created_by) {
		this.created_by =created_by;
		return this;
	}
	
	public Corporation build() {
		return new Corporation(name, sector, isActive, customers, created_by);
	}
	
}
