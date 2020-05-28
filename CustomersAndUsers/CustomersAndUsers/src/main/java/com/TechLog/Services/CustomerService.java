package com.TechLog.Services;

import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;

public interface CustomerService {
	
	void createCustomer(Customer customer);
	void removeCustomer(Customer customer);
	Customer getCustomer(Long id);
	void updateCustomer(Customer customer);
	void createCorporation(Corporation corporation);
	void removeCorporation(Corporation corporation);
	Corporation getCorporation(Long id);
	void updateCorporation(Corporation corporation);

}
