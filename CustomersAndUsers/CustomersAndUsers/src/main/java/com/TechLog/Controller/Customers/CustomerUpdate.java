package com.TechLog.Controller.Customers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Model.Corporations.Corporation;
import com.TechLog.Model.Customers.Customer;
import com.TechLog.Services.CustomerImp.CustomerServiceImp;


@WebServlet("/customerUpdate")
public class CustomerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		String job = request.getParameter("job");

		switch (job) {
		
		case "updateCorporationName": {
			Corporation corporation = new CustomerServiceImp().getCorporation(id, true);
			request.getSession(false).setAttribute("corporation", corporation);
			
			request.setAttribute("id", id);
			request.setAttribute("value", corporation.getName());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;			
		}
		
		case "updateCorporationSector": {
			Corporation corporation = new CustomerServiceImp().getCorporation(id, true);
			request.getSession(false).setAttribute("corporation", corporation);
			
			request.setAttribute("id", id);
			request.setAttribute("value", corporation.getSector());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;			
		}
		
		case "updateCustomerFirstname": {
			Customer customer = new CustomerServiceImp().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getFirstname());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
			
			request.getSession(false).setAttribute("customer", customer);
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "updateCustomerLastname": {
			Customer customer = new CustomerServiceImp().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getLastname());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
			
			request.getSession(false).setAttribute("customer", customer);
					
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "updateCustomerDepartment": {
			Customer customer = new CustomerServiceImp().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getDepartment());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
			
			request.getSession(false).setAttribute("customer", customer);
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "updateCustomerPosition": {
			Customer customer = new CustomerServiceImp().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getPosition());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
			
			request.getSession(false).setAttribute("customer", customer);
					
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}
		
		
		case "updateCustomerEmail": {
		
				CustomerServiceImp cs = new CustomerServiceImp();
				int index = Integer.parseInt(request.getParameter("index"));
				Customer customer = cs.getCustomer(id, true);
				String email = customer.getEmails().get(index);
				
				request.getSession(false).setAttribute("customer", customer);				

				request.setAttribute("id", id);
				request.setAttribute("job", job);
				request.setAttribute("value", email);
				request.setAttribute("formAction", "customerUpdate");

				RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
				rd.forward(request, response);
							
			break;
		}

		case "updateCustomerTelNum": {
			
			CustomerServiceImp cs = new CustomerServiceImp();
			int index = Integer.parseInt(request.getParameter("index"));
			Customer customer = cs.getCustomer(id, true);
			String telNum = customer.getTelNums().get(index);
			
			request.getSession(false).setAttribute("customer", customer);	

			request.setAttribute("job", job);
			request.setAttribute("id", id);
			request.setAttribute("value", telNum);
			request.setAttribute("formAction", "customerUpdate");

			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}

		case "updateCustomerAddress": {
			
			CustomerServiceImp cs = new CustomerServiceImp();
			int index = Integer.parseInt(request.getParameter("index"));
			Customer customer = cs.getCustomer(id, true);
			String address = customer.getAddresses().get(index);
			
			request.getSession(false).setAttribute("customer", customer);	

			request.setAttribute("job", job);
			request.setAttribute("id", id);
			request.setAttribute("value", address);
			request.setAttribute("formAction", "customerUpdate");

			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String job = request.getParameter("job");

		switch (job) {
		
		case "updateCorporationName": {
			
			request.getSession(false).setAttribute("newCorporationName", request.getParameter("output"));
			
			Corporation corporation = new CustomerServiceImp().updateCorporationName(request.getSession(false));
			if(corporation != null) {
				request.setAttribute("message", "Corporation Name succesfully updated!");
				request.setAttribute("corporation", corporation);
				
				RequestDispatcher rd = request.getRequestDispatcher("ShowCorporation.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("alert", "Corporation name update failed! This must be unique, also someone might be deleted or updated this data just before you. Please check the corporation name again.");
				request.setAttribute("corporation", corporation);
				
				RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
			
			break;
		}
		
		case "updateCorporationSector": {
			
			request.getSession(false).setAttribute("newCorporationSector", request.getParameter("output"));
			Corporation corporation = new CustomerServiceImp().updateCorporationSector(request.getSession(false));

			if(corporation != null) {
				request.setAttribute("message", "Corporation Sector succesfully updated!");
				request.setAttribute("corporation", corporation);
				
				RequestDispatcher rd = request.getRequestDispatcher("ShowCorporation.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("alert", "Corporation Sector update failed! Someone might be deleted or updated this data just before you! Please check the Corporation Sector again.");
				request.setAttribute("corporation", corporation);
				
				RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
			
			break;
		}
		
		case "updateCustomerFirstname": {

				request.getSession(false).setAttribute("newCustomerFirstname", request.getParameter("output"));
				Customer customer = new CustomerServiceImp().updateCustomerFirstname(request.getSession(false));
	
			if(customer != null) {
				request.setAttribute("customer", customer);
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
			
			request.getSession(false).setAttribute("newCustomerLastname", request.getParameter("output"));
			Customer customer = new CustomerServiceImp().updateCustomerLastname(request.getSession(false));

		if(customer != null) {
			request.setAttribute("customer", customer);
			request.setAttribute("message", "Lastname updated successfully!");
			
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
			
			request.getSession(false).setAttribute("newCustomerDepartment", request.getParameter("output"));
			Customer customer = new CustomerServiceImp().updateCustomerDepartment(request.getSession(false));

		if(customer != null) {
			request.setAttribute("customer", customer);
			request.setAttribute("message", "Department updated successfully!");
			
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
			
			request.getSession(false).setAttribute("newCustomerPosition", request.getParameter("output"));
			Customer customer = new CustomerServiceImp().updateCustomerPosition(request.getSession(false));

		if(customer != null) {
			request.setAttribute("customer", customer);
			request.setAttribute("message", "Position updated successfully!");
			
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
			
			request.getSession(false).setAttribute("newEmail", request.getParameter("output"));
			request.getSession(false).setAttribute("oldEmail", request.getParameter("oldValue"));
			
			Customer customer = new CustomerServiceImp().updateEmail(request.getSession(false));
			
			if(customer != null ) {
				
				request.setAttribute("customer", customer);
				request.setAttribute("message", "Email succesfully updated!");
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
			
			
			request.getSession(false).setAttribute("newTelNum", request.getParameter("output"));
			request.getSession(false).setAttribute("oldTelNum", request.getParameter("oldValue"));
			
			Customer customer = new CustomerServiceImp().updateTelNum(request.getSession(false));
			
			if(customer != null ) {
	
				request.setAttribute("customer", customer);
				request.setAttribute("message", "Tel. Num. succesfully updated!");
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
			
			request.getSession(false).setAttribute("newAddress", request.getParameter("output"));
			request.getSession(false).setAttribute("oldAddress", request.getParameter("oldValue"));
			
			Customer customer = new CustomerServiceImp().updateAddress(request.getSession(false));
			
			if(customer != null ) {
	
				request.setAttribute("customer", customer);
				request.setAttribute("message", "Address succesfully updated!");
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

		}

	}

}
