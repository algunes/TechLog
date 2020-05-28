package com.TechLog.Services.CustomerImp;

import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;
import com.TechLog.Dao.CustomerImp.CustomerDaoImp;
import com.TechLog.Services.CustomerService;

public class CustomerServiceImp implements CustomerService {

	@Override
	public void createCustomer(Customer customer) {
		new CustomerDaoImp().addCustomer(customer);		
	}

	@Override
	public void removeCustomer(Customer customer) {
		new CustomerDaoImp().addCustomer(customer);	
	}

	@Override
	public Customer getCustomer(Long id) {
		return new CustomerDaoImp().fetchCustomer(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		new CustomerDaoImp().updateCustomer(customer);
	
	}

	@Override
	public void createCorporation(Corporation corporation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCorporation(Corporation corporation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Corporation getCorporation(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCorporation(Corporation corporation) {
		// TODO Auto-generated method stub
		
	}

}
