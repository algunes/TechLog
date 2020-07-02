package com.CustomerController;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;
import com.TechLog.Services.CustomerImp.CustomerServiceImp;
import com.TechLog.Users.Users;

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
		String department = request.getParameter("department");
		String email = request.getParameter("email");
		String telNum = request.getParameter("telNum");
		String address = request.getParameter("address");
		Long corpId = Long.parseLong(request.getParameter("corporation"));
		Users user = new Users();
		
		CustomerServiceImp cs = new CustomerServiceImp();
		Customer customer = cs.createCustomer(firstname, lastname, corpId, department, email, telNum, address, user);
		
		
		request.setAttribute("customer", customer); 
		request.setAttribute("message", customer.getFirstname() + " " + customer.getLastname() + " created succesfully!");
		  RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp"); 
		  rd.forward(request, response);
	}
    	


}
