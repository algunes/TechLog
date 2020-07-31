package com.TechLog.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Entity.Corporations.Corporation;
import com.TechLog.Entity.Customers.Customer;
import com.TechLog.Services.Corporation.CorporationPostService;
import com.TechLog.Services.Customer.CustomerPostService;

@WebServlet("/getCustomer")
public class GetCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String job = request.getParameter("job");
		
		switch (job) {

		// eager
		case "getCustomer": {
			Long id = Long.parseLong(request.getParameter("id"));
			Customer customer = new CustomerPostService().getCustomer(id, true);
			request.setAttribute("customer", customer);
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);	
			break;
		}
		
		// eager
		case "getCorporation": {
			Long id = Long.parseLong(request.getParameter("id"));
			Corporation corporation = new CorporationPostService().getCorporation(id, true);
			request.setAttribute("corporation", corporation);
			RequestDispatcher rd = request.getRequestDispatcher("ShowCorporation.jsp");
			rd.forward(request, response);
			break;
		}
		// lazy
		case "getCorporationList": {
			List<Corporation> corporations = new CorporationPostService().getAllCorporations();
			request.setAttribute("corporations", corporations);
			RequestDispatcher rd = request.getRequestDispatcher("CorporationList.jsp");
			rd.forward(request, response);
			break;
		}
		
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
