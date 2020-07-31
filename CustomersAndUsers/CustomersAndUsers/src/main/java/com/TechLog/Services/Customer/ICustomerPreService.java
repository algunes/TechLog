package com.TechLog.Services.Customer;

import com.TechLog.DTO.Customers.CustomerDTO;
import com.TechLog.Entity.Customers.Customer;
import com.TechLog.Entity.Users.Users;

public interface ICustomerPreService {

	Customer createCustomer(CustomerDTO cdto); 
	
	Customer updateCustomerFirstname(Long id, String oldName, String newName, Users user);
	Customer updateCustomerLastname(Long id, String oldName, String newName, Users user);
	Customer updateCustomerDepartment(Long id, String oldDepartment, String newDepartment, Users user);
	Customer updateCustomerPosition(Long id, String oldPosition, String newPosition, Users user);
	Customer updateCustomerEmail(Long id, String oldEmail, String newEmail, Users user);
	Customer updateCustomerTelNum(Long id, String oldTelNum, String newTelNum, Users user);
	Customer updateCustomerAddress(Long id, String oldAddress, String newAddress, Users user);
	
	Customer addEmail(Long id, String newEmail, Users user);
	Customer addTelNum(Long id, String newTelNum, Users user);
	Customer addAddress(Long id, String newAddress, Users user);
	
	Customer removeEmail(Long id, String email, Users user);
	Customer removeTelNum(Long id, String telNum, Users user);
	Customer removeAddress(Long id, String address, Users user);
}
