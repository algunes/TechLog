package com.TechLog.DAO.Customers;

import java.util.List;

import com.TechLog.Entity.Customers.Customer;

public interface ICustomerDao {
	
	Long addCustomer(Customer customer);
	void deleteCustomer(Customer customer);
	Customer fetchCustomer(Long id);
	Customer fullFetchCustomer(Long id);
	void updateCustomer(Customer customer);
	List<Customer> lastAddedCustomers();
	List<Customer> lastUpdatedCustomers();

}
