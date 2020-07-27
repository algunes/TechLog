package com.TechLog.CustomerControllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Customers.Customer;
import com.TechLog.Services.SearchService;

@WebServlet("/searchCustomer")
public class SearchCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("SearchCustomer.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String keyword = request.getParameter("keyword");
		List<Customer> customers = new SearchService().searchByCustomerName(keyword);
		request.setAttribute("customers", customers); 
		RequestDispatcher rd = request.getRequestDispatcher("CustomerList.jsp"); 
		rd.forward(request, response);

		
		
	}

}
