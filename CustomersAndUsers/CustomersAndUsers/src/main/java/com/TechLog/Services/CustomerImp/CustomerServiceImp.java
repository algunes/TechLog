package com.TechLog.Services.CustomerImp;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.TechLog.Corporations.Corporation;
import com.TechLog.Corporations.CorporationBuilder;
import com.TechLog.Customers.Customer;
import com.TechLog.Customers.CustomerBuilder;
import com.TechLog.Dao.CorporationImp.CorporationDaoImp;
import com.TechLog.Dao.CustomerImp.CustomerDaoImp;
import com.TechLog.Users.Users;

public class CustomerServiceImp {

	// Creates and persists a customer from scratch
	
	public Customer createCustomer(HttpServletRequest request) {
		
		Customer customer = new CustomerBuilder()
				.setFirstname(request.getParameter("firstname"))
				.setLastname(request.getParameter("lastname"))
				.setCorporation(getCorporation(Long.parseLong(request.getParameter("corporation")), false))
				.setDepartment(request.getParameter("department"))
				.setPosition(request.getParameter("position"))
				.setEmail(request.getParameter("email"))
				.setTelNum(request.getParameter("telNum"))
				.setAddress(request.getParameter("address"))
				.setCreatedBy((Users)request.getSession(false).getAttribute("user"))
				.setCreationDate(LocalDate.now())
				.build();
			
		return getCustomer(new CustomerDaoImp().addCustomer(customer), true);
	}
	
	// removes a specific customer

	public Customer removeCustomer(Long customerId) {
			Customer customer = getCustomer(customerId, false);
			new CustomerDaoImp().deleteCustomer(customer);
			return customer;
	}

	// get a customer (isFull: lazy or eager)
	
	public Customer getCustomer(Long id, boolean isFull) {
		if (isFull)
			return new CustomerDaoImp().fullFetchCustomer(id);
		else
			return new CustomerDaoImp().fetchCustomer(id);
	}
	
	// updates a customer

	public Customer updateCustomer(Customer customer, Users user) {
		customer.setLast_update(LocalDate.now());
		customer.setUpdated_by(user);
		new CustomerDaoImp().updateCustomer(customer);
		return getCustomer(customer.getCustomer_id(), true);
	}
	
	// create a corporation from scratch (there is one-to-many association between corporation and customer classes. Customer is a subclass of Corporation.)

	public Corporation createCorporation(HttpSession session) {
		
		String name = (String)session.getAttribute("corporationName");
		String sector = (String)session.getAttribute("corporationSector");
		Boolean isActive = (Boolean)session.getAttribute("corporationIsActive");
		Users user = (Users)session.getAttribute("user");
		
		session.removeAttribute("corporationName");
		session.removeAttribute("corporationSector");
		session.removeAttribute("corporationIsActive");
		
		Corporation corporation = new CorporationBuilder()
				.setName(name)
				.setSector(sector)
				.setIsActive(isActive)
				.setCreated_by(user)
				.setCreationDate(LocalDate.now())
				.build();
		
		return new CorporationDaoImp().addCorporation(corporation);

	}
	
	// removes a specific corporation

	public void removeCorporation(Corporation corporation) {
		if (corporation != null)
			new CorporationDaoImp().deleteCorporation(corporation);

	}
	
	// get a corporation (isFull: lazy or eager)

	public Corporation getCorporation(Long id, boolean isFull) {
		if (isFull)
			return new CorporationDaoImp().fullFetchCorporation(id);
		else
			return new CorporationDaoImp().fetchCorporation(id);
	}

	// retrieve all rows from db corporation table (just for corporation name listing)
	
	public List<Corporation> getAllCorporations() {
		return new CorporationDaoImp().fetchAllCorporations();
	}
	
	// update a corporation

	public Corporation updateCorporation(Corporation corporation, Users user) {
		
		corporation.setUpdated_by(user);
		corporation.setLast_update(LocalDate.now());
		return new CorporationDaoImp().updateCorporation(corporation);
		
	}

	// updates a customer firstname
	
