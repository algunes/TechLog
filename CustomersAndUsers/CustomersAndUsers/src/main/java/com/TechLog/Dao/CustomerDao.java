package com.TechLog.Dao;

import com.TechLog.Model.Customers.Customer;

public interface CustomerDao {
	
	Long addCustomer(Customer customer);
	void deleteCustomer(Customer customer);
	Customer fetchCustomer(Long id);
	Customer fullFetchCustomer(Long id);
	void updateCustomer(Customer customer);

}
