package com.TechLog.Services.Customer;

import com.TechLog.Entity.Customers.Customer;
import com.TechLog.Entity.Customers.CustomerBuilder;
import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.Corporation.CorporationPostService;

public class CustomerPreService implements ICustomerPreService {

	@Override
	public Customer createCustomer(
			String firstname,
			String lastname,
			Long corporationId,
			String department,
			String position,
			String email,
			String telNum,
			String address,
			Users user) {
		
		// Creates and persists a customer from scratch
		Customer customer = new CustomerBuilder()
				.setFirstname(firstname)
				.setLastname(lastname)
				.setCorporation(new CorporationPostService().getCorporation(corporationId, false))
				.setDepartment(department)
				.setPosition(position)
				.setEmail(email)
				.setTelNum(telNum)
				.setAddress(address)
				.setCreatedBy(user)
				.build();
			
		return new CustomerPostService().createCustomer(customer);
	}

	@Override
	public Customer updateCustomerFirstname(Long id, String oldName, String newName, Users user) {
		// updates a customer firstname
		CustomerPostService cps = new CustomerPostService();
		Customer customer = cps.getCustomer(id, true);
		
		if(customer != null && customer.getFirstname().equals(oldName)) {
			customer.setFirstname(newName);
			customer.setUpdated_by(user);
			return cps.updateCustomer(customer);
		}
		else {
			return null;
		}
	}

	@Override
	public Customer updateCustomerLastname(Long id, String oldName, String newName, Users user) {
		// updates a customer lastname
		CustomerPostService cps = new CustomerPostService();
		Customer customer = cps.getCustomer(id, true);
				
		if(customer != null && customer.getLastname().equals(oldName)) {
			customer.setLastname(newName);
			customer.setUpdated_by(user);
			return cps.updateCustomer(customer);
		}
		else {
			return null;
		}
	}

	@Override
	public Customer updateCustomerDepartment(Long id, String oldDepartment, String newDepartment, Users user) {
		// updates a customer department
		CustomerPostService cps = new CustomerPostService();
		Customer customer = cps.getCustomer(id, true);
		
		if(customer != null && customer.getDepartment().equals(oldDepartment)) {
			customer.setDepartment(newDepartment);
			customer.setUpdated_by(user);
			return cps.updateCustomer(customer);
		}
		else {
			return null;
		}
	}

	@Override
	public Customer updateCustomerPosition(Long id, String oldPosition, String newPosition, Users user) {
		// updates a customer position
		CustomerPostService cps = new CustomerPostService();
		Customer customer = cps.getCustomer(id, true);
		
		if(customer != null && customer.getPosition().equals(oldPosition)) {
			customer.setPosition(newPosition);
			customer.setUpdated_by(user);
			return cps.updateCustomer(customer);
		}
		else {
			return null;
		}
	}

	@Override
	public Customer updateCustomerEmail(Long id, String oldEmail, String newEmail, Users user) {
		// updates a customer email
		CustomerPostService cps = new CustomerPostService();
		Customer customer = cps.getCustomer(id, true);
		
		if(customer != null && customer.getEmails().contains(oldEmail) && !customer.getEmails().stream().anyMatch(newEmail::equalsIgnoreCase)) {
			int idx = customer.getEmails().indexOf(oldEmail);
			customer.getEmails().set(idx, newEmail);
			customer.setUpdated_by(user);
			return cps.updateCustomer(customer);
		}
		else {
			return null;
		}
	}

	@Override
	public Customer updateCustomerTelNum(Long id, String oldTelNum, String newTelNum, Users user) {
		// updates a customer phone number
		CustomerPostService cps = new CustomerPostService();
		Customer customer = cps.getCustomer(id, true);
		
		if(customer != null && customer.getTelNums().contains(oldTelNum) && !customer.getTelNums().stream().anyMatch(newTelNum::equalsIgnoreCase)) {
			int idx = customer.getTelNums().indexOf(oldTelNum);
			customer.getTelNums().set(idx, newTelNum);
			customer.setUpdated_by(user);
			return cps.updateCustomer(customer);
		}
		else {
			return null;
		}
	}

