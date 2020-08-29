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
import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.Corporation.CorporationPostService;
import com.TechLog.Services.Customer.CustomerPostService;
import com.TechLog.Services.DomainViewService.DomainViewService;

@WebServlet("/readCustomer")
public class ReadCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Users user = (Users)request.getSession(false).getAttribute("user");
		String job = request.getParameter("job");
		DomainViewService viewPermissions = new DomainViewService(user, user);

		
		switch (job) {

		// eager
		case "getCustomer": {
			Long id = Long.parseLong(request.getParameter("id"));
			Customer customer = new CustomerPostService().getCustomer(id, true);
			request.setAttribute("customer", customer);
			request.setAttribute("viewPermissions", viewPermissions);
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);	
			break;
		}
		
		// eager
		case "getCorporation": {
			Long id = Long.parseLong(request.getParameter("id"));
			
			Corporation corporation = new CorporationPostService().getCorporation(id, true);
			
			request.setAttribute("corporation", corporation);
			request.setAttribute("viewPermissions", viewPermissions);
			RequestDispatcher rd = request.getRequestDispatcher("ShowCorporation.jsp");
			rd.forward(request, response);
			break;
		}
		// lazy
		case "getCorporationList": {
			CorporationPostService cps = new CorporationPostService();
			List<Corporation> corporations = cps.getAllCorporations();
			Long corpNum = cps.getNumberOfCorporation();
			request.setAttribute("corporations", corporations);
			request.setAttribute("corpNum", corpNum);
			request.setAttribute("viewPermissions", viewPermissions);
			RequestDispatcher rd = request.getRequestDispatcher("CorporationList.jsp");
			rd.forward(request, response);
			break;
		}
		
		default : {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
		}
			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
