package com.TechLog.Services;

import java.util.List;

import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;
import com.TechLog.Users.Users;

public interface CustomerService {
	
	Customer createCustomer(String firstname, String lastname, Long corporationId, 
			String department, String position, String email, String telNum, String address, Users user);
	Customer removeCustomer(Long customerId);
	Customer getCustomer(Long id, boolean isFull);
	Customer updateCustomer(Customer customer, Users user);
	Long createCorporation(Corporation corporation, Users user);
	void removeCorporation(Corporation corporation);
	Corporation getCorporation(Long id, boolean isFull);
	List<Corporation> getAllCorporations();
	void updateCorporation(Corporation corporation, Users user);

}
