package com.CustomerController;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Customers.Address;
import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;
import com.TechLog.Customers.Email;
import com.TechLog.Customers.Phone;
import com.TechLog.Services.CustomerImp.CustomerServiceImp;

@WebServlet("/addCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Corporation> corporations = new CustomerServiceImp().getAllCorporations();
		request.setAttribute("corporations", corporations);
		RequestDispatcher rd = request.getRequestDispatcher("AddCustomer.jsp");
		rd.forward(request, response);		
	}
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname =request.getParameter("lastname");
		Long corpID = Long.parseLong(request.getParameter("corporation"));
		Email email = new Email();
		email.setEmail(request.getParameter("email"));
		Phone telNumber = new Phone();
		telNumber.setNumber(request.getParameter("telNumber"));
		Address address = new Address();
		address.setAddress(request.getParameter("address"));
		
		Customer customer = new Customer();
		customer.setFirstname(firstname);
		customer.setLastname(lastname);
		customer.setCorporation(new CustomerServiceImp().getCorporation(corpID, false));
		customer.addEmail(email);
		customer.addPhone(telNumber);
		customer.addAddress(address);		
		
		Long id = new CustomerServiceImp().createCustomer(customer);
		
		customer = new CustomerServiceImp().getCustomer(id, false);
		
		
		request.setAttribute("customer", customer); 
		  RequestDispatcher rd = request.getRequestDispatcher("SuccessScreen.jsp"); 
		  rd.forward(request, response);
	}

}