	public Customer updateCustomerFirstname(HttpSession session) {
		
		String newFirstname = (String)session.getAttribute("newCustomerFirstname");
		String oldFirstname = ((Customer)session.getAttribute("customer")).getFirstname();

		Customer customer = getCustomer(((Customer)session.getAttribute("customer")).getCustomer_id(), true);
		session.removeAttribute("newCustomerFirstname");
		session.removeAttribute("customer");
		
		if(customer != null && customer.getFirstname().equals(oldFirstname)) {
			customer.setFirstname(newFirstname);
			return updateCustomer(customer, (Users)session.getAttribute("user"));
		}
		else {
			return null;
		}
	}
	
	// updates a customer lastname

	public Customer updateCustomerLastname(HttpSession session) {

		
		String newLastname = (String)session.getAttribute("newCustomerLastname");
		String oldLastname = ((Customer)session.getAttribute("customer")).getLastname();

		Customer customer = getCustomer(((Customer)session.getAttribute("customer")).getCustomer_id(), true);
		session.removeAttribute("newCustomerLastname");
		session.removeAttribute("customer");
		
		if(customer != null && customer.getLastname().equals(oldLastname)) {
			customer.setLastname(newLastname);
			return updateCustomer(customer, (Users)session.getAttribute("user"));
		}
		else {
			return null;
		}
	}
	
	// updates a customer department
	
	public Customer updateCustomerDepartment(HttpSession session) {

		String newDepartment = (String)session.getAttribute("newCustomerDepartment");
		String oldDepartment = ((Customer)session.getAttribute("customer")).getDepartment();

		Customer customer = getCustomer(((Customer)session.getAttribute("customer")).getCustomer_id(), true);
		session.removeAttribute("newCustomerDepartment");
		session.removeAttribute("customer");
		
		if(customer != null && customer.getDepartment().equals(oldDepartment)) {
			customer.setDepartment(newDepartment);
			return updateCustomer(customer, (Users)session.getAttribute("user"));
		}
		else {
			return null;
		}
	}
	
	// updates a customer position
	
	public Customer updateCustomerPosition(HttpSession session) {
		
		String newPosition = (String)session.getAttribute("newCustomerPosition");
		String oldPosition = ((Customer)session.getAttribute("customer")).getPosition();

		Customer customer = getCustomer(((Customer)session.getAttribute("customer")).getCustomer_id(), true);
		session.removeAttribute("newCustomerPosition");
		session.removeAttribute("customer");
		
		if(customer != null && customer.getPosition().equals(oldPosition)) {
			customer.setPosition(newPosition);
			return updateCustomer(customer, (Users)session.getAttribute("user"));
		}
		else {
			return null;
		}
	}
	
	// updates a customer email

	public Customer updateEmail(HttpSession session) {
		
		String newEmail = (String)session.getAttribute("newEmail");
		String oldEmail = (String)session.getAttribute("oldEmail");
		Customer customer = getCustomer(((Customer)session.getAttribute("customer")).getCustomer_id(), true);
		session.removeAttribute("customer");
		session.removeAttribute("newEmail");
		session.removeAttribute("oldEmail");
		
		if(customer != null && customer.getEmails().contains(oldEmail) && !customer.getEmails().stream().anyMatch(newEmail::equalsIgnoreCase)) {
			int idx = customer.getEmails().indexOf(oldEmail);
			customer.getEmails().set(idx, newEmail);
			return updateCustomer(customer, (Users)session.getAttribute("user"));
		}
		return null;
	}
	
	// updates a customer phone number

	public Customer updateTelNum(HttpSession session) {
		
		String newTelNum = (String)session.getAttribute("newTelNum");
		String oldTelNum = (String)session.getAttribute("oldTelNum");
		Customer customer = getCustomer(((Customer)session.getAttribute("customer")).getCustomer_id(), true);
		session.removeAttribute("customer");
		session.removeAttribute("newTelNum");
		session.removeAttribute("oldTelNum");
		
		if(customer != null && customer.getTelNums().contains(oldTelNum) && !customer.getTelNums().stream().anyMatch(newTelNum::equalsIgnoreCase)) {
			int idx = customer.getTelNums().indexOf(oldTelNum);
			customer.getTelNums().set(idx, newTelNum);
			return updateCustomer(customer, (Users)session.getAttribute("user"));
		}
		return null;

	}
	
