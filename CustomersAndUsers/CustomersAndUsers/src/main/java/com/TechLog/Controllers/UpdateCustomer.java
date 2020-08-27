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
import com.TechLog.Services.Corporation.CorporationPreService;
import com.TechLog.Services.Customer.CustomerPostService;
import com.TechLog.Services.Customer.CustomerPreService;
import com.TechLog.Services.DomainViewService.DomainViewService;


@WebServlet("/customerUpdate")
public class UpdateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		String job = request.getParameter("job") != null ? request.getParameter("job") : "";

		switch (job) {
		
		case "updateCorporationName": {
			Corporation corporation = new CorporationPostService().getCorporation(id, true);
			
			request.setAttribute("id", id);
			request.setAttribute("value", corporation.getName());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;			
		}
		
		case "updateCorporationSector": {
			Corporation corporation = new CorporationPostService().getCorporation(id, true);
			
			request.setAttribute("id", id);
			request.setAttribute("value", corporation.getSector());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;			
		}
		
		case "updateCustomerFirstname": {
			Customer customer = new CustomerPostService().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getFirstname());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "updateCustomerLastname": {
			Customer customer = new CustomerPostService().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getLastname());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "updateCustomerDepartment": {
			Customer customer = new CustomerPostService().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getDepartment());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");

			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "updateCustomerPosition": {
			Customer customer = new CustomerPostService().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getPosition());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}
		
		
		case "updateCustomerEmail": {
		
				int index = Integer.parseInt(request.getParameter("index"));
				Customer customer =  new CustomerPostService().getCustomer(id, true);
				String email = customer.getEmails().get(index);

				request.setAttribute("id", id);
				request.setAttribute("job", job);
				request.setAttribute("value", email);
				request.setAttribute("formAction", "customerUpdate");

				RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
				rd.forward(request, response);
							
			break;
		}

		case "updateCustomerTelNum": {
			
			int index = Integer.parseInt(request.getParameter("index"));
			Customer customer = new CustomerPostService().getCustomer(id, true);
			String telNum = customer.getTelNums().get(index);

			request.setAttribute("job", job);
			request.setAttribute("id", id);
			request.setAttribute("value", telNum);
			request.setAttribute("formAction", "customerUpdate");

			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}

		case "updateCustomerAddress": {
			
			int index = Integer.parseInt(request.getParameter("index"));
			Customer customer = new CustomerPostService().getCustomer(id, true);
			String address = customer.getAddresses().get(index);

			request.setAttribute("job", job);
			request.setAttribute("id", id);
			request.setAttribute("value", address);
			request.setAttribute("formAction", "customerUpdate");

			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}
		
		default : {
			response.sendRedirect("index.jsp");
			break;
		}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String job = request.getParameter("job") != null ? request.getParameter("job") : "";
		Long id = Long.parseLong(request.getParameter("id"));
		Users user = (Users)request.getSession(false).getAttribute("user");
		DomainViewService viewPermissions = new DomainViewService(user, user);

		switch (job) {
		
		case "updateCorporationName": {
			
			String newName = request.getParameter("output");
			String oldName = request.getParameter("oldValue");
			
			Corporation corporation = new CorporationPreService().updateCorporationName(id, oldName, newName, user);
			if(corporation != null) {
				request.setAttribute("message", "Corporation Name succesfully updated!");
				request.setAttribute("corporation", corporation);
    			request.setAttribute("viewPermissions", viewPermissions);
				
				RequestDispatcher rd = request.getRequestDispatcher("ShowCorporation.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("alert", "Corporation name update failed! This must be unique, also someone might be deleted or updated this data just before you. Please check the corporation name again.");
				request.setAttribute("corporation", corporation);
				request.setAttribute("viewPermissions", viewPermissions);
				
				RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
			
			break;
		}
		
		case "updateCorporationSector": {
			
			String newSector = request.getParameter("output");
			String oldSector = request.getParameter("oldValue");
			
			Corporation corporation = new CorporationPreService().updateCorporationSector(id, oldSector, newSector, user);

			if(corporation != null) {
				request.setAttribute("message", "Corporation Sector succesfully updated!");
				request.setAttribute("corporation", corporation);
				request.setAttribute("viewPermissions", viewPermissions);
				
				RequestDispatcher rd = request.getRequestDispatcher("ShowCorporation.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("alert", "Corporation Sector update failed! Someone might be deleted or updated this data just before you! Please check the Corporation Sector again.");
				request.setAttribute("corporation", corporation);
				request.setAttribute("viewPermissions", viewPermissions);
				
				RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
			
			break;
		}
		
		case "updateCustomerFirstname": {

				String newName = request.getParameter("output");
				String oldName = request.getParameter("oldValue");
				
				Customer customer = new CustomerPreService().updateCustomerFirstname(id, oldName, newName, user);
	
			if(customer != null) {
				request.setAttribute("customer", customer);
				request.setAttribute("viewPermissions", viewPermissions);
				request.setAttribute("message", "Firstname updated successfully!");
				
				RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("alert", "Firstname update failed! Someone might be deleted or updated this data just before you! Please check the Customer Firstname again.");
				
				RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
			break;
		}
		
		case "updateCustomerLastname": {
			
			String newName = request.getParameter("output");
			String oldName = request.getParameter("oldValue");
			
			Customer customer = new CustomerPreService().updateCustomerLastname(id, oldName, newName, user);

		if(customer != null) {
			request.setAttribute("customer", customer);
			request.setAttribute("message", "Lastname updated successfully!");
			request.setAttribute("viewPermissions", viewPermissions);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("alert", "Lastname update failed! Someone might be deleted or updated this data just before you! Please check the Customer Lastname again.");
			
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
		break;
		}
		
		case "updateCustomerDepartment": {
			
			String newDepartment = request.getParameter("output");
			String oldDepartment = request.getParameter("oldValue");
			Customer customer = new CustomerPreService().updateCustomerDepartment(id, oldDepartment, newDepartment, user);


		if(customer != null) {
			request.setAttribute("customer", customer);
			request.setAttribute("message", "Department updated successfully!");
			request.setAttribute("viewPermissions", viewPermissions);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("alert", "Department update failed! Someone might be deleted or updated this data just before you! Please check the Customer Department again.");
			
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
		break;
		}
		
		case "updateCustomerPosition": {
			
			String newPosition = request.getParameter("output");
			String oldPosition = request.getParameter("oldValue");
			Customer customer = new CustomerPreService().updateCustomerPosition(id, oldPosition, newPosition, user);

		if(customer != null) {
			request.setAttribute("customer", customer);
			request.setAttribute("message", "Position updated successfully!");
			request.setAttribute("viewPermissions", viewPermissions);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("alert", "Position update failed! Someone might be deleted or updated this data just before you! Please check the Customer Position again.");
			
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
		break;
		}
		
		case "updateCustomerEmail": {
			
			String newEmail = request.getParameter("output");
			String oldEmail = request.getParameter("oldValue");
			Customer customer = new CustomerPreService().updateCustomerEmail(id, oldEmail, newEmail, user);
			
			if(customer != null ) {
				
				request.setAttribute("customer", customer);
				request.setAttribute("message", "Email succesfully updated!");
				request.setAttribute("viewPermissions", viewPermissions);
				RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
				rd.forward(request, response);
			}
			
			else {
				request.setAttribute("alert", "Email update failed! Someone might be deleted or updated this customer's data just before you! Also, all email addresses must be unique! Please check the customer again.");
				RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
			
			break;
		}

		case "updateCustomerTelNum": {
			
			
			String newTelNum = request.getParameter("output");
			String oldTelNum = request.getParameter("oldValue");
			Customer customer = new CustomerPreService().updateCustomerTelNum(id, oldTelNum, newTelNum, user);
			
			if(customer != null ) {
	
				request.setAttribute("customer", customer);
				request.setAttribute("message", "Tel. Num. succesfully updated!");
				request.setAttribute("viewPermissions", viewPermissions);
				RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("alert", "Tel. Num. update failed! Someone might be deleted or updated this customer's data just before you! Also, all tel. Nums must be unique! Please check the customer again.");
				RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
			break;
		}

		case "updateCustomerAddress": {
			
			String newAddress = request.getParameter("output");
			String oldAddress = request.getParameter("oldValue");
			Customer customer = new CustomerPreService().updateCustomerAddress(id, oldAddress, newAddress, user);
			
			if(customer != null ) {
	
				request.setAttribute("customer", customer);
				request.setAttribute("message", "Address succesfully updated!");
				request.setAttribute("viewPermissions", viewPermissions);
				RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("alert", "Address update failed! Someone might be deleted or updated this customer's data just before you! Also, all addresses must be unique! Please check the customer again.");
				RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
			break;
		}
		
		default : {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}

		}

	}

}
