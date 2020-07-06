package com.CustomerController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;
import com.TechLog.Services.CustomerImp.CustomerServiceImp;
import com.TechLog.Services.UserImp.UserServiceImp;
import com.TechLog.Users.Users;

@WebServlet("/deleteCustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		String job = request.getParameter("job");
		Users user = new UserServiceImp().getUser(1L, false);
		
		switch(job) {
		
		case "removeCorporation": {
			CustomerServiceImp cs = new CustomerServiceImp();
			Corporation corporation = cs.getCorporation(id, false);
			cs.removeCorporation(corporation);
			
			request.setAttribute("message", corporation.getName() + " and all of its records removed succesfully!");
			request.setAttribute("corporations", cs.getAllCorporations());
			
			RequestDispatcher rd = request.getRequestDispatcher("CorporationList.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "removeCustomer": {
			CustomerServiceImp cs = new CustomerServiceImp();
			Customer customer = cs.removeCustomer(id);	
			request.setAttribute("message", customer.getFirstname() + " " + customer.getLastname() + " from " + customer.getCorporation().getName() +" deleted succesfully!");
			request.setAttribute("corporation", cs.getCorporation(customer.getCorporation().getId(), true));			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCorporation.jsp");
			rd.forward(request, response);
			break;		
		}
		
	case "removeCustomerEmail": {

		int index= Integer.parseInt(request.getParameter("index"));

		CustomerServiceImp cservice = new CustomerServiceImp();
		Customer customer = cservice.removeEmail(id, index, user);

		request.setAttribute("customer", customer);
		request.setAttribute("message", "Email succesfully removed!");
		RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
		rd.forward(request, response);
		break;
	}

	case "removeCustomerTelNum": {

		int index = Integer.parseInt(request.getParameter("index"));

		CustomerServiceImp cservice = new CustomerServiceImp();
		Customer customer = cservice.removeTelNum(id, index, user);

		request.setAttribute("customer", customer);
		request.setAttribute("message", "Tel. number succesfully removed!");
		RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
		rd.forward(request, response);
		break;
	}

	case "removeCustomerAddress": {

		int index = Integer.parseInt(request.getParameter("index"));

		CustomerServiceImp cservice = new CustomerServiceImp();
		Customer customer = cservice.removeAddress(id, index, user);

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
