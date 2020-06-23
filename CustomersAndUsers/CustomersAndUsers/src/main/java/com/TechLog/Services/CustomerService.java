package com.TechLog.Services;

import java.util.List;

import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;

public interface CustomerService {
	
	Long createCustomer(Customer customer);
	void removeCustomer(Customer customer);
	Customer getCustomer(Long id, boolean isFull);
	void updateCustomer(Customer customer);
	Long createCorporation(Corporation corporation);
	void removeCorporation(Corporation corporation);
	Corporation getCorporation(Long id, boolean isFull);
	List<Corporation> getAllCorporations();
	void updateCorporation(Corporation corporation);

}