	// updates a customer address

	public Customer updateAddress(HttpSession session) {

		String newAddress = (String)session.getAttribute("newAddress");
		String oldAddress = (String)session.getAttribute("oldAddress");
		Customer customer = getCustomer(((Customer)session.getAttribute("customer")).getCustomer_id(), true);
		session.removeAttribute("customer");
		session.removeAttribute("newAddress");
		session.removeAttribute("oldAddress");
		
		if(customer != null && customer.getAddresses().contains(oldAddress) && !customer.getAddresses().stream().anyMatch(newAddress::equalsIgnoreCase)) {
			int idx = customer.getAddresses().indexOf(oldAddress);
			customer.getAddresses().set(idx, newAddress);
			return updateCustomer(customer, (Users)session.getAttribute("user"));
		}
		return null;
	}
	
	// add an email to a customer

	public Customer addEmail(HttpSession session) {

		String newEmail = (String)session.getAttribute("newEmail");
		Customer customer = getCustomer(((Customer)session.getAttribute("customer")).getCustomer_id(), true);
				
		session.removeAttribute("newEmail");
		
		if(customer != null && !customer.getEmails().stream().anyMatch(newEmail::equalsIgnoreCase)) {
			session.removeAttribute("customer");
			customer.getEmails().add(newEmail);
			return updateCustomer(customer, (Users)session.getAttribute("user"));
		}
		else {
			return null;
		}	
	}
	
	// add a phone number to a customer

	public Customer addTelNum(HttpSession session) {

		String newTelNum = (String)session.getAttribute("newTelNum");
		Customer customer = getCustomer(((Customer)session.getAttribute("customer")).getCustomer_id(), true);
				
		session.removeAttribute("newTelNum");
		
		if(customer != null && !customer.getTelNums().stream().anyMatch(newTelNum::equalsIgnoreCase)) {
			session.removeAttribute("customer");
			customer.getTelNums().add(newTelNum);
			return updateCustomer(customer, (Users)session.getAttribute("user"));
		}
		else {
			return null;
		}
	}
	
	// add an address to a customer

	public Customer addAddress(HttpSession session) {

		String newAddress = (String)session.getAttribute("newAddress");
		Customer customer = getCustomer(((Customer)session.getAttribute("customer")).getCustomer_id(), true);
				
		session.removeAttribute("newAddress");
		
		if(customer != null && !customer.getAddresses().stream().anyMatch(newAddress::equalsIgnoreCase)) {
			session.removeAttribute("customer");
			customer.getAddresses().add(newAddress);
			return updateCustomer(customer, (Users)session.getAttribute("user"));
		}
		else {
			return null;
		}
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
	
	public Corporation updateCorporationName(HttpSession session) {
		
		Corporation corporation = getCorporation(((Corporation)session.getAttribute("corporation")).getId(), true);
		String newCorporationName = (String)session.getAttribute("newCorporationName");
		String oldCorporationName = ((Corporation)session.getAttribute("corporation")).getName();
		session.removeAttribute("newCorporationName");
		session.removeAttribute("corporation");

		
		Users user = (Users)session.getAttribute("user");
		
		if(corporation != null && 
				new CorporationDaoImp().validateCorporationName(newCorporationName) == null && 
				corporation.getName().equals(oldCorporationName)) {
			
			corporation.setName(newCorporationName);
			return updateCorporation(corporation, user);
		}
		else {
			return null;
		}
	}
	
	// update corporation sector
	
		public Corporation updateCorporationSector(HttpSession session) {
			Corporation corporation = getCorporation(((Corporation)session.getAttribute("corporation")).getId(), true);
			String newCorporationSector = (String)session.getAttribute("newCorporationSector");
			String oldCorporationSector = ((Corporation)session.getAttribute("corporation")).getSector();
			session.removeAttribute("newCorporationSector");
			session.removeAttribute("corporation");
			Users user = (Users)session.getAttribute("user");
			
			if(corporation != null && corporation.getSector().equals(oldCorporationSector)) {
				corporation.setSector(newCorporationSector);
				return updateCorporation(corporation, user);
			}
			else {
				return null;
			}
		}

}
