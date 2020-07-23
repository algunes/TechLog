package com.TechLog.Services.CustomerImp;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.CorporationBuilder;
import com.TechLog.Customers.Customer;
import com.TechLog.Customers.CustomerBuilder;
import com.TechLog.Dao.CorporationImp.CorporationDaoImp;
import com.TechLog.Dao.CustomerImp.CustomerDaoImp;
import com.TechLog.Services.CustomerService;
import com.TechLog.Users.Users;

public class CustomerServiceImp implements CustomerService {

	// Creates and persists a customer from scratch
	
	@Override
	public Customer createCustomer(String firstname, String lastname, Long corporationId, String department,
			String position, String email, String telNum, String address, Users user) {

		Customer customer = new CustomerBuilder()
				.setFirstname(firstname)
				.setLastname(lastname)
				.setCorporation(getCorporation(corporationId, false))
				.setDepartment(department)
				.setPosition(position)
				.setEmail(email)
				.setTelNum(telNum)
				.setAddress(address)
				.setCreatedBy(user)
				.setCreationDate(LocalDate.now())
				.build();
			
		return getCustomer(new CustomerDaoImp().addCustomer(customer), true);
	}
	
	// removes a specific customer

	@Override
	public Customer removeCustomer(Long customerId) {
			Customer customer = getCustomer(customerId, false);
			new CustomerDaoImp().deleteCustomer(customer);
			return customer;
	}

	// get a customer (isFull: lazy or eager)
	
	@Override
	public Customer getCustomer(Long id, boolean isFull) {
		if (isFull)
			return new CustomerDaoImp().fullFetchCustomer(id);
		else
			return new CustomerDaoImp().fetchCustomer(id);
	}
	
	// updates a customer

	@Override
	public Customer updateCustomer(Customer customer, Users user) {
		customer.setLast_update(LocalDate.now());
		customer.setUpdated_by(user);
		new CustomerDaoImp().updateCustomer(customer);
		return getCustomer(customer.getCustomer_id(), true);

	}
	
	// create a corporation from scratch (there is one-to-many association between corporation and customer classes. Customer is a subclass of Corporation.)

	@Override
	public Corporation createCorporation(String name, String sector, boolean isActive, Customer customer,
			Users user) {
		
		Corporation corporation = new CorporationBuilder()
				.setName(name)
				.setSector(sector)
				.setIsActive(isActive)
				.setCreated_by(user)
				.setCreationDate(LocalDate.now())
				.build();
		
		return getCorporation(new CorporationDaoImp().addCorporation(corporation), true);

	}
	
	// removes a specific corporation

	@Override
	public void removeCorporation(Corporation corporation) {
		if (corporation != null)
			new CorporationDaoImp().deleteCorporation(corporation);

	}
	
	// get a corporation (isFull: lazy or eager)

	@Override
	public Corporation getCorporation(Long id, boolean isFull) {
		if (isFull)
			return new CorporationDaoImp().fullFetchCorporation(id);
		else
			return new CorporationDaoImp().fetchCorporation(id);
	}

	// retrieve all rows from db corporation table (just for corporation name listing)
	
	@Override
	public List<Corporation> getAllCorporations() {
		return new CorporationDaoImp().fetchAllCorporations();
	}
	
	// update a corporation

	@Override
	public Corporation updateCorporation(Corporation corporation, Users user) {
		CorporationDaoImp cdimp = new CorporationDaoImp();
		corporation.setUpdated_by(user);
		corporation.setLast_update(LocalDate.now());
		cdimp.updateCorporation(corporation);
		return cdimp.fullFetchCorporation(corporation.getId());
	}

	// updates a customer firstname
	
	public Customer updateCustomerFirstname(Long id, String firstname, Users user) {
		Customer customer = getCustomer(id, false);
		customer.setFirstname(firstname);
		updateCustomer(customer, user);
		return customer;
	}
	
