package com.TechLog.Services.CustomerImp;

import java.time.LocalDate;
import java.util.List;

import com.TechLog.Customers.Address;
import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;
import com.TechLog.Customers.Email;
import com.TechLog.Customers.Phone;
import com.TechLog.Dao.CorporationImp.CorporationDaoImp;
import com.TechLog.Dao.CustomerImp.CustomerDaoImp;
import com.TechLog.Services.CustomerService;

public class CustomerServiceImp implements CustomerService {

	@Override
	public Long createCustomer(Customer customer) {
		return new CustomerDaoImp().addCustomer(customer);
	}

	@Override
	public void removeCustomer(Customer customer) {
		if (customer != null)
			new CustomerDaoImp().deleteCustomer(customer);
	}

	@Override
	public Customer getCustomer(Long id, boolean isFull) {
		if (isFull)
			return new CustomerDaoImp().fullFetchCustomer(id);
		else
			return new CustomerDaoImp().fetchCustomer(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customer.setLast_update(LocalDate.now());
		new CustomerDaoImp().updateCustomer(customer);

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
	
	public Customer updateCustomerFirstname(Long id, String firstname) {
		Customer customer = getCustomer(id, false);
		customer.setFirstname(firstname);
		updateCustomer(customer);
		return customer;
	}
	
	public Customer updateCustomerLastname(Long id, String lastname) {
		Customer customer = getCustomer(id, false);
		customer.setLastname(lastname);
		updateCustomer(customer);
		return customer;
	}

	public void updateEmail(Long customerId, int index, String email) {

		Customer customer = getCustomer(customerId, true);
		customer.getEmails().get(index).setEmail(email);
		customer.getEmails().get(index).setLast_update(LocalDate.now());
		updateCustomer(customer);

	}

	public void updatePhone(Long customerId, int index, String phone) {

		Customer customer = getCustomer(customerId, true);
		customer.getPhones().get(index).setNumber(phone);
		customer.getPhones().get(index).setLast_update(LocalDate.now());
		updateCustomer(customer);
		
	}

	public void updateAddress(Long customerId, int index, String address) {

		Customer customer = getCustomer(customerId, true);
		customer.getAddresses().get(index).setAddress(address);
		customer.getAddresses().get(index).setLast_update(LocalDate.now());
		updateCustomer(customer);

	}
	
	public void addEmail(Long id, String eml) {
		Email email = new Email();
		email.setEmail(eml);
		email.setCreation_date(LocalDate.now());
		Customer customer = getCustomer(id, true);
		customer.addEmail(email);
		updateCustomer(customer);
	}
	
	public void addPhone(Long id, String phn) {
		Phone phone = new Phone();
		phone.setNumber(phn);
		phone.setCreation_date(LocalDate.now());
		Customer customer = getCustomer(id, true);
		customer.addPhone(phone);
		updateCustomer(customer);
	}
	
	public void addAddress(Long id, String add) {
		Address address = new Address();
		address.setAddress(add);
		address.setCreation_date(LocalDate.now());
		Customer customer = getCustomer(id, true);
		customer.addAddress(address);
		updateCustomer(customer);
	}
	
	public void removeEmail(Long id, int index) {
		Customer customer = new Customer();
		customer = getCustomer(id, true);
		customer.getEmails().remove(index);
		customer.setLast_update(LocalDate.now());
		updateCustomer(customer);
	}
	
	public void removePhone(Long id, int index) {	
		Customer customer = new Customer();
		customer = getCustomer(id, true);
		customer.getPhones().remove(index);
		customer.setLast_update(LocalDate.now());
		updateCustomer(customer);
	}
	
	public void removeAddress(Long id, int index) {	
		Customer customer = new Customer();
		customer = getCustomer(id, true);
		customer.getAddresses().remove(index);
		customer.setLast_update(LocalDate.now());
		updateCustomer(customer);
	}

}
