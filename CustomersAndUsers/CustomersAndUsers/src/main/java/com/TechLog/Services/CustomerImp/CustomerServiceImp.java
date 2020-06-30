package com.TechLog.Services.CustomerImp;

import java.util.List;

import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;
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
	
	public void updateEmail(Long customerId, int index, String email) {
		
		Customer customer = getCustomer(customerId, true);	
		customer.getEmails().get(index).setEmail(email);
		updateCustomer(customer);
		
	}

}
