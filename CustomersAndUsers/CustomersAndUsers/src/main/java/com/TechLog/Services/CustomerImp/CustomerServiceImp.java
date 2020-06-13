package com.TechLog.Services.CustomerImp;

import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;
import com.TechLog.Dao.CorporationImp.CorporationDaoImp;
import com.TechLog.Dao.CustomerImp.CustomerDaoImp;
import com.TechLog.Services.CustomerService;

public class CustomerServiceImp implements CustomerService {

	@Override
	public void createCustomer(Customer customer) {
		new CustomerDaoImp().addCustomer(customer);		
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
	public void updateCorporation(Corporation corporation) {
		new CorporationDaoImp().updateCorporation(corporation);
		
	}

}