	// updates a customer lastname

	public Customer updateCustomerLastname(Long id, String lastname, Users user) {
		Customer customer = getCustomer(id, false);
		customer.setLastname(lastname);
		return updateCustomer(customer, user);
	}
	
	// updates a customer department
	
	public Customer updateCustomerDepartment(Long id, String department, Users user) {

		Customer customer = getCustomer(id, false);
		customer.setDepartment(department);
		updateCustomer(customer, user);
		return customer;
	}
	
	// updates a customer position
	
	public Customer updateCustomerPosition(Long id, String position, Users user) {
		Customer customer = getCustomer(id, false);
		customer.setPosition(position);
		return updateCustomer(customer, user);
	}
	
	// updates a customer email

	public Customer updateCustomerEmail(String oldEmail, String newEmail, HttpSession session, Users user) {

		Customer customer = (Customer)session.getAttribute("customer");
		session.removeAttribute("customer");
		
		if(getCustomer(customer.getCustomer_id(), false) != null && customer.getEmails().contains(oldEmail)) {
			int idx = customer.getEmails().indexOf(oldEmail);
			customer.getEmails().set(idx, newEmail);
			return updateCustomer(customer, user);
		}
		return null;
		
	}
	
	// updates a customer phone number

	public Customer updateTelNum(Long customerId, int index, String telNum, Users user) {

		Customer customer = getCustomer(customerId, true);
		if(!customer.getTelNums().contains(telNum))
		       customer.getTelNums().set(index, telNum);
		return updateCustomer(customer, user);

	}
	
	// updates a customer address

	public Customer updateAddress(Long customerId, int index, String address, Users user) {

		Customer customer = getCustomer(customerId, true);
		if(!customer.getAddresses().contains(address))
		       customer.getAddresses().set(index, address);
		return updateCustomer(customer, user);
	}
	
	// add an email to a customer

	public Customer addEmail(Long id, String email, Users user) {

		Customer customer = getCustomer(id, true);
		if(!customer.getEmails().contains(email))
		       customer.getEmails().add(email);
		return updateCustomer(customer, user);
	}
	
	// add a phone number to a customer

	public Customer addTelNum(Long id, String telNum, Users user) {

		Customer customer = getCustomer(id, true);
		if(!customer.getTelNums().contains(telNum))
		       customer.getTelNums().add(telNum);
		return updateCustomer(customer, user);
	}
	
	// add an address to a customer

	public Customer addAddress(Long id, String address, Users user) {

		Customer customer = getCustomer(id, true);
		if(!customer.getAddresses().contains(address))
		       customer.getAddresses().add(address);
		return updateCustomer(customer, user);
	}
	
	// remove an email from a customer

	public Customer removeEmail(Long id, int index, Users user) {
		Customer customer = getCustomer(id, true);
		customer.getEmails().remove(index);
		customer.setLast_update(LocalDate.now());
		return updateCustomer(customer, user);
	}
	
	// remove a phone number from a customer

	public Customer removeTelNum(Long id, int index, Users user) {
		Customer customer = getCustomer(id, true);
		customer.getTelNums().remove(index);
		return updateCustomer(customer, user);
	}
	
	// remove an address from a customer

	public Customer removeAddress(Long id, int index, Users user) {
		Customer customer = getCustomer(id, true);
		customer.getAddresses().remove(index);
		customer.setLast_update(LocalDate.now());
		return updateCustomer(customer, user);
	}
	
	// update corporation name
	
	public Corporation updateCorporationName(Long id, String name, Users user) {
		Corporation corporation = getCorporation(id, false);
		corporation.setName(name);
		return updateCorporation(corporation, user);
	}
	
	// update corporation sector
	
		public Corporation updateCorporationSector(Long id, String sector, Users user) {
			Corporation corporation = getCorporation(id, false);
			corporation.setSector(sector);;
			return updateCorporation(corporation, user);
		}

}
