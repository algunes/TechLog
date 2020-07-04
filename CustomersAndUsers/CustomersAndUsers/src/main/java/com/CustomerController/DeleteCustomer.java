package com.CustomerController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Customers.Customer;
import com.TechLog.Services.CustomerImp.CustomerServiceImp;
import com.TechLog.Users.Users;

@WebServlet("/deleteCustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		int job = Integer.parseInt(request.getParameter("job"));
		
		switch(job) {
		
		/*	case 
		 * 1- Delete a customer 
		 * 2- Delete an email 
		 * 3- Delete a phone number
		 * 4- delete an address
		 */
		
		case 1: {
			Customer customer = new CustomerServiceImp().removeCustomer(id);	
			request.setAttribute("message", customer.getFirstname() + " " + customer.getLastname() + " from " + customer.getCorporation().getName() +" deleted succesfully!");
			request.setAttribute("corporation", customer.getCorporation());			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCorporation.jsp");
			rd.forward(request, response);
			break;		
		}
		
	case 2: {

		int index= Integer.parseInt(request.getParameter("index"));

		CustomerServiceImp cservice = new CustomerServiceImp();
		Customer customer = cservice.removeEmail(id, index, new Users());

		request.setAttribute("customer", customer);
		request.setAttribute("message", "Email succesfully removed!");
		RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
		rd.forward(request, response);
		break;
	}

	case 3: {

		int index = Integer.parseInt(request.getParameter("index"));

		CustomerServiceImp cservice = new CustomerServiceImp();
		Customer customer = cservice.removeTelNum(id, index, new Users());

		request.setAttribute("customer", customer);
		request.setAttribute("message", "Tel. number succesfully removed!");
		RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
		rd.forward(request, response);
		break;
	}

	case 4: {

		int index = Integer.parseInt(request.getParameter("index"));

		CustomerServiceImp cservice = new CustomerServiceImp();
		Customer customer = cservice.removeAddress(id, index, new Users());

		request.setAttribute("customer", customer);
		request.setAttribute("message", "Address succesfully removed!");
		RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
		rd.forward(request, response);
		break;
	}
			
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