	@Override
	public Customer updateCustomerAddress(Long id, String oldAddress, String newAddress, Users user) {
		// updates a customer address
		CustomerPostService cps = new CustomerPostService();
		Customer customer = cps.getCustomer(id, true);
		
		if(customer != null && customer.getAddresses().contains(oldAddress) && !customer.getAddresses().stream().anyMatch(newAddress::equalsIgnoreCase)) {
			int idx = customer.getAddresses().indexOf(oldAddress);
			customer.getAddresses().set(idx, newAddress);
			customer.setUpdated_by(user);
			return cps.updateCustomer(customer);
		}
		else {
			return null;
		}
	}

	@Override
	public Customer addEmail(Long id, String newEmail, Users user) {
		// add an email to a customer
		CustomerPostService cps = new CustomerPostService();
		Customer customer = cps.getCustomer(id, true);
		
		if(customer != null && !customer.getEmails().stream().anyMatch(newEmail::equalsIgnoreCase)) {
			customer.getEmails().add(newEmail);
			customer.setUpdated_by(user);
			return cps.updateCustomer(customer);
		}
		else {
			return null;
		}	
	}

	@Override
	public Customer addTelNum(Long id, String newTelNum, Users user) {
		// add a tel. num. to a customer
		CustomerPostService cps = new CustomerPostService();
		Customer customer = cps.getCustomer(id, true);
		
		if(customer != null && !customer.getTelNums().stream().anyMatch(newTelNum::equalsIgnoreCase)) {
			customer.getTelNums().add(newTelNum);
			customer.setUpdated_by(user);
			return cps.updateCustomer(customer);
		}
		else {
			return null;
		}
	}

	@Override
	public Customer addAddress(Long id, String newAddress, Users user) {
		// add an address to a customer
		CustomerPostService cps = new CustomerPostService();
		Customer customer = cps.getCustomer(id, true);
		
		if(customer != null && !customer.getAddresses().stream().anyMatch(newAddress::equalsIgnoreCase)) {
			customer.getAddresses().add(newAddress);
			customer.setUpdated_by(user);
			return cps.updateCustomer(customer);
		}
		else {
			return null;
		}
	}

	@Override
	public Customer removeEmail(Long id, String email, Users user) {
		// remove an email from a customer
		CustomerPostService cps = new CustomerPostService();
		Customer customer = cps.getCustomer(id, true);
		
		if(customer != null && customer.getEmails().stream().anyMatch(email::equalsIgnoreCase)) {
			customer.getEmails().remove(email);
			customer.setUpdated_by(user);
			return cps.updateCustomer(customer);
		}
		else {
			return null;
		}
	}

	@Override
	public Customer removeTelNum(Long id, String telNum, Users user) {
		// remove a tel. num. from a customer
		CustomerPostService cps = new CustomerPostService();
		Customer customer = cps.getCustomer(id, true);
				
		if (customer != null && customer.getTelNums().stream().anyMatch(telNum::equalsIgnoreCase)) {
			customer.getTelNums().remove(telNum);
			customer.setUpdated_by(user);
			return cps.updateCustomer(customer);
			} 
		else {
			return null;
		}
	}

	@Override
	public Customer removeAddress(Long id, String address, Users user) {
		// remove an address from a customer
		CustomerPostService cps = new CustomerPostService();
		Customer customer = cps.getCustomer(id, true);
						
		if (customer != null && customer.getAddresses().stream().anyMatch(address::equalsIgnoreCase)) {
			customer.getAddresses().remove(address);
			customer.setUpdated_by(user);
			return cps.updateCustomer(customer);
			} 
		else {
			return null;
		}
	}

}
