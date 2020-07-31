package com.TechLog.Services.Customer;

import com.TechLog.DAO.Customers.CustomerDAO;
import com.TechLog.Entity.Customers.Customer;

public class CustomerPostService implements ICustomerPostService {

	@Override
	public Customer createCustomer(Customer customer) {
		// Creates and persists a customer from scratch
		return getCustomer(new CustomerDAO().addCustomer(customer), true);
	}

	@Override
	public Customer removeCustomer(Long id) {
		// removes a specific customer
		Customer customer = getCustomer(id, false);
		new CustomerDAO().deleteCustomer(customer);
		return customer;
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
		new CustomerDAO().updateCustomer(customer);
		return getCustomer(customer.getCustomer_id(), true);
	}

}