package com.TechLog.Controllers;

import java.io.IOException;

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
import com.TechLog.Services.Customer.CustomerPreService;

@WebServlet("/deleteCustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		String job = request.getParameter("job") != null ? request.getParameter("job") : "";
	
		switch(job) {
		
		case "removeCorporation": {
			CorporationPostService cps = new CorporationPostService();
			Corporation corporation = cps.removeCorporation(id);
			
			request.setAttribute("message", corporation.getName() + " and all of its records removed succesfully!");
			request.setAttribute("corporations", cps.getAllCorporations());
			
			RequestDispatcher rd = request.getRequestDispatcher("CorporationList.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "removeCustomer": {
			Customer customer = new CustomerPostService().removeCustomer(id);	
			request.setAttribute("message", customer.getFirstname() + " " + customer.getLastname() + " from " + customer.getCorporation().getName() +" deleted succesfully!");
			request.setAttribute("corporation", new CorporationPostService().getCorporation(customer.getCorporation().getId(), true));			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCorporation.jsp");
			rd.forward(request, response);
			break;		
		}
		
	case "removeCustomerEmail": {

		int idx = Integer.parseInt(request.getParameter("index"));
		
		CustomerPostService cpoc = new CustomerPostService();
		
		Customer customer = cpoc.getCustomer(id, true);
		
		if(customer.getEmails().get(idx) != null) {
			request.setAttribute("job", "removeCustomerEmail");
			request.setAttribute("value", customer.getEmails().get(idx));
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("formaction", "deleteCustomer");
			request.setAttribute("alert", "Are you sure to delete this?");
			RequestDispatcher rd = request.getRequestDispatcher("CustomerDataRemoveConfirmation.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("alert", "Customer's data changed, please check the customer again!");
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
		break;
	}

	case "removeCustomerTelNum": {

		int idx = Integer.parseInt(request.getParameter("index"));
		
		CustomerPostService cpoc = new CustomerPostService();
		
		Customer customer = cpoc.getCustomer(id, true);
		
		if(customer.getTelNums().get(idx) != null) {
			request.setAttribute("customer", customer);
			request.setAttribute("idx", idx);
			request.setAttribute("message", "Are you sure to delete this?");
			RequestDispatcher rd = request.getRequestDispatcher("CustomerDataRemoveConfirmation.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("alert", "Customer's data changed, please check the customer again!");
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
		break;
	}

	case "removeCustomerAddress": {

		int idx = Integer.parseInt(request.getParameter("index"));
		
		CustomerPostService cpoc = new CustomerPostService();
		
		Customer customer = cpoc.getCustomer(id, true);
		
		if(customer.getAddresses().get(idx) != null) {
			request.setAttribute("customer", customer);
			request.setAttribute("idx", idx);
			request.setAttribute("message", "Are you sure to delete this?");
			RequestDispatcher rd = request.getRequestDispatcher("CustomerDataRemoveConfirmation.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("alert", "Customer's data changed, please check the customer again!");
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
		break;
	}
	
	default : {
		response.sendRedirect("index.jsp");
	}
			
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		String job = request.getParameter("job") != null ? request.getParameter("job") : "";
		Users user = (Users)request.getSession(false).getAttribute("user");
		
		switch(job) {
		case "removeCustomerEmail": {
			String email = (String)request.getParameter("value");
			
			Customer customer = new CustomerPreService().removeEmail(id, email, user);
			
			if(customer != null) {
				request.setAttribute("customer", customer);
				request.setAttribute("message", "Email succesfully removed!");
				RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("alert", "Something went wrong! Please check the customer again.");
				RequestDispatcher rd = request.getRequestDispatcher("CorporationList.jsp");
				rd.forward(request, response);
			}
			break;
		}
		
		case "removeCustomerTelNum": {
			String telNum = (String)request.getParameter("value");
			Customer customer = new CustomerPreService().removeTelNum(id, telNum, user);
			
			if(customer != null) {
				request.setAttribute("customer", customer);
				request.setAttribute("message", "Tel. Num. succesfully removed!");
				RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("alert", "Something went wrong! Please check the customer again.");
				RequestDispatcher rd = request.getRequestDispatcher("CorporationList.jsp");
				rd.forward(request, response);
			}
			break;
		}
		
		case "removeCustomerAddress": {
			String address = (String)request.getParameter("value");
			Customer customer = new CustomerPreService().removeEmail(id, address, user);
			
			if(customer != null) {
				request.setAttribute("customer", customer);
				request.setAttribute("message", "Address succesfully removed!");
				RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("alert", "Something went wrong! Please check the customer again.");
				RequestDispatcher rd = request.getRequestDispatcher("CorporationList.jsp");
				rd.forward(request, response);
			}
			break;
		}
		
		default : {
			response.sendRedirect("index.jsp");
		}
		
		}
		
	}

}
