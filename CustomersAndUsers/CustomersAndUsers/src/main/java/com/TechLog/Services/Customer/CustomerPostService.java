package com.TechLog.Services.Customer;

import java.time.LocalDateTime;
import java.util.List;

import com.TechLog.DAO.Customers.CustomerDAO;
import com.TechLog.Entity.Customers.Customer;

public class CustomerPostService implements ICustomerPostService {

	@Override
	public Customer createCustomer(Customer customer) {
		// Creates and persists a customer from scratch
		customer.setCreation_date(LocalDateTime.now());
		return getCustomer(new CustomerDAO().addCustomer(customer), true);
	}

	@Override
	public void removeCustomer(Long id) {
		// removes a specific customer
		Customer customer = getCustomer(id, true);
		new CustomerDAO().deleteCustomer(customer);
	}

	@Override
	public Customer getCustomer(Long id, boolean isFull) {
		// get a customer (isFull: lazy or eager)
		if (isFull)
			return new CustomerDAO().fullFetchCustomer(id);
		else
			return new CustomerDAO().fetchCustomer(id);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// updates a customer
		customer.setLast_update(LocalDateTime.now());
		new CustomerDAO().updateCustomer(customer);
		return getCustomer(customer.getCustomer_id(), true);
	}
	
	@Override
	public List<Customer> getLastAddedCustomers() {
		return new CustomerDAO().lastAddedCustomers();
	}
	
	@Override
	public List<Customer> getLastUpdatedCustomers() {
		return new CustomerDAO().lastUpdatedCustomers();
	}

}
