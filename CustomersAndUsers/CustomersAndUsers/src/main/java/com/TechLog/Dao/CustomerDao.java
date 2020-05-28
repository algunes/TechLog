package com.TechLog.Dao;

import com.TechLog.Customers.Customer;

public interface CustomerDao {
	
	public abstract boolean addCustomer(Customer customer);
	public abstract boolean deleteCustomer(Customer customer);
	public abstract Customer fetachCustomer(Long id);
	public abstract boolean updateCustomer();

}
