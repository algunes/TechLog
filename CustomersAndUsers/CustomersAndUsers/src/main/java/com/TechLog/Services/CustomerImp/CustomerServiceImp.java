package com.TechLog.Services.CustomerImp;

import java.time.LocalDate;
import java.util.List;

import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;
import com.TechLog.Customers.CustomerBuilder;
import com.TechLog.Dao.CorporationImp.CorporationDaoImp;
import com.TechLog.Dao.CustomerImp.CustomerDaoImp;
import com.TechLog.Services.CustomerService;
import com.TechLog.Users.Users;

public class CustomerServiceImp implements CustomerService {

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
				.getCustomer();
			
		return getCustomer(new CustomerDaoImp().addCustomer(customer), true);
	}

	@Override
	public Customer removeCustomer(Long customerId) {
			Customer customer = getCustomer(customerId, false);
			new CustomerDaoImp().deleteCustomer(customer);
			return customer;
	}

	@Override
	public Customer getCustomer(Long id, boolean isFull) {
		if (isFull)
			return new CustomerDaoImp().fullFetchCustomer(id);
		else
			return new CustomerDaoImp().fetchCustomer(id);
	}

	@Override
	public Customer updateCustomer(Customer customer, Users user) {
		customer.setLast_update(LocalDate.now());
		customer.setUpdated_by(user);
		new CustomerDaoImp().updateCustomer(customer);
		return getCustomer(customer.getCustomer_id(), true);

	}

	@Override
	public Long createCorporation(Corporation corporation) {
		return new CorporationDaoImp().addCorporation(corporation);

	}

	@Override
	public void removeCorporation(Corporation corporation) {
		if (corporation != null)
			new CorporationDaoImp().deleteCorporation(corporation);

	}

	@Override
	public Corporation getCorporation(Long id, boolean isFull) {
		if (isFull)
			return new CorporationDaoImp().fullFetchCorporation(id);
		else
			return new CorporationDaoImp().fetchCorporation(id);
	}

	@Override
	public List<Corporation> getAllCorporations() {
		return new CorporationDaoImp().fetchAllCorporations();
	}

	@Override
	public void updateCorporation(Corporation corporation) {
		new CorporationDaoImp().updateCorporation(corporation);

	}

	public Customer updateCustomerFirstname(Long id, String firstname, Users user) {
		Customer customer = getCustomer(id, false);
		customer.setFirstname(firstname);
		updateCustomer(customer, user);
		return customer;
	}

	public Customer updateCustomerLastname(Long id, String lastname, Users user) {
		Customer customer = getCustomer(id, false);
		customer.setLastname(lastname);
		updateCustomer(customer, user);
		return customer;
	}

	public void updateEmail(Long customerId, int index, String email, Users user) {

		Customer customer = getCustomer(customerId, true);
		if(!customer.getEmails().contains(email))
		       customer.getEmails().set(index, email);
		updateCustomer(customer, user);

	}

	public void updatePhone(Long customerId, int index, String telNum, Users user) {

		Customer customer = getCustomer(customerId, true);
		if(!customer.getTelNums().contains(telNum))
		       customer.getTelNums().set(index, telNum);
		updateCustomer(customer, user);

	}

	public void updateAddress(Long customerId, int index, String address, Users user) {

		Customer customer = getCustomer(customerId, true);
		if(!customer.getAddresses().contains(address))
		       customer.getAddresses().set(index, address);
		updateCustomer(customer, user);
	}

	public void addEmail(Long id, String email, Users user) {

		Customer customer = getCustomer(id, true);
		if(!customer.getEmails().contains(email))
		       customer.getEmails().add(email);
		updateCustomer(customer, user);
	}

	public void addPhone(Long id, String telNum, Users user) {

		Customer customer = getCustomer(id, true);
		if(!customer.getTelNums().contains(telNum))
		       customer.getTelNums().add(telNum);
		updateCustomer(customer, user);
	}

	public void addAddress(Long id, String address, Users user) {

		Customer customer = getCustomer(id, true);
		if(!customer.getAddresses().contains(address))
		       customer.getAddresses().add(address);
		updateCustomer(customer, user);
	}

	public void removeEmail(Long id, int index, Users user) {
		Customer customer = new Customer();
		customer = getCustomer(id, true);
		customer.getEmails().remove(index);
		customer.setLast_update(LocalDate.now());
		updateCustomer(customer, user);
	}

	public void removePhone(Long id, int index, Users user) {
		Customer customer = new Customer();
		customer = getCustomer(id, true);
		customer.getTelNums().remove(index);
		updateCustomer(customer, user);
	}

	public void removeAddress(Long id, int index, Users user) {
		Customer customer = new Customer();
		customer = getCustomer(id, true);
		customer.getAddresses().remove(index);
		customer.setLast_update(LocalDate.now());
		updateCustomer(customer, user);
	}

}
