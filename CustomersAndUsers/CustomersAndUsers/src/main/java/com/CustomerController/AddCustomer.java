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
import com.TechLog.Services.UserImp.UserServiceImp;
import com.TechLog.Users.Users;

@WebServlet("/addCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int job = Integer.parseInt(request.getParameter("job"));
		
		
		switch(job) {
		
		/* case
		 * 1- create a customer from scratch 
		 * 2- add an email 
		 * 3- add a phone number
		 * 4- add an address 
		 */
		
		case 1: {
			
			List<Corporation> corporations = new CustomerServiceImp().getAllCorporations();
			request.setAttribute("corporations", corporations);
			RequestDispatcher rd = request.getRequestDispatcher("AddCustomer.jsp");
			rd.forward(request, response);	
			break;
		}
		
	case 2: {
		Long id = Long.parseLong(request.getParameter("id"));
		
		request.setAttribute("id", id);
		request.setAttribute("job", job);
		request.setAttribute("formAction", "addCustomer");
		request.setAttribute("placeholder", "Enter an Email");

		RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
		rd.forward(request, response);
		break;
	}

	case 3: {
		Long id = Long.parseLong(request.getParameter("id"));

		request.setAttribute("id", id);
		request.setAttribute("job", job);
		request.setAttribute("formAction", "addCustomer");
		request.setAttribute("placeholder", "Enter a Phone Number");

		RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
		rd.forward(request, response);
		break;
	}

	case 4: {
		Long id = Long.parseLong(request.getParameter("id"));

		request.setAttribute("id", id);
		request.setAttribute("job", job);
		request.setAttribute("formAction", "addCustomer");
		request.setAttribute("placeholder", "Enter an Address");

		RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
		rd.forward(request, response);
		break;
	}
		}
		
			
	}
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    		int job = Integer.parseInt(request.getParameter("job"));
    		Users user = new UserServiceImp().getUser(1L, false);
    		
    		
    		switch(job) {
    		
    		/* case
    		 * 1- create a customer from scratch 
    		 * 2- add an email 
    		 * 3- add phone number
    		 * 4- add an address
    		 */
    		
    		case 1: {
 
    			
    			String firstname = request.getParameter("firstname");
    			String lastname =request.getParameter("lastname");
    			String department = request.getParameter("department");
    			String position = request.getParameter("position");
    			String email = request.getParameter("email");
    			String telNum = request.getParameter("telNum");
    			String address = request.getParameter("address");
    			Long corpId = Long.parseLong(request.getParameter("corporation"));
    			
    			CustomerServiceImp cs = new CustomerServiceImp();
    			Customer customer = cs.createCustomer(firstname, lastname, corpId, department, position, email, telNum, address, user);
   			
    			request.setAttribute("customer", customer); 
    			request.setAttribute("message", customer.getFirstname() + " " + customer.getLastname() + " created succesfully!");
    			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp"); 
    			rd.forward(request, response);
    			break;
    		
    		}
    		
    	case 2: {
    		Long id = Long.parseLong(request.getParameter("id"));
    		String email = request.getParameter("output");

			Customer customer = new CustomerServiceImp().addEmail(id, email, user);
			
			request.setAttribute("customer", customer);
			request.setAttribute("message", email + " succesfully added!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}

		case 3: {
			Long id = Long.parseLong(request.getParameter("id"));
			String telNum = request.getParameter("output");

			Customer customer = new CustomerServiceImp().addTelNum(id, telNum, user);

			request.setAttribute("customer", customer);
			request.setAttribute("message", telNum + " succesfully added!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);

			break;
		}

		case 4: {
			Long id = Long.parseLong(request.getParameter("id"));
			String address = request.getParameter("output");

			Customer customer = new CustomerServiceImp().addAddress(id, address, user);

			request.setAttribute("customer", customer);
			request.setAttribute("message", address + " succesfully added!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);

			break;
		}
    		 	
	}

}
}
