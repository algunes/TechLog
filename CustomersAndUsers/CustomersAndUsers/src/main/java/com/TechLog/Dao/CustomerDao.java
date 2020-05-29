package com.TechLog.Dao;

import com.TechLog.Customers.Customer;

public interface CustomerDao {
	
	void addCustomer(Customer customer);
	void deleteCustomer(Customer customer);
	Customer fetchCustomer(Long id);
	void updateCustomer(Customer customer);

}
