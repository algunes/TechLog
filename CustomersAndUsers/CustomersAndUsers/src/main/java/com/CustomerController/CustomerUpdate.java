package com.CustomerController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Customers.Customer;
import com.TechLog.Services.CustomerImp.CustomerServiceImp;


public class CustomerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Customer customer = new CustomerServiceImp().getCustomer(id, true);
		request.setAttribute("customer", customer);
		RequestDispatcher rd = request.getRequestDispatcher("CustomerUpdate.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
