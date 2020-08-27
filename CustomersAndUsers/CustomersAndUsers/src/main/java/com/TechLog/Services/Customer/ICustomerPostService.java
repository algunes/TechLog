package com.TechLog.Services.Customer;

import com.TechLog.Entity.Customers.Customer;

public interface ICustomerPostService {
	
	
	Customer createCustomer(Customer customer);
	void removeCustomer(Long id);
	Customer getCustomer(Long id, boolean isFull);
	Customer updateCustomer(Customer customer);
	
}
