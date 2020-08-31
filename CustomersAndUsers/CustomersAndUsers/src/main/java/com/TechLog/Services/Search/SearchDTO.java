package com.TechLog.Services.Search;

import java.util.List;

import com.TechLog.Entity.Customers.Customer;

public class SearchDTO {

	private List<Customer> customers;
	private Integer numberOfResult;

	public List<Customer> getCustomers() {
		return customers;
	}

	public Integer getNumberOfResult() {
		return numberOfResult;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public void setNumberOfResult(Integer numberOfResult) {
		this.numberOfResult = numberOfResult;
	}
	
}
