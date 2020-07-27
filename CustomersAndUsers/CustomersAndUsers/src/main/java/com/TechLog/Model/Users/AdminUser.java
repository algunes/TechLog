package com.TechLog.Model.Users;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.TechLog.Model.Corporations.Corporation;
import com.TechLog.Model.Corporations.CreateCorporations;
import com.TechLog.Model.Corporations.RemoveCorporations;
import com.TechLog.Model.Corporations.ShowCorporations;
import com.TechLog.Model.Corporations.UpdateCorporations;
import com.TechLog.Model.Customers.CreateCustomers;
import com.TechLog.Model.Customers.Customer;
import com.TechLog.Model.Customers.RemoveCustomers;
import com.TechLog.Model.Customers.ShowCustomers;
import com.TechLog.Model.Customers.UpdateCustomers;
import com.TechLog.Services.CustomerImp.CustomerServiceImp;

public class AdminUser extends Users
		implements CreateCorporations, CreateCustomers, CreateUsers, ShowCorporations, ShowCustomers, ShowUsers,
		UpdateCorporations, UpdateCustomers, UpdateUsers, RemoveCorporations, RemoveCustomers, RemoveUsers {

	private static final long serialVersionUID = 1L;

	public AdminUser() {
	}

	public AdminUser(Long id, String firstname, String lastname, String department, String position, String role,
			List<Customer> created_customers, List<Customer> updated_customers, List<Corporation> created_corporations,
			List<Corporation> updated_corporations, String email, String telNumber, String address,
			BigDecimal totalSales, LocalDate lastLogin, LocalDate startDate, UserAuthenticationInfo userAuth) {
		super(id, firstname, lastname, department, position, role, created_customers, updated_customers,
				created_corporations, updated_corporations, email, telNumber, address, totalSales, lastLogin, startDate,
				userAuth);
	}

	@Override
	public Users removeUser(Users user) {
		return null;
	}

	@Override
	public Customer removeCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Corporation removeCorporations(Corporation corporation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users updateUser(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Corporation updateCorporations(Corporation corporation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users showUser(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer showCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Corporation showCorporations(Corporation corporation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users createUser(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer createCustomer(HttpServletRequest request) {
		return new CustomerServiceImp().createCustomer(request);
	}

	@Override
	public Corporation createCorporations(Corporation corporation) {
		return null;
	}

}
