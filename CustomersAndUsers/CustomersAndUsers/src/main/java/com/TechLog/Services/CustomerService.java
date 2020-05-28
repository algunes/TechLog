package com.TechLog.Services;

import com.TechLog.Customers.Customer;

public interface CustomerService {
	
	public abstract boolean createCustomer(Customer customer);
	public abstract boolean removeCustomer(Customer customer);
	public abstract Customer getCustomer(Long id);
	public abstract boolean updateCustomer();

}
